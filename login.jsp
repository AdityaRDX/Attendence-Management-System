<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AttendanceController" method="post">
    <input type="hidden" name="action" value="login">
    <label>Username: <input type="text" name="username"></label><br>
    <label>Password: <input type="password" name="password"></label><br>
    <button type="submit">Login</button>
</form>
<% if (request.getParameter("error") != null) { %>
    <p style="color:red;">Invalid Credentials!</p>
<% } %>
</body>
</html>