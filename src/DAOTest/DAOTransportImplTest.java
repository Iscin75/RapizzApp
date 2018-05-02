package DAOTest;

import java.util.Vector;

import DAOInterface.DAOTransport;
import metier.Transport;

public class DAOTransportImplTest implements DAOTransport {
	public Vector<Transport> simulationBDD;
	public DAOTransportImplTest() {
		simulationBDD = new Vector<Transport>();
		simulationBDD.add(new Transport(0,"0"));
		simulationBDD.add(new Transport(1,"1"));
		simulationBDD.add(new Transport(2,"2"));
		
	}
	@Override
	public Transport GetById(int id) {
		Transport toReturn = null;
		
		for(Transport client : simulationBDD){
			if (client.id==id)
				toReturn=client;
		}
		
		return toReturn;
	}

	@Override
	public Vector<Transport> GetAll() {
		// TODO Auto-generated method stub
		return simulationBDD;
	}

}
