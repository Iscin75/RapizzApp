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
        
        int id1 = varReturn.getInt(1);
    	String nom = varReturn.getString(2);
    	String prenom = varReturn.getString(3);
    	String adresse = varReturn.getString(4);
    	String ville = varReturn.getString(5);
    	float solde = varReturn.getFloat(6);
    	
		toReturn = new Client(
				id1,
				nom,
				prenom,
				adresse,
				ville,
				solde);
		
		//System.out.print("test");
		varReturn.close();
		return toReturn;
	}

	public int GetNbOrderById( int id ) throws SQLException {

		int toReturn = 0;
		
		String id_str = Integer.toString(id);
		
		ResultSet varReturn = query( "SELECT count(co.client) FROM clients as c, commandes as co WHERE c.id = co.client AND co.client = " + id_str + ";");
        
		if( varReturn.next() )
        {
	        int nb_commande = varReturn.getInt(1);
	    	
			toReturn = nb_commande; 
        }
        else
        	toReturn = 0;
        
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
        	
			toReturn.add (new Client(
					id1,
					nom,
					prenom,
					adresse,
					ville,
					solde));
        }
		
		varReturn.close();
		return toReturn;
	}
	
}
