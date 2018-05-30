package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import metier.EtatLivraison;
import metier.Livraison;
import metier.Livreur;
import metier.Transport;

public class DAOLivreur extends DAO {
	
	public static DAOLivreur me;
	public static DAOLivreur getThatDAO() {
		if (me==null)
			me= new DAOLivreur();
		
		return me;
	}
	public DAOLivreur() {
		super();
	}

	public Livreur GetById(int id)  throws SQLException {

		Livreur toReturn = null;
		
		ResultSet varReturn;
		varReturn = query( "SELECT * FROM livreur WHERE id = " + Integer.toString(id) + ";");
		
		varReturn.next();
		int id1 = varReturn.getInt(1);
		String nom = varReturn.getString(2);
		String prenom = varReturn.getString(3);
		
		toReturn = new Livreur( id1, nom, prenom );
		
		varReturn.close();
		return toReturn;
	}

	public Vector<Livreur> GetAll()  throws SQLException {
		Vector<Livreur> toReturn = new Vector<Livreur>(); 
		ResultSet varReturn;
		varReturn = query( "SELECT * FROM livreur;");
		
		while( varReturn.next())
		{
			int id1 = varReturn.getInt(1);
			String nom = varReturn.getString(2);
			String prenom = varReturn.getString(3);
		
			toReturn.add(new Livreur( id1, nom, prenom ));
		}
		
		varReturn.close();
		return toReturn;
	}

}
