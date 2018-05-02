package DAOTest;
import java.util.Vector;

import DAO.DAOFactory;
import DAOInterface.DAOCommande;
import metier.Client;
import metier.Commande;
import metier.Livraison;
import metier.Pizza;

import java.util.Date;

public class DAOCommandeImplTest implements DAOCommande {
	public Vector<Commande> simulationBDD = new Vector<Commande>();
	
	
	public DAOCommandeImplTest() {
		
		
		Vector<Client> clientList = DAOFactory.GetMeDAOClient().GetAll();
		Vector<Pizza> pizzaList = DAOFactory.GetMeDAOPizza().GetAll();
		Vector <Livraison> livraisonsList = DAOFactory.GetMeDAOLivraison().GetAll();
		simulationBDD.add(new Commande(0, 0, java.util.Calendar.getInstance().getTime(),clientList.get(0),pizzaList.get(0), livraisonsList.get(0) ));
		simulationBDD.add(new Commande(1, 1, java.util.Calendar.getInstance().getTime(),clientList.get(1),pizzaList.get(1), livraisonsList.get(1) ));
		simulationBDD.add(new Commande(2, 2, java.util.Calendar.getInstance().getTime(),clientList.get(2),pizzaList.get(2), livraisonsList.get(2) ));
		
		
		Date date = java.util.Calendar.getInstance().getTime();
		
	}
	
	@Override
	public Vector<Commande> GetAll() {
		
		return simulationBDD;
	}

	@Override
	public Commande GetById(int id) {
		Commande toReturn = null;
		
		for(Commande client : simulationBDD){
			if (client.id==id)
				toReturn=client;
		}
		
		return toReturn;
	}
	
	


}
