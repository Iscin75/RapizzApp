package DAO;

import java.util.Vector;

import metier.Livraison;
import metier.Transport;

public class DAOTransport extends DAO {
	public static DAOTransport me;
	public static DAOTransport getThatDAO() {
		if (me==null)
			me= new DAOTransport();
		
		return me;
	}
	
	public DAOTransport() {

		super();
	}

	public Transport GetById(int id) {

		Transport toReturn = null;
		
		// TODO A faire !
		
		return toReturn;
	}

	public Vector<Transport > GetAll() {
		Vector<Transport > toReturn = new Vector<Transport >(); 
		// TODO A faire !
		return toReturn;
	}

}
