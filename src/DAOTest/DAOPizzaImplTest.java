package DAOTest;

import java.util.Vector;

import DAO.DAOFactory;
import DAOInterface.DAOPizza;
import metier.Ingredient;
import metier.Pizza;

public class DAOPizzaImplTest implements DAOPizza {
	public Vector<Pizza> simulationBDD = new Vector<Pizza>();
	
	public DAOPizzaImplTest() {
		Vector <Ingredient> ingredientsList = DAOFactory.GetMeDAOIngredient().GetAll();
		
		simulationBDD.add(new Pizza(0,"0",ingredientsList));
		simulationBDD.add(new Pizza(1,"1",ingredientsList));
		simulationBDD.add(new Pizza(2,"2",ingredientsList));
		
		
	}
	@Override
	public Pizza GetById(int id) {
		Pizza toReturn = null;
		
		for(Pizza pizza : simulationBDD){
			if (pizza.id==id)
				toReturn=pizza;
		}
		
		return toReturn;
	}

	@Override
	public Vector<Pizza> GetAll() {
		return simulationBDD;
	}

}
