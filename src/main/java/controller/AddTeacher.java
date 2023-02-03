package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Teacher;

import dao.TeacherDAO;


public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tchName = request.getParameter("tchName");
		String subject = request.getParameter("subject");
		String Classname = request.getParameter("class");
		
		TeacherDAO addtch = new TeacherDAO();
		Teacher tch = new Teacher(tchName,subject,Classname);
		PrintWriter out = response.getWriter();
		try {
			if(tchName != null && subject != null && Classname != null) {
			addtch.addTeacher(tch);
			out.println("<body style = 'background-color: #f2f2f2'> ");
			out.println("<h3 style='color:green'>Teacher Details Added Succesfully...</h3>");
			out.println("<a href='addTeacher.html'>Back</a>");
			out.println("<a href='adminPage.jsp'>Home Page</a>");
			out.println("</body");
			}
			else {
				out.println("<h5 style='color:red'>Failed to add teacher details...</h3>");	
				response.sendRedirect("addTeacher.html");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
