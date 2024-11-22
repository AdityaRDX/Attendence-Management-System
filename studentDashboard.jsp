<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Student Dashboard</h2>
<p>Welcome, <%= ((User) request.getSession().getAttribute("user")).getUsername() %></p>
</body>
</html>