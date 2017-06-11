package control;

import dao.UserDAOImpl;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet ("/ControlUser")
public class ControlUser extends HttpServlet {
    UserDAOImpl dao=new UserDAOImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if( action.equalsIgnoreCase("delete") ) {
            int userId = Integer.parseInt( request.getParameter("userId"));
            dao.deleteUser(userId);
            request.setAttribute("submit","Add");
        }else if (action.equalsIgnoreCase("edit")) {
            request.setAttribute("id",request.getParameter("userId"));
            request.setAttribute("name",request.getParameter("userName"));
            request.setAttribute("subname",request.getParameter("userSubname"));
            request.setAttribute("age",request.getParameter("userAge"));
            request.setAttribute("submit","Update");
        } else if (action.equalsIgnoreCase("add"))request.setAttribute("submit","Add");
        request.getRequestDispatcher("/form.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = new Users();
        int id = 0;
        if (request.getParameter("id") != "")  id = Integer.parseInt(request.getParameter("id"));
        user.setId(id);
        user.setName(request.getParameter("name"));
        user.setSubname(request.getParameter("subname"));
        int age = Integer.parseInt(request.getParameter("age"));
        user.setAge(age);
        String action = request.getParameter("submit");
        if (action.equalsIgnoreCase("Update")) {
            dao.updateUser(user);
        } else {
            dao.addUser(user);
        }
        request.setAttribute("submit","Add");
        request.getRequestDispatcher("/form.jsp").forward(request, response);
    }
}