package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import metier.*;

public class DAOStat extends DAO {

	public static DAOStat me;
	public static DAOStat getThatDAO() {
		if (me==null)
			me= new DAOStat();
		
		return me;
	}
	public DAOStat() {
		super();
	}
	

	public Vector<Client> GetCustomersByNb_Orders() throws SQLException {
		
		//Clients par ordre de nombre de commandes (sont comptés seulement ceux avec au moins 1 commande)
		Vector<Client> toReturn = new Vector<Client>(); 
				
				ResultSet varReturn = query( "SELECT c.*, co.nb_Cmd FROM clients as c, (SELECT client, count(client) as nb_Cmd FROM commandes GROUP BY client ORDER BY COUNT(client)) as co WHERE c.id = co.client group by co.client order by co.nb_Cmd DESC;");
		        while( varReturn.next())
		        {
		        	int id1 = varReturn.getInt(1);
		        	String nom = varReturn.getString(2);
		        	String prenom = varReturn.getString(3);
		        	String adresse = varReturn.getString(4);
		        	String ville = varReturn.getString(5);
		        	float solde = varReturn.getFloat(6);
		        	// pour avoir le nombre de commandes, c'est varReturn.getInt(7)
		        	
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
	
	public Vector<Livreur> GetWorstDeliveryBoys()  throws SQLException {
		
		// Livreurs par ordre de retard (sont comptés ceux au moins avec 1 retard)
		Vector<Livreur> toReturn = new Vector<Livreur>(); 
		ResultSet varReturn;
		varReturn = query( "SELECT l.*, COUNT(li.statut) as nb_Retard FROM livreur as l, livraisons as li WHERE li.livreur = l.id AND li.statut = 'retard' GROUP BY l.nom ORDER BY COUNT(li.statut) DESC;");
		
		while( varReturn.next())
		{
			int id1 = varReturn.getInt(1);
			String nom = varReturn.getString(2);
			String prenom = varReturn.getString(3);
			// pour avoir le nombre de retard, c'est varReturn.getInt(4)
		
			toReturn.add(new Livreur( id1, nom, prenom ));
		}
		
		varReturn.close();
		return toReturn;
	}
	
	public Vector<Transport > GetWorstVehicules()  throws SQLException {
		Vector<Transport > toReturn = new Vector<Transport >(); 
		ResultSet varReturn;
		varReturn = query( "SELECT t.*, COUNT(li.statut) as nb_Retard FROM transports as t,  livraisons as li WHERE li.transport = t.id AND statut = 'retard' GROUP BY t.nom ORDER BY COUNT(li.statut) DESC;");
		
		while( varReturn.next())
		{
			int id1 = varReturn.getInt(1);
			String nom = varReturn.getString(2);
			// pour avoir le nombre de retard, c'est varReturn.getInt(3)
			
			toReturn.add( new Transport( id1, nom ));
		}
		
		varReturn.close();
		return toReturn;
	}
	
	public Vector<Pizza> GetPizzasByPopularity( String ORDER )  throws SQLException {
		//ORDER = ASC or DESC
		Vector <Pizza> toReturn = new Vector<Pizza>();
		ResultSet varReturn = query("SELECT p.*, COUNT(c.pizza) as nbAchat FROM pizzas as p, commandes as c WHERE p.id = c.pizza GROUP BY c.pizza ORDER BY COUNT(c.pizza) " + ORDER + ";");
		while( varReturn.next() ) {
			int id1 = varReturn.getInt(1);
			String nom = varReturn.getString(2);
			Vector<Ingredient> Ingredients  = new Vector<Ingredient>();
			Ingredients = DAOIngredient.getThatDAO().GetAllForPizza(id1);
			float price = varReturn.getFloat(3);
			// pour avoir le nombre de commandes, c'est varReturn.getInt(4)
			
			toReturn.add(new Pizza(id1, nom, Ingredients, price));
		}
		
		varReturn.close();
		return toReturn;
	}
	
	public Vector<Pizza> GetPizzasNotBought()  throws SQLException {
		Vector <Pizza> toReturn = new Vector<Pizza>();
		ResultSet varReturn = query("SELECT p.* FROM pizzas as p LEFT JOIN commandes as c ON c.pizza = p.id WHERE c.pizza IS NULL;");
		while( varReturn.next() ) {
			int id1 = varReturn.getInt(1);
			String nom = varReturn.getString(2);
			Vector<Ingredient> Ingredients  = new Vector<Ingredient>();
			Ingredients = DAOIngredient.getThatDAO().GetAllForPizza(id1);
			float price = varReturn.getFloat(3);
			
			toReturn.add(new Pizza(id1, nom, Ingredients, price));
		}
		
		varReturn.close();
		return toReturn;
	}

	public Vector<Ingredient> GetIngredientsByPopularity( String ORDER ) throws SQLException {
		Vector<Ingredient> Ingredients = new Vector<Ingredient>();
		ResultSet varReturn;
		varReturn = query( "SELECT i.*, count(i.nom) as nb_Used FROM ingredients as i, assoc_pizzas_ingredients as a, pizzas as p, commandes as c WHERE i.id = a.ingredient AND a.pizza = p.id AND p.id = c.pizza GROUP BY ( i.nom ) ORDER BY COUNT(i.nom) " + ORDER + ";");
		while( varReturn.next() )
		{
			int id1 = varReturn.getInt( 1 );
			String nom = varReturn.getString(2);
			// pour avoir le nombre de fois qu'ils sont utilisés, c'est varReturn.getInt(3)
			
			Ingredients.add( new Ingredient( id1, nom ) );
		}
		
		varReturn.close();
		return Ingredients;
	}
}
