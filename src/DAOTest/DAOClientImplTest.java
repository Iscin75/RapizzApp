package DAOTest;

import java.util.Date;
import java.util.Vector;

import DAOInterface.DAOClient;
import metier.Client;
import metier.Commande;

public class DAOClientImplTest implements DAOClient {
	public Vector<Client> simulationBDD = new Vector<Client>();
	public DAOClientImplTest() {
		simulationBDD.add(new Client("num�ro0", "num�ro0",100, 0,0  ));
		simulationBDD.add(new Client("num�ro1", "num�ro1",101, 1,1  ));
		simulationBDD.add(new Client("num�ro11", "num�ro11",111, 11,11  ));
	}
	@Override
	public Client GetById(int id) {

		Client toReturn = null;
		
		for(Client client : simulationBDD){
			if (client.id==id)
				toReturn=client;
		}
		
		return toReturn;
	}
	@Override
	public Vector<Client> GetAll() {
		return simulationBDD;
	}
	

}
