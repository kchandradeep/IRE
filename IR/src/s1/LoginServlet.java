package s1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p1.DAO;
import p1.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		
		try {
			 UserBean details = DAO.isUser(userID,password);
			 
			 if(details.getRole() != null)
			 {
			 if(details.getRole().equalsIgnoreCase("admin"))
			 {
				 response.sendRedirect("Admin.jsp");
			 }
			 else if(details.getRole().equalsIgnoreCase("user"))
				 response.sendRedirect("Underwriter.jsp");
			 else
				 out.println("invalid role");
			 }
			 else
				 out.println("invalid user");
		} catch (SQLException e) {
			out.println("hele");
			e.printStackTrace();
		}
	}

}
