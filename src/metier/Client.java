package metier;

import java.util.Vector;

public class Client {
	public Client(String nom, String mdp, float solde, int id, int nombreCommande) {
		super();

		this.nom = nom;
		this.mdp = mdp;
		this.solde = solde;
		this.id = id;
		this.nombreCommande = nombreCommande;
	}

	public String nom;
	public String mdp;
	public float solde;
	public int id;
	public int nombreCommande;
	public Vector<Commande> Commandes;
}
