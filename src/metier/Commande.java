package metier;

import java.util.Date;
import java.util.Vector;

public class Commande {
	public Commande(int id, float prix, Date dateCommande, Client client, Pizza pizza, Livraison livraison) {
		super();
		this.id = id;
		this.prix = prix;
		this.dateCommande = dateCommande;
		this.client = client;
		this.pizza = pizza;
		this.livraison = livraison;
	}
	public int id;
	public float prix;
	public Date dateCommande;
	public Client client;
	public Pizza pizza;
	public Livraison livraison;
	
}
