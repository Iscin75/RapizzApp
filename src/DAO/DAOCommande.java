package DAO;
import java.util.Vector;


import metier.*;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOCommande extends DAO {
	
	public static DAOCommande me;
	public static DAOCommande getThatDAO() {
		if (me==null)
			me= new DAOCommande();
		
		return me;
	}
	public DAOCommande() {
		
		super();
	}

	public Commande GetById(int id) throws SQLException {

		Commande toReturn  = null;
		String id_str = Integer.toString(id);
		
		ResultSet varReturn = query( "SELECT * FROM commandes WHERE id = "+ id_str + ";" );
		
		varReturn.next();
		int id1 = varReturn.getInt(1);
		Client client = DAOClient.getThatDAO().GetById( varReturn.getInt(2) ); 
		Pizza pizza = DAOPizza.getThatDAO().GetById( varReturn.getInt(3) );
		String taille = GetPizzaFormat(varReturn.getInt(4));
		float tarif = varReturn.getFloat(5);
		java.sql.Date date = varReturn.getDate(6);
		Livraison livraison = DAOLivraison.getThatDAO().GetById( varReturn.getInt(7) );
			
		toReturn = new Commande(id1, client, pizza, taille, tarif, date, livraison);
		
		varReturn.close();
		return toReturn;
	}

	public int GetMostFamousSize() throws SQLException {

		int toReturn  = 0;
		
		ResultSet varReturn = query( "SELECT taille FROM commandes GROUP BY taille ORDER BY count(taille) DESC limit 1;" );
		
		varReturn.next();
		int id1 = varReturn.getInt(1);
		
		toReturn = id1;
		
		varReturn.close();
		return toReturn;
	}
	
	public Vector<Commande> GetAll() throws SQLException {
		Vector<Commande> allCmd = new Vector<Commande>();
		
		ResultSet varReturn = query( "SELECT * FROM commandes;" );
		while( varReturn.next() )
		{
			int id = varReturn.getInt(1);
			Client client = DAOClient.getThatDAO().GetById( varReturn.getInt(2) ); 
			Pizza pizza = DAOPizza.getThatDAO().GetById( varReturn.getInt(3) );
			String taille = GetPizzaFormat(varReturn.getInt(4));
			float tarif = varReturn.getFloat(5);
			java.sql.Date date = varReturn.getDate(6);
			Livraison livraison = DAOLivraison.getThatDAO().GetById( varReturn.getInt(7) );
			
			allCmd.add( new Commande(id, client, pizza, taille, tarif, date, livraison));
		}
		
		return allCmd;
	}
	
	public String GetPizzaFormat(int id) throws SQLException
	{
		String format = "";
		
		ResultSet varReturn = query("SELECT nom FROM formats_pizzas WHERE id= " + id);;
		
		while(varReturn.next())
		{
			format = varReturn.getString(1);
		}
		
		varReturn.close();
		return format;
	}
	
	


}
