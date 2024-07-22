<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Student List</h1>
	<ol>
		<li><%= request.getParameter("name") %></li>
		<li><%= request.getParameter("age") %></li>
		<li><%= request.getParameter("age") %></li>
		<li>Ram</li>
		<li><%= request.getRemoteAddr() %></li>
	</ol>
</body>
</html>