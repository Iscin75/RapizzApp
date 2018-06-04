package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import metier.*;


public class DAOLivraison extends DAO {
	
	public static DAOLivraison me;
	public static DAOLivraison getThatDAO() {
		if (me==null)
			me= new DAOLivraison();
		
		return me;
	}
	public DAOLivraison() {
		super();
	}
	public Livraison GetById(int id)  throws SQLException {

		Livraison toReturn = null;
		
		ResultSet varReturn;
		varReturn = query( "SELECT * FROM livraisons WHERE id = " + Integer.toString(id) + ";");
		
		if( varReturn.next() )
		{
			int id1 = varReturn.getInt(1);
			Livreur livreur = DAOLivreur.getThatDAO().GetById(varReturn.getInt(2));
			Transport transport = DAOTransport.getThatDAO().GetById(varReturn.getInt(4));
			EtatLivraison etatLivraison = EtatLivraison.valueOf(varReturn.getString(5));
			
			toReturn = new Livraison( id1, livreur, transport, etatLivraison );
		}
		
		varReturn.close();
		return toReturn;
	}

	public Vector<Livraison> GetAll()  throws SQLException {
		Vector<Livraison> toReturn = new Vector<Livraison>(); 
		ResultSet varReturn;
		varReturn = query( "SELECT * FROM livraisons;");
		
		while(varReturn.next())
		{
			int id1 = varReturn.getInt(1);
			Livreur livreur = DAOLivreur.getThatDAO().GetById(varReturn.getInt(2));
			Transport transport = DAOTransport.getThatDAO().GetById(varReturn.getInt(4));
			EtatLivraison etatLivraison = EtatLivraison.valueOf(varReturn.getString(5));
			
			toReturn.add(new Livraison( id1, livreur, transport, etatLivraison ));
		}
		
		varReturn.close();
		return toReturn;
	}
	

}
