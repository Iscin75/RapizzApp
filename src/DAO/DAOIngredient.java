package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


import metier.Ingredient;

public class DAOIngredient extends DAO {

	
	public static DAOIngredient me;
	public static DAOIngredient getThatDAO() {
		if (me==null)
			me= new DAOIngredient();
		
		return me;
	}
	public DAOIngredient() {

		super();
	}

	public Ingredient GetById(int id) throws SQLException {

		Ingredient toReturn = null;
		String id_str = Integer.toString(id);
		
		ResultSet varReturn = query( "SELECT * FROM ingredients WHERE id = "+ id_str + ";" );
		
		varReturn.next();
		int id1 = varReturn.getInt(1);
		String nom = varReturn.getString(2);
			
		toReturn = new Ingredient( id1, nom);
		
		varReturn.close();
		return toReturn;
	}

	public Vector<Ingredient> GetAll() throws SQLException {
		Vector<Ingredient> Ingredients = new Vector<Ingredient>();
		ResultSet varReturn;
		varReturn = query( "SELECT * FROM ingredients;");
		while( varReturn.next() )
		{
			int id1 = varReturn.getInt( 1 );
			String nom = varReturn.getString(2);
			
			Ingredients.add( new Ingredient( id1, nom ) );
		}
		
		varReturn.close();
		return Ingredients;
	}
	
	public Vector<Ingredient> GetAllForPizza( int id ) throws SQLException {
		
		Vector<Ingredient> Ingredients = new Vector<Ingredient>();
		ResultSet varReturn;
		varReturn = query( "SELECT I.* FROM ingredients as I, assoc_pizzas_ingredients as A, pizzas as P WHERE I.id = A.ingredient and A.pizza = P.id and P.id = " + Integer.toString(id) + ";");
		while( varReturn.next() )
		{
			int id1 = varReturn.getInt( 1 );
			String nom = varReturn.getString(2);
			
			Ingredients.add( new Ingredient( id1, nom ) );
		}
		
		varReturn.close();
		return Ingredients;
	}
	

}
