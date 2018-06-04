package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ViewController;
import metier.Client;
import metier.Commande;
import metier.Ingredient;
import metier.Livreur;
import metier.Pizza;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import DAO.DAOCommande;
import DAO.DAOLivreur;
import DAO.DAOStat;



public class Stats extends JPanel {

private static final long serialVersionUID = 1L;
JLabel valueBestLivreur;
JLabel valueWorstLivreur;
JLabel valueBestClient;
JLabel valueWorstClient;
JLabel valueBestPizza;
JLabel valueBestIngr;
JLabel valueBestSize;

public Vector<Livreur> allLivreurs = null; 
public Vector<Pizza> allPizzas = null;
public Vector<Ingredient> allIngredients = null;
public Vector<Client> allClients = null;
public Vector<Commande> allCommandes = null;
public int famousSizeID = 0;

	public Stats(MainFrame menu) {
		
		setBackground(Color.LIGHT_GRAY);
		setBounds(100,100,720,423);
		Button_Return();
		SetDefaultControlsValue();
		GetStats();
		
		
	}
	
	public void Button_Return(){
		
		JButton btnReturn = new JButton("Retour");
		btnReturn.setBounds(600, 390, 100, 30);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent quitter) {
				ViewController.setAnDrawNewView("Menu");
			}
		});
		setLayout(null);
		add(btnReturn);
		btnReturn.setFocusPainted(false);
		
		
	}
	
	
	
	
	
	void GetStats()
	{
		try {
			allLivreurs = DAOStat.getThatDAO().GetWorstDeliveryBoys();
			valueWorstLivreur.setText(allLivreurs.get(0).nom + " " + allLivreurs.get(0).prenom);
			
			allClients = DAOStat.getThatDAO().GetCustomersByNbOrders();
			valueBestClient.setText(allClients.get(0).nom + " " + allClients.get(0).prenom);
			valueWorstClient.setText(allClients.get(allClients.size() - 1).nom + " " + allClients.get(allClients.size() - 1).prenom);
			allPizzas = DAOStat.getThatDAO().GetPizzasByPopularity("DESC");
			valueBestPizza.setText(allPizzas.get(0).nom);
			allIngredients = DAOStat.getThatDAO().GetIngredientsByPopularity("DESC");
			valueBestIngr.setText(allIngredients.get(0).nom);
			allCommandes = DAOCommande.getThatDAO().GetAll();
			valueBestSize.setText(allCommandes.get(famousSizeID).taille);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			allLivreurs = DAOLivreur.getThatDAO().GetAll();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		float maxMoney = 0;
		float earnedMoney = 0;
		int idMeilleurLivreur = 0;
		
		for (int i = 0; i < allLivreurs.size(); i++) {
			try {
				earnedMoney = DAOLivreur.getThatDAO().GetMoneyEarnedById(i);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (maxMoney < earnedMoney) {
				maxMoney = earnedMoney;
				idMeilleurLivreur = i;
			}
		}
		String  meilleurLivreur = allLivreurs.get(idMeilleurLivreur).nom + " " +
								  allLivreurs.get(idMeilleurLivreur).prenom;
		valueBestLivreur.setText(meilleurLivreur);
		
	}
	
	void SetDefaultControlsValue()
	{
		JLabel headerStatsLivreur = new JLabel("Statistiques Livreur");
		headerStatsLivreur.setHorizontalAlignment(SwingConstants.CENTER);
		headerStatsLivreur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		headerStatsLivreur.setBounds(27, 35, 168, 30);
		add(headerStatsLivreur);
		
		JLabel headerStatsClient = new JLabel("Statistiques Client");
		headerStatsClient.setHorizontalAlignment(SwingConstants.CENTER);
		headerStatsClient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		headerStatsClient.setBounds(246, 35, 168, 30);
		add(headerStatsClient);
		
		JLabel headerStatsPizzas = new JLabel("Statistiques Pizzas");
		headerStatsPizzas.setHorizontalAlignment(SwingConstants.CENTER);
		headerStatsPizzas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		headerStatsPizzas.setBounds(476, 35, 168, 30);
		add(headerStatsPizzas);
		
		JLabel statBestLivreur = new JLabel("Livreur ayant rapport\u00E9 le plus  :");
		statBestLivreur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		statBestLivreur.setBounds(30, 100, 193, 14);
		add(statBestLivreur);
		
		JLabel statWorstLivreur = new JLabel("Livreur le plus en retard  :");
		statWorstLivreur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		statWorstLivreur.setBounds(30, 190, 193, 14);
		add(statWorstLivreur);
		
		JLabel statBestClient = new JLabel("Client le plus fid\u00E8le :");
		statBestClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		statBestClient.setBounds(260, 100, 193, 14);
		add(statBestClient);
		
		JLabel statWorstClient = new JLabel("Client le moins fid\u00E8le :");
		statWorstClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		statWorstClient.setBounds(260, 190, 193, 14);
		add(statWorstClient);
		
		JLabel statBestPizza = new JLabel("Pizza la plus vendue :");
		statBestPizza.setFont(new Font("Tahoma", Font.PLAIN, 13));
		statBestPizza.setBounds(490, 101, 193, 14);
		add(statBestPizza);
		
		JLabel statBestIngr = new JLabel("Ingr\u00E9dient pr\u00E9f\u00E9r\u00E9 des clients :");
		statBestIngr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		statBestIngr.setBounds(490, 190, 193, 14);
		add(statBestIngr);
		
		JLabel statBestTaille = new JLabel("Taille pr\u00E9f\u00E9r\u00E9e des clients :");
		statBestTaille.setFont(new Font("Tahoma", Font.PLAIN, 13));
		statBestTaille.setBounds(490, 275, 193, 14);
		add(statBestTaille);
		
		valueBestLivreur = new JLabel("");
		valueBestLivreur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		valueBestLivreur.setBounds(30, 135, 193, 14);
		add(valueBestLivreur);
		
		valueWorstLivreur = new JLabel("");
		valueWorstLivreur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		valueWorstLivreur.setBounds(30, 225, 193, 14);
		add(valueWorstLivreur);
		
		valueBestClient = new JLabel("");
		valueBestClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		valueBestClient.setBounds(260, 135, 193, 14);
		add(valueBestClient);
		
		valueWorstClient = new JLabel("");
		valueWorstClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		valueWorstClient.setBounds(260, 225, 193, 14);
		add(valueWorstClient);
		
		valueBestPizza = new JLabel("");
		valueBestPizza.setFont(new Font("Tahoma", Font.PLAIN, 13));
		valueBestPizza.setBounds(490, 135, 193, 14);
		add(valueBestPizza);
		
		valueBestIngr = new JLabel("");
		valueBestIngr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		valueBestIngr.setBounds(490, 225, 193, 14);
		add(valueBestIngr);
		
		valueBestSize = new JLabel("");
		valueBestSize.setFont(new Font("Tahoma", Font.PLAIN, 13));
		valueBestSize.setBounds(490, 310, 193, 14);
		add(valueBestSize);
	}
}

