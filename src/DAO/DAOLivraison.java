package DAO;

import java.util.Vector;

import metier.Livraison;


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

	public Livraison GetById(int id) {

		Livraison toReturn = null;
		
		// TODO A faire !
		
		return toReturn;
	}

	public Vector<Livraison> GetAll() {
		Vector<Livraison> toReturn = new Vector<Livraison>(); 
		// TODO A faire !
		return toReturn;
	}
	

}
