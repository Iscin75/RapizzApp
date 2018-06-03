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
	
	public int GetNbDeliveryById( int id ) throws SQLException {
		
		int toReturn = 0;
		
		String id_str = Integer.toString(id);
		
		ResultSet varReturn = query( "SELECT COUNT(li.statut) FROM livreur as l, livraisons as li WHERE li.livreur = l.id AND li.livreur = " + id_str + ";");
        
		if( varReturn.next())
		{
	        int nb_retard = varReturn.getInt(1);
	    	
			toReturn = nb_retard; 
		}
		else
			toReturn = 0;
		
		varReturn.close();
		return toReturn;
	}
	
	public int GetNbLateDeliveryById( int id ) throws SQLException {

		int toReturn = 0;
		
		String id_str = Integer.toString(id);
		
		ResultSet varReturn = query( "SELECT COUNT(li.statut) FROM livreur as l, livraisons as li WHERE li.livreur = l.id AND li.statut = 'retard' AND li.livreur = " + id_str + ";");
		
		if( varReturn.next())
		{
	        int nb_retard = varReturn.getInt(1);
	    	
			toReturn = nb_retard; 
		}
		else
			toReturn = 0;
		
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
