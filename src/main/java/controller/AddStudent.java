package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;

import dao.StudentDAO;


public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public AddStudent() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAO addStd = new StudentDAO();
		
		String stdName = request.getParameter("stdName");
		String rollNo = request.getParameter("rollNo");
		String Classname = request.getParameter("class");
		String sql="insert into student(StudentName,StudentAge)values(?,?)";
		PrintWriter out = response.getWriter();
		
		Student std = new Student(stdName,rollNo,Classname);
		try {
			if(stdName == null && rollNo == null && Classname == null) {
				out.println("<h5 style = 'color:red'>Please give some input</h5>");
				response.sendRedirect("addStudent.html");
			}
			else {
				addStd.addStudent(std);
				out.println("<body style = 'background-color: #f2f2f2'> ");
				out.println("<h3 style = 'color:green'>Student Record Added Succesfully...</h3>");
				out.println("<a href='addStudent.html'>Back</a>");
				out.println("<a href='adminPage.jsp'>Home Page</a>");
				out.println("</body");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
