package DAO;
import java.util.Vector;


import metier.*;



public class DAOCommande extends DAO {
	
	public static DAOCommande me;
	public static DAOCommande getThatDAO() {
		if (me==null)
			me= new DAOCommande();
		
		return me;
	}
	public DAOCommande() {
		
		super();
	}
	

	public Commande GetById(int id) {

		Commande toReturn = null;
		
		// TODO A faire !
		
		return toReturn;
	}

	public Vector<Commande> GetAll() {
		Vector<Commande> allCmd = new Vector<Commande>();
		// ResultSet varReturn = make.resquest( "SELECT * FROM commandes;" );
		/*
		while( next(x) )
		{
			int id = varReturn.getInt(1);
			float tarif = varReturn.getFloat(2);
			time dt_cmd = varReturn.getDatetime(3);
			Client client = getClient( varReturn.getInt(4) ); 
			Pizza pizza = getPizza( varReturn.getInt(5) );
			Livraison livraison = getLivraison( varReturn.getInt(7) );
			
			allCmd.add( new Commande(id, tarif, dt_cmd, client, pizza, livraison);
		}*/
		return allCmd;
	}
	
	


}
