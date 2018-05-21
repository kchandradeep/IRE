package s1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p1.DAO;

/**
 * Servlet implementation class CalcPremium
 */
public class CalcPremium extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcPremium() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vehicleType = request.getParameter("vehicleType");
		String proof = request.getParameter("proof");
		String dClass = request.getParameter("dClass");
		String safety = request.getParameter("safety");
		String antiTheft = request.getParameter("antiTheft");
		String violation = request.getParameter("violation");
		String policy = request.getParameter("policy");
		PrintWriter out = response.getWriter();
		//out.println(vehicleType + " " + proof + " " + dClass + " " + safety + " " +antiTheft + " " + violation + " " + policy);
		HttpSession session = request.getSession(false);
		int base = (Integer)session.getAttribute("base");
	float premium = DAO.getImpactPct(vehicleType,proof,dClass,safety,antiTheft,violation,policy,base);
	out.println("basePremium = "+premium);
	session.setAttribute("premium", premium);
	//response.sendRedirect();
	
	}

}
