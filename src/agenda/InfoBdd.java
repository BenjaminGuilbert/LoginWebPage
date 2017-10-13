package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InfoBdd {
	
	private String _url; 
	private String _login;
	private String _pwd;
	
	public InfoBdd(String url, String login, String pwd) {
		_url =url;
		_login =login;
		_pwd = pwd;
	}
	
	public String getInfoUser(String nom, String prenom) {
		try {
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			  Connection conn = DriverManager.getConnection(_url, _login, _pwd);
			  try {
			    Statement st = conn.createStatement();
			    ResultSet rs = st.executeQuery("SELECT * FROM UTILISATEUR WHERE prenom='"+prenom+"' AND nom='"+nom+"'");
			    if (rs.next()) { 
			    		return prenom+" "+nom; 
			    	}
			    else { 
			    		return null;
			    	}
			  } catch (SQLException ex) {System.err.println(ex.getMessage());}
		}
		catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());}
		catch (IllegalAccessException ex) {System.err.println(ex.getMessage());}
		catch (InstantiationException ex) {System.err.println(ex.getMessage());}
		catch (SQLException ex)           {System.err.println(ex.getMessage());}
		
		return null;
	}

}
