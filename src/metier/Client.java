package metier;

import java.util.Vector;

public class Client {
	public Client(int p_id, String p_nom, String p_prenom, String p_adresse, String p_ville, float p_solde) {
		super();

		this.id = p_id;
		this.nom = p_nom;
		this.prenom = p_prenom;
		this.adresse = p_adresse;
		this.ville = p_ville;
		this.solde = p_solde;
	}
	public String nom;
	public String prenom;
	public String adresse;
	public String ville;
	public float solde;
	public int id;
	public Vector<Commande> Commandes;
}
