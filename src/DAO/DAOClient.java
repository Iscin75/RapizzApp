package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
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

	public Client GetById(int id) throws SQLException {

		Client toReturn = null;
		
		String id_str = Integer.toString(id);
		
		ResultSet varReturn = query( "SELECT * FROM clients WHERE id = " + id_str + ";");
        varReturn.next();
		toReturn = new Client( 
				varReturn.getInt(1),
				varReturn.getString(2),
				varReturn.getString(3),
				varReturn.getString(4),
				varReturn.getString(5),
				varReturn.getFloat(6),
				varReturn.getInt(7));
		
		//System.out.print("test");
		varReturn.close();
		return toReturn;
	}

	public Vector<Client> GetAll() {
		Vector<Client> toReturn = new Vector<Client>(); 
		// TODO A faire !
		return toReturn;
	}
	

}
