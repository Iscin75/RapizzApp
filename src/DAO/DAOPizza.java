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
	public Pizza GetById(int id) {
		Pizza toReturn = null;
		ResultSet varReturn;
		try {
			varReturn = query( "SELECT * FROM pizzas WHERE id = " + Integer.toString(id) + ";");
			toReturn = new Pizza( varReturn.getInt(1),
					varReturn.getString(2),
					DAOIngredient.getThatDAO().GetAllForPizza( varReturn.getInt(1) ),
					varReturn.getFloat(3) );

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return toReturn;
	}

	public Vector<Pizza> GetAll() {
		Vector <Pizza> toReturn = new Vector<Pizza>();
		try {
			
			ResultSet resultat = query("SELECT * FROM pizzas;");
			while( resultat.next() ) {
				
				Vector <Ingredient> bis = new Vector<Ingredient>();
				ResultSet resultat1 = query("select I.id,I.nom from ingredients I, assoc_pizzas_ingredients A, pizzas P WHERE I.id = A.ingredient AND A.pizza = P.id AND P.id = " + resultat.getInt(1) + ";");
							while( resultat1.next() ) {
								bis.add(new Ingredient(resultat1.getInt(1),resultat1.getString(2)));
							}
						
				resultat1.close();
				toReturn.add(new Pizza(resultat.getInt(1),resultat.getString(2), bis, resultat.getFloat(3)));
				//select I.nom from ingredients I, assoc_pizzas_ingredients A, pizzas P WHERE I.id = A.ingredient AND A.pizza = P.id AND P.id = 1;


			}
			resultat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}

}
