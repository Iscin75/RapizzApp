package DAO;
import java.util.Vector;


import metier.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
	

	public Commande GetById(int id) {

		Commande toReturn = null;
		
		// TODO A faire !
		
		return toReturn;
	}

	public Vector<Commande> GetAll() {
		Vector<Commande> allCmd = new Vector<Commande>();
		
		ResultSet varReturn;
		try {
			varReturn = query( "SELECT * FROM commandes;" );
			while( varReturn.next() )
			{
				int id = varReturn.getInt(1);
				Client client = DAOClient.getThatDAO().GetById( varReturn.getInt(2) ); 
				Pizza pizza = DAOPizza.getThatDAO().GetById( varReturn.getInt(3) );
				int taille = varReturn.getInt(4);
				float tarif = varReturn.getFloat(5);
				java.sql.Date date = varReturn.getDate(6);
				Livraison livraison = DAOLivraison.getThatDAO().GetById( varReturn.getInt(7) );
				
				allCmd.add( new Commande(id, client, pizza, taille, tarif, date, livraison));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allCmd;
	}
	
	


}
