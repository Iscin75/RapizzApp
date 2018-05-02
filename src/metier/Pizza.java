package metier;

import java.util.Vector;

public class Pizza {
	public Pizza(int id, String nom, Vector<Ingredient> ingredients) {
		super();
		this.id = id;
		this.nom = nom;
		this.ingredients = ingredients;
	}
	public int id;
	public String nom;
	public Vector<Ingredient> ingredients;

}
