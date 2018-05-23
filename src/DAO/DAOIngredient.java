package DAO;

import java.util.Vector;

import metier.Commande;
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

	public Ingredient GetById(int id) {

		Ingredient toReturn = null;
		
		// TODO A faire !
		
		return toReturn;
	}

	public Vector<Ingredient> GetAll() {
		Vector<Ingredient> Ingredients = new Vector<Ingredient>();
		/* ResultSet varReturn = make.request( "SELECT I.* FROM ingredients as I, assoc_pizzas_ingredients as A, pizzas as P WHERE I.id = A.ingredient and A.pizza = P.id and P.id = %d", id );
	
		while( varReturn.next() )
		{
			int id = varResult.getInt( 1 );
			String nom = varResult.getString(2);
			
			Ingredients.add( new Ingredient( id, nom ) );
		}
	
		*/
		return Ingredients;
	}
	

}
