package DAOTest;

import java.util.Vector;
import DAOInterface.DAOLivreur;
import metier.Livreur;

public class DAOLivreurImplTest implements DAOLivreur {
	public Vector<Livreur> simulationBDD;
	public DAOLivreurImplTest() {
		simulationBDD = new Vector<Livreur>();
		simulationBDD.add(new Livreur(0,"0", "00"));
		simulationBDD.add(new Livreur(1,"1", "01"));
		simulationBDD.add(new Livreur(2,"2", "02"));
	}
	@Override
	public Livreur GetById(int id) {
		Livreur toReturn = null;
		
		for(Livreur client : simulationBDD){
			if (client.id==id)
				toReturn=client;
		}
		
		return toReturn;
	}

	@Override
	public Vector<Livreur> GetAll() {
		// TODO Auto-generated method stub
		return simulationBDD;
	}

}
