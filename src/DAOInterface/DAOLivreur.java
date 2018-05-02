package DAOInterface;

import java.util.Vector;


import metier.Livreur;

public interface DAOLivreur {
	public Livreur GetById(int id);
	public Vector<Livreur> GetAll();
}
