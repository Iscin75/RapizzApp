package DAOInterface;

import java.util.Vector;

import metier.Commande;

public interface DAOCommande {
	public Commande GetById(int id);
	public Vector<Commande> GetAll();
	
}
