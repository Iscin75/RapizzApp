package metier;

import java.util.Date;

public class Commande {
	static Commande me;
	public Commande(int id, Client client, Pizza pizza, String taille, float tarif, Date date, Livraison livraison) {
		super();
		this.id = id;
		this.prix = tarif;
		this.dateCommande = date;
		this.client = client;
		this.pizza = pizza;
		this.livraison = livraison;
		this.taille = taille;
		me = this;
	}
	
	public int id;
	public String taille;
	public float prix;
	public Date dateCommande;
	public Client client;
	public Pizza pizza;
	public Livraison livraison;
	
}
