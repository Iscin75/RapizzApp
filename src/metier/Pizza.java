package metier;

import java.util.Vector;

public class Pizza {
	public Pizza(int id, String nom, Vector<Ingredient> ingredients, float price) {
		super();
		this.id = id;
		this.nom = nom;
		this.ingredients = ingredients;
		this.base_prix = price;
	}
	public int id;
	public String nom;
	public Vector<Ingredient> ingredients;
	public float base_prix;

}
