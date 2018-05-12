package s1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p1.DAO;
import p1.UserBean;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		HttpSession session;
		String username;
		try {
			 UserBean details = DAO.isUser(userID,password);
			 
			 if(details.getRole() != null)
			 {
			 if(details.getRole().equalsIgnoreCase("admin"))
			 {
				 session = request.getSession(true);
				username = details.getUserName();
		
				 session.setAttribute("username",username);
				 response.sendRedirect("Admin.jsp");
				 
			 }
			 else if(details.getRole().equalsIgnoreCase("user"))
			 {
				session = request.getSession(true);
				session.setAttribute("username",details.getUserName());
				response.sendRedirect("Underwriter.jsp");
			 }
				else
				 out.println("invalid role");
			 }
			 else
				 out.println("invalid user");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
