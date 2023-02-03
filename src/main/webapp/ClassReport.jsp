<%@page import="java.sql.ResultSet"%>
<%@page import="dao.DBConncetion"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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

<h3>Class Report</h3>

<div>

<table>

<tr>
<th>ID</th>
<th>Student Name</th>
<th>Roll No.</th>
<th>Teacher Name</th>
<th>Subject Name</th>
<th>Class</th>
<th>Section </th>
</tr>


<%
Connection con = null;
PreparedStatement stmt = null;

String query="select a.id,a.studentName,a.rollNo,b.teachername,c.subjectname,d.class,d.section from student as a inner join teacher as b on a.class=b.class inner join subject as c on b.class=c.class inner join class as d on c.class=d.class";

try {
	con = DBConncetion.getConnection();
	stmt = con.prepareStatement(query);
	
	ResultSet rs = stmt.executeQuery();
	
	if(rs.next() == false){
		out.println("No records found");
	}
	else { 
			do { %>
				
				<tr>
					<td><%= rs.getInt(1) %></td>
					<td><%= rs.getString(2) %></td>
					<td><%= rs.getInt(3) %></td>
					<td><%= rs.getString(4) %></td>
					<td><%= rs.getString(5) %></td>
					<td><%= rs.getString(6) %></td>
					<td><%= rs.getString(7) %></td>
		<% 	}
			while(rs.next()); %>
			
				</tr>
		
<% 	}
}
catch (Exception e){
	out.println(e.getMessage());
}
%>

</table>
<br>
<a href="adminPage.jsp">Home Page</a>
</div>

</body>
</html>