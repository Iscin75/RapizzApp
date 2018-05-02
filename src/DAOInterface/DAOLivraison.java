package DAOInterface;

import java.util.Vector;


import metier.Livraison;

public interface DAOLivraison {
	public Livraison GetById(int id);
	public Vector<Livraison> GetAll();
}
