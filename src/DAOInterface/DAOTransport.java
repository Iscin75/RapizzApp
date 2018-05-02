package DAOInterface;

import java.util.Vector;


import metier.Transport;

public interface DAOTransport {
	public Transport GetById(int id);
	public Vector<Transport> GetAll();
}
