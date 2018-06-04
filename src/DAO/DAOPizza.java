package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


import metier.Ingredient;
import metier.Pizza;

public class DAOPizza extends DAO{

	public static DAOPizza me;
	public static DAOPizza getThatDAO() {
		if (me==null)
			me= new DAOPizza();
		
		return me;
	}
	public DAOPizza() {
		super();

		
	}
	public Pizza GetById(int id)  throws SQLException {
		Pizza toReturn = null;
		ResultSet varReturn;
		varReturn = query( "SELECT * FROM pizzas WHERE id = " + Integer.toString(id) + ";");
		
		if( varReturn.next() )
		{
			int id1 = varReturn.getInt(1);
			String nom = varReturn.getString(2);
			Vector<Ingredient> Ingredients  = new Vector<Ingredient>();
			Ingredients = DAOIngredient.getThatDAO().GetAllForPizza(id1);
			float price = varReturn.getFloat(3);
			
			toReturn = new Pizza( id1, nom, Ingredients, price );
		}
		
		varReturn.close();
		return toReturn;
	}

	public Vector<Pizza> GetAll()  throws SQLException {
		Vector <Pizza> toReturn = new Vector<Pizza>();
		ResultSet varReturn = query("SELECT * FROM pizzas;");
		
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

}
