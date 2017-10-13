package agenda;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.InfoBdd;

/**
 * Servlet implementation class SelectInfoBdd
 */

@WebServlet("/SelectInfoBdd")
public class SelectInfoBdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectInfoBdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		if (request.getParameter("nom") == null || request.getParameter("prenom")==null) {
		  out.println("Veuillez saisir les paramètres !");
		}
		String prenom=request.getParameter("prenom");
		String nom=request.getParameter("nom");
		
		InfoBdd ibd = new InfoBdd("jdbc:mysql://localhost:3306/agenda", "root", "root");
		String result = ibd.getInfoUser(nom, prenom);
		
	    	request.setAttribute("user", result);
	    	RequestDispatcher view = request.getRequestDispatcher("displayName.jsp");
	    	view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
