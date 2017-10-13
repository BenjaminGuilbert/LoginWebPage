package agenda;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Connection conn;
		if (request.getParameter("nom") == null || request.getParameter("prenom")==null) {
		  out.println("Veuillez saisir les paramètres !");
		}
		String prenom=request.getParameter("prenom");
		String nom=request.getParameter("nom");
		try {
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		  String url = "jdbc:mysql://localhost:3306/agenda";
		  conn = DriverManager.getConnection(url, "root", "root");
		  try {
		    Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery(
		       "SELECT * FROM UTILISATEUR WHERE prenom='"+prenom+"' AND nom='"+nom+"'");
		    if (rs.next()) { out.println("Bonjour "+prenom+" "+nom); }
		    else { out.println("Vous n'êtes pas connu"); }
		  } catch (SQLException ex) {System.err.println(ex.getMessage());}
		}
		catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());}
		catch (IllegalAccessException ex) {System.err.println(ex.getMessage());}
		catch (InstantiationException ex) {System.err.println(ex.getMessage());}
		catch (SQLException ex)           {System.err.println(ex.getMessage());}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
