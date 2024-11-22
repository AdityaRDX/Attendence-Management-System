<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Faculty Dashboard</h2>
<form action="AttendanceController" method="post">
    <input type="hidden" name="action" value="markAttendance">
    <button type="submit">Mark Attendance</button>
</form>
<% if (request.getParameter("success") != null) { %>
    <p style="color:green;">Attendance Marked!</p>
<% } %>
</body>
</html>