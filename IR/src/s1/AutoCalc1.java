package s1;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p1.DAO;

/**
 * Servlet implementation class AutoCalc1
 */
public class AutoCalc1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoCalc1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String car = request.getParameter("cars");
		//PrintWriter out = response.getWriter();
		//out.println(car);
		int base = DAO.getModel(car);
		
		Object[] arr = new Object[2];
		
			arr[0] = car;
			arr[1] = base;
		
		
		HttpSession session = request.getSession(false);
		session.setAttribute("arr",arr);
		session.setAttribute("base", base);
		
		response.sendRedirect("CalcAuto1.jsp");
		
		
	}

}
