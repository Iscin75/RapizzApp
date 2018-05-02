package DAOInterface;

import java.util.Vector;

import metier.Pizza;

public interface DAOPizza {
	public Pizza GetById(int id);
	public Vector<Pizza> GetAll();
}
