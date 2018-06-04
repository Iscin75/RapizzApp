package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
	
	public Transport GetById(int id)  throws SQLException {

		Transport toReturn = null;
		
		ResultSet varReturn;
		varReturn = query( "SELECT * FROM transports WHERE id = " + Integer.toString(id) + ";");
		
		if( varReturn.next() )
		{
			int id1 = varReturn.getInt(1);
			String nom = varReturn.getString(2);
			
			toReturn = new Transport( id1, nom );
		}
		
		varReturn.close();
		return toReturn;
	}

	public Vector<Transport > GetAll()  throws SQLException {
		Vector<Transport > toReturn = new Vector<Transport >(); 
		ResultSet varReturn;
		varReturn = query( "SELECT * FROM transports;");
		
		while( varReturn.next())
		{
			int id1 = varReturn.getInt(1);
			String nom = varReturn.getString(2);
			
			toReturn.add( new Transport( id1, nom ));
		}
		
		varReturn.close();
		return toReturn;
	}

}
