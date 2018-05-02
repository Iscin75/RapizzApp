package DAO;
import DAOInterface.DAOClient;
import DAOInterface.DAOCommande;
import DAOInterface.DAOIngredient;
import DAOInterface.DAOLivraison;
import DAOInterface.DAOLivreur;
import DAOInterface.DAOPizza;
import DAOInterface.DAOTransport;
import DAOTest.*;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DAOFactory {
	
	public Connection conn;
	public static DAOFactory db;
	
	private DAOFactory()
	{
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "Rapizz";
		String driver = "com.mysql.jdbc.Driver";
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "");
		properties.setProperty("useSSL", "false");
		properties.setProperty("autoReconnect", "true");
		
		try {
	            Class.forName(driver).newInstance();
	            this.conn = (Connection)DriverManager.getConnection(url+dbName,properties);
	        }
	        catch (Exception sqle) {
	            sqle.printStackTrace();
	        }
	 }
	
	public static synchronized DAOFactory getConnection() {
        if ( db == null ) {
            db = new DAOFactory();
        }
        return db;
    }
	
	
	static public DAOCommande theDAOCommande;
	
	static public DAOCommande GetMeDAOCommande() {
		if (theDAOCommande==null) {
			theDAOCommande=new DAOCommandeImplTest();
		}
		return theDAOCommande;
	}
	
	static public DAOClient theDAOClient;
	
	static public DAOClient GetMeDAOClient() {
		if (theDAOClient==null) {
			theDAOClient=new DAOClientImplTest();
		}
		return theDAOClient;
	}
	
	static public DAOPizza theDAOPizza;
	
	static public DAOPizza GetMeDAOPizza() {
		if (theDAOPizza==null) {
			theDAOPizza=new DAOPizzaImplTest();
		}
		return theDAOPizza;
	}
	
	static public DAOIngredient theDAOIngredient  ;
	
	static public DAOIngredient  GetMeDAOIngredient () {
		if (theDAOIngredient ==null) {
			theDAOIngredient =new DAOIngredientImplTest();
		}
		return theDAOIngredient ;
	}
	
	static public DAOLivraison theDAOLivraison ;
	
	static public DAOLivraison   GetMeDAOLivraison  () {
		if (theDAOLivraison  ==null) {
			theDAOLivraison  =new DAOLivraisonImplTest();
		}
		return theDAOLivraison  ;
	}
	
	
	static public DAOLivreur theDAOLivreur ;
	
	static public DAOLivreur  GetMeDAOLivreur () {
		if (theDAOLivreur  ==null) {
			theDAOLivreur  =new DAOLivreurImplTest();
		}
		return theDAOLivreur  ;
	}
	
	
	static public DAOTransport theDAOTransport ;
	
	static public DAOTransport    GetMeDAOTransport  () {
		if (theDAOTransport   ==null) {
			theDAOTransport  =new DAOTransportImplTest();
		}
		return theDAOTransport   ;
	}
	
}
