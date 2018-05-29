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

	public Vector<Client> GetAll() throws SQLException {
		Vector<Client> toReturn = new Vector<Client>(); 
		
		ResultSet varReturn = query( "SELECT * FROM clients;");
        while( varReturn.next())
        {
        	int id1 = varReturn.getInt(1);
        	String nom = varReturn.getString(2);
        	String prenom = varReturn.getString(3);
        	String adresse = varReturn.getString(4);
        	String ville = varReturn.getString(5);
        	float solde = varReturn.getFloat(6);
        	int nombreCommande = varReturn.getInt(7);
        	
			toReturn.add (new Client(
					id1,
					nom,
					prenom,
					adresse,
					ville,
					solde,
					nombreCommande));
        }
		
		varReturn.close();
		return toReturn;
	}
	

}
