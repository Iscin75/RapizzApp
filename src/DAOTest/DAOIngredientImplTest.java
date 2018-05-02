package DAOTest;

import java.util.Vector;

import DAOInterface.DAOIngredient;
import metier.Client;
import metier.Ingredient;

public class DAOIngredientImplTest implements DAOIngredient {
	public Vector<Ingredient> simulationBDD = new Vector<Ingredient>();
	
	public DAOIngredientImplTest() {
		simulationBDD.add(new Ingredient(0,"0"));
		simulationBDD.add(new Ingredient(1,"1"));
		simulationBDD.add(new Ingredient(2,"2"));
		
	}
	@Override
	public Ingredient GetById(int id) {
		Ingredient toReturn = null;
		
		for(Ingredient tmp : simulationBDD){
			if (tmp.id==id)
				toReturn=tmp;
		}
		
		return toReturn;
	}

	@Override
	public Vector<Ingredient> GetAll() {
		// TODO Auto-generated method stub
		return simulationBDD;
	}

}
