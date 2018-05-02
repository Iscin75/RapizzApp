package DAOInterface;

import java.util.Vector;

import metier.Client;


public interface DAOClient {
	public Client GetById(int id);
	public Vector<Client> GetAll();
	
}
