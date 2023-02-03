<%@page import="java.util.*"%>
<%@page import="dao.TeacherDAO"%>
<%@page import="com.model.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Learner's Academy</title>
<style type="text/css">
body{
background-color: #f2f2f2;
}
h3{
font-family: monospace;
font-size: 36px; 
color : #000066;
}
table,th,td{
border : 1px solid #0000cc;
border-collapse :collapse;
font-size: 26px;
}
th {
  background-color: #04AA6D;
  color: white;
}
tr:nth-child(even) {
background-color: #99ccff;
}
td{
color : #003300;
}
th, td {
  padding: 15px;
  text-align: left;
}
</style>
</head>
<body>

<h3>Teacher List</h3>

<table>

	<tr>
	<th>Teacher Name</th>
	<th>Subject Name</th>
	<th>Class </th>
	</tr>
	
	<%
		TeacherDAO tchDao = new TeacherDAO();
		List<Teacher> list = new ArrayList<Teacher>();
		
		list= tchDao.showTeachers();
		
		for(Teacher tch : list) {
	%>
	
	<tr>
	<td><%= tch.getTchName() %></td>
	<td><%= tch.getSubject() %></td>
	<td><%= tch.getClassname() %></td>
	</tr>
	
	<% } %>

</table>

<br>
<a href="adminPage.jsp">Back</a>
</body>
</html>