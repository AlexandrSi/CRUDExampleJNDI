<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<sql:query var="listUsers" dataSource="jdbc/UsersDB">
    select * from users;
</sql:query>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users List</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of users</h2></caption>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>subname</th>
            <th>age</th>
        </tr>
        <c:forEach var="user" items="${listUsers.rows}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.subname}" /></td>
                <td><c:out value="${user.age}" /></td>
                <td><a href="ControlUser?action=edit&userId=<c:out value="${user.id}"/>&userName=<c:out value="${user.name}"/>&userSubname=<c:out value="${user.subname}"/>&userAge=<c:out value="${user.age}"/>">Update</a></td>
                <td><a href="ControlUser?action=delete&userId=<c:out value="${user.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<hr>
<form action="ControlUser" method="post">
    <fieldset>
        <legend>Personal information:</legend>
        Id:<br>
        <input type="text" readonly="readonly" name="id" value="${requestScope.id}"><br>
        First name:<br>
        <input type="text" name="name" value="${requestScope.name}"><br>
        Last name:<br>
        <input type="text" name="subname" value="${requestScope.subname}"><br>
        Age:<br>
        <input type="text" name="age" value="${requestScope.age}"><br><br>
        <input type="submit" name="submit" value="${requestScope.submit}">
    </fieldset>
</form>
</body>
</html>