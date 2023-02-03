package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ClassDetails;

import dao.ClassDAO;


public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ClassDAO cdao = new ClassDAO();
		
		String Classname = request.getParameter("class");
		String section = request.getParameter("section");
		ClassDetails cdts = new ClassDetails(Classname,section);
		
		PrintWriter out = response.getWriter();
		
		try {
			if(Classname != null && section != null) {
				cdao.addClass(cdts);
				out.println("<body style = 'background-color: #f2f2f2'> ");
				out.println("<h3 style='color:green'>Calss Added Succesfull...</h3>");
				out.println("<a href='addClass.html'>Back</a>");
				out.println("<a href='adminPage.jsp'>Home Page</a>");
				out.println("</body>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
