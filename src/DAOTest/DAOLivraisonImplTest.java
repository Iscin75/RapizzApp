package DAOTest;

import java.util.Vector;

import DAO.DAOFactory;
import DAOInterface.DAOLivraison;
import metier.EtatLivraison;
import metier.Livraison;
import metier.Livreur;
import metier.Transport;

public class DAOLivraisonImplTest implements DAOLivraison {
	public Vector<Livraison> simulationBDD = new Vector<Livraison>();
	public DAOLivraisonImplTest() {
		Vector <Livreur> livreursList = DAOFactory.GetMeDAOLivreur().GetAll();
		Vector <Transport> transportsList = DAOFactory.GetMeDAOTransport().GetAll();
		simulationBDD.add(new Livraison(0,EtatLivraison.enCours,livreursList.get(0), transportsList.get(0)));
		simulationBDD.add(new Livraison(1,EtatLivraison.enCours,livreursList.get(1), transportsList.get(1)));
		simulationBDD.add(new Livraison(2,EtatLivraison.enCours,livreursList.get(2), transportsList.get(2)));
		
	}
	@Override
	public Livraison GetById(int id) {
		Livraison toReturn = null;
		
		for(Livraison client : simulationBDD){
			if (client.id==id)
				toReturn=client;
		}
		
		return toReturn;
	}

	@Override
	public Vector<Livraison> GetAll() {
		// TODO Auto-generated method stub
		return simulationBDD;
	}

}
