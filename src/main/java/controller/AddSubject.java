package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Subject;

import dao.SubjectDAO;


public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddSubject() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sbjName = request.getParameter("sbjName");
		String clsName = request.getParameter("clsName");
		String tchName = request.getParameter("tchName");
		
		SubjectDAO sbjdao = new SubjectDAO();
		Subject sbj = new Subject(sbjName,tchName,clsName);
		PrintWriter out =response.getWriter();
		try {
			if(sbjName != null && tchName != null && clsName != null) {
				sbjdao.addSubject(sbj);
				out.println("<body style = 'background-color: #f2f2f2'> ");
				out.println("<h3 style='color:green'>Class Details Added Succesfull...</h3>");
				out.println("<a href='addSubject.html'>Back</a>");
				out.println("<a href='adminPage.jsp'>Home Page</a>");
				out.println("</body>");
			}
			else {
				out.println("<h5 style='color:red'>Data Not Added</h5>");
				response.sendRedirect("addSubject.html");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
