import java.util.Vector;

import DAOInterface.*;
import metier.*;

public class main {

	public static void main(String[] args) {
		

		DAOPizza daoPizza = DAO.DAOFactory.GetMeDAOPizza();
		Vector <Pizza> vcPizza = daoPizza.GetAll();
		System.out.println(vcPizza.get(0).id);
		
		DAOLivreur daoLivreur = DAO.DAOFactory.GetMeDAOLivreur();
		Vector <Livreur> vcLivreur = daoLivreur.GetAll();
		System.out.println(vcLivreur.get(0).id);
		
		
		
		DAOLivraison daoLivraison = DAO.DAOFactory.GetMeDAOLivraison();
		Vector <Livraison> vcLivraison = daoLivraison.GetAll();
		System.out.println(vcLivraison.get(0).id);
		
		DAOCommande dao = DAO.DAOFactory.GetMeDAOCommande();
		Vector <Commande> vc = dao.GetAll();
		System.out.println(dao.GetById(1).id);
		

	}

}
