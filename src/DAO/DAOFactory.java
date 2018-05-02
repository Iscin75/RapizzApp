package DAO;
import DAO.*;
import DAOInterface.DAOClient;
import DAOInterface.DAOCommande;
import DAOInterface.DAOIngredient;
import DAOInterface.DAOLivraison;
import DAOInterface.DAOLivreur;
import DAOInterface.DAOPizza;
import DAOInterface.DAOTransport;
import DAOTest.*;
public class DAOFactory {
	static public DAOFactory me;
	
	static public DAOFactory GetMeDAOFactory() {

		
		if (me==null)
			me=new DAOFactory();
		
		
		return me;
	}
	
	
	/* TODO Faire la connexion à la bdd ici ! */
	static public DAOCommande theDAOCommande;
	
	static public DAOCommande GetMeDAOCommande() {
		if (theDAOCommande==null) {
			theDAOCommande=new DAOCommandeImplTest();
		}
		return theDAOCommande;
	}
	
	static public DAOClient theDAOClient;
	
	static public DAOClient GetMeDAOClient() {
		if (theDAOClient==null) {
			theDAOClient=new DAOClientImplTest();
		}
		return theDAOClient;
	}
	
	static public DAOPizza theDAOPizza;
	
	static public DAOPizza GetMeDAOPizza() {
		if (theDAOPizza==null) {
			theDAOPizza=new DAOPizzaImplTest();
		}
		return theDAOPizza;
	}
	
	static public DAOIngredient theDAOIngredient  ;
	
	static public DAOIngredient  GetMeDAOIngredient () {
		if (theDAOIngredient ==null) {
			theDAOIngredient =new DAOIngredientImplTest();
		}
		return theDAOIngredient ;
	}
	
	static public DAOLivraison theDAOLivraison ;
	
	static public DAOLivraison   GetMeDAOLivraison  () {
		if (theDAOLivraison  ==null) {
			theDAOLivraison  =new DAOLivraisonImplTest();
		}
		return theDAOLivraison  ;
	}
	
	
	static public DAOLivreur theDAOLivreur ;
	
	static public DAOLivreur  GetMeDAOLivreur () {
		if (theDAOLivreur  ==null) {
			theDAOLivreur  =new DAOLivreurImplTest();
		}
		return theDAOLivreur  ;
	}
	
	
	static public DAOTransport theDAOTransport ;
	
	static public DAOTransport    GetMeDAOTransport  () {
		if (theDAOTransport   ==null) {
			theDAOTransport  =new DAOTransportImplTest();
		}
		return theDAOTransport   ;
	}
	
}
