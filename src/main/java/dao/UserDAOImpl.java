package dao;

import model.Users;
import utill.DBUtil;
import java.sql.*;

public class UserDAOImpl implements UserDAO {

    private Connection conn;
    public UserDAOImpl() {
        try {
            conn= DBUtil.getConection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(Users user) {
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = conn.prepareStatement("INSERT INTO users(name, subname, age) VALUES (?,?,?) ");
            preparedStatement.setString(1, user.getName() );
            preparedStatement.setString(2, user.getSubname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Users user) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("update users set name=?, subname=?, age=? WHERE id=?");
            preparedStatement.setString( 1, user.getName() );
            preparedStatement.setString( 2, user.getSubname());
            preparedStatement.setInt( 3, user.getAge());
            preparedStatement.setInt( 4, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userID) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM users WHERE id=?");
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
