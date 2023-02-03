package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if(username.equalsIgnoreCase("admin@learner.com") && password.equalsIgnoreCase("admin@123")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("adminPage.jsp");
			rd.forward(request, response);
		}
		
		else {
			
			out.println("<h4 style='color:red'>Invalid Username or password</h4>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
