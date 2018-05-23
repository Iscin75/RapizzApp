package DAO;

import java.util.Vector;

import metier.Client;

public class DAOClient extends DAO {

	public static DAOClient me;
	public static DAOClient getThatDAO() {
		if (me==null)
			me= new DAOClient();
		
		return me;
	}
	public DAOClient() {
		super();
	}

	public Client GetById(int id) {

		Client toReturn = null;
		
		/*ResultSet varReturn = make.resquest( "SELECT * FROM pizzas WHERE id = %d", id );
		
		Client client = new Client( varReturn.getInt(1), varReturn.getString(2), varReturn.getFloat(3));
		*/
		
		return toReturn;
	}

	public Vector<Client> GetAll() {
		Vector<Client> toReturn = new Vector<Client>(); 
		// TODO A faire !
		return toReturn;
	}
	

}
