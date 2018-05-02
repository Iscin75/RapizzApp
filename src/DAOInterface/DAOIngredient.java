package DAOInterface;

import java.util.Vector;

import metier.Ingredient;

public interface DAOIngredient {
	public Ingredient GetById(int id);
	public Vector<Ingredient> GetAll();
}
