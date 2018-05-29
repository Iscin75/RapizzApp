package DAO;

import java.util.Vector;

import metier.Livreur;

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

	public Livreur GetById(int id) {

		Livreur toReturn = null;
		
		// TODO A faire !
		
		return toReturn;
	}

	public Vector<Livreur> GetAll() {
		Vector<Livreur> toReturn = new Vector<Livreur>(); 
		// TODO A faire !
		return toReturn;
	}

}
