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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import DAO.DAOCommande;
import DAO.DAOLivreur;
import DAO.DAOStat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class Stats extends JPanel {

private static final long serialVersionUID = 1L;
public Vector<Livreur> allLivreurs = null; 
public Vector<Pizza> allPizzas = null;
public Vector<Ingredient> allIngredients = null;
public Vector<Client> allClients = null;
public Vector<Commande> allCommandes = null;
public int famousSizeID = 0;
	
	JButton btnStatsLivreurs;
	JButton btnStatsClients;
	JButton btnStatsPizzas;
	public Stats(MainFrame menu) {
		
		setBackground(Color.LIGHT_GRAY);
		setBounds(100,100,720,423);
		InitStatsChoiceButtons();
		Button_Return();
		
		
	}
	

	void InitStatsChoiceButtons()
	{
		JPanel panelClient = new JPanel();
		panelClient.setBounds(234, 76, 198, 277);
		add(panelClient);
		panelClient.setVisible(false);
	
		
		JLabel lblPlusFidele = new JLabel("Le plus fidele : ");
		
		JLabel lblMoinsFidele = new JLabel("Le moins fidele : ");
		
		JLabel lblPlusFidele2 = new JLabel("It's me");
		
		JLabel lblMoinsFidele2 = new JLabel("It's me");
		
		GroupLayout gl_panelClient = new GroupLayout(panelClient);
		gl_panelClient.setHorizontalGroup(
			gl_panelClient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelClient.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelClient.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelClient.createSequentialGroup()
							.addGroup(gl_panelClient.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblPlusFidele, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
								.addComponent(lblMoinsFidele, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPlusFidele2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap(40, Short.MAX_VALUE))
						.addGroup(gl_panelClient.createSequentialGroup()
							.addComponent(lblMoinsFidele2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(40))))
		);
		gl_panelClient.setVerticalGroup(
			gl_panelClient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelClient.createSequentialGroup()
					.addGap(27)
					.addComponent(lblPlusFidele)
					.addGap(18)
					.addComponent(lblPlusFidele2)
					.addGap(30)
					.addComponent(lblMoinsFidele)
					.addGap(18)
					.addComponent(lblMoinsFidele2)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		panelClient.setLayout(gl_panelClient);
		
		JPanel panelLivreur = new JPanel();
		panelLivreur.setBounds(10, 76, 232, 277);
		add(panelLivreur);
		
		
		JLabel lblMeilleur = new JLabel("Apporte le plus d'argent : ");
		lblMeilleur.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lblRetard = new JLabel("Le plus en retard : ");
		
		JLabel lblMeilleur2 = new JLabel("It's me");
		lblMeilleur2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblRetard2 = new JLabel("It's me");
		GroupLayout gl_panelLivreur = new GroupLayout(panelLivreur);
		gl_panelLivreur.setHorizontalGroup(
			gl_panelLivreur.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelLivreur.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLivreur.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMeilleur2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
						.addComponent(lblMeilleur, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(472))
				.addGroup(Alignment.LEADING, gl_panelLivreur.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRetard)
					.addContainerGap(496, Short.MAX_VALUE))
				.addGroup(gl_panelLivreur.createSequentialGroup()
					.addGap(12)
					.addComponent(lblRetard2, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelLivreur.setVerticalGroup(
			gl_panelLivreur.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLivreur.createSequentialGroup()
					.addGap(27)
					.addComponent(lblMeilleur)
					.addGap(18)
					.addComponent(lblMeilleur2)
					.addGap(30)
					.addComponent(lblRetard)
					.addGap(18)
					.addComponent(lblRetard2)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		panelLivreur.setLayout(gl_panelLivreur);
		
		JPanel panelPizza = new JPanel();
		panelPizza.setBounds(447, 76, 232, 277);
		add(panelPizza);
		panelPizza.setVisible(false);
		
		JLabel lblPlusVendue = new JLabel("La plus vendue : ");
		
		JLabel lblIngredient = new JLabel("L'integrient prefere : ");
		
		JLabel lblTaille = new JLabel("La taille la plus vendue : ");
		
		JLabel lblPlusVendue2 = new JLabel("Not me ! ");
		
		JLabel lblIngredient2 = new JLabel("Not me ! ");
		
		JLabel lblTaille2 = new JLabel("Not me ! ");
		GroupLayout gl_panelPizza = new GroupLayout(panelPizza);
		gl_panelPizza.setHorizontalGroup(
			gl_panelPizza.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPizza.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPizza.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPizza.createSequentialGroup()
							.addGroup(gl_panelPizza.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPlusVendue)
								.addComponent(lblPlusVendue2))
							.addGap(82))
						.addGroup(gl_panelPizza.createSequentialGroup()
							.addComponent(lblIngredient, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(46))
						.addGroup(gl_panelPizza.createSequentialGroup()
							.addComponent(lblIngredient2, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panelPizza.createSequentialGroup()
							.addComponent(lblTaille)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panelPizza.createSequentialGroup()
							.addComponent(lblTaille2, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
							.addGap(2))))
		);
		gl_panelPizza.setVerticalGroup(
			gl_panelPizza.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPizza.createSequentialGroup()
					.addGap(26)
					.addComponent(lblPlusVendue)
					.addGap(18)
					.addComponent(lblPlusVendue2)
					.addGap(18)
					.addComponent(lblIngredient)
					.addGap(18)
					.addComponent(lblIngredient2)
					.addGap(18)
					.addComponent(lblTaille)
					.addGap(18)
					.addComponent(lblTaille2)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		panelPizza.setLayout(gl_panelPizza);
		
		btnStatsLivreurs = new JButton("Stats Livreurs");
		btnStatsLivreurs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelPizza.setVisible(false);
				panelLivreur.setVisible(true);
				panelClient.setVisible(false);
				
				try {
					allLivreurs = DAOStat.getThatDAO().GetWorstDeliveryBoys();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String pireLivreur = allLivreurs.get(0).nom + " " + allLivreurs.get(0).prenom; 
				lblRetard2.setText(pireLivreur);
				
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
				lblMeilleur2.setText(meilleurLivreur);
			}
		});
		btnStatsLivreurs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStatsLivreurs.setBounds(50, 11, 125, 40);
		add(btnStatsLivreurs);
		
		btnStatsClients = new JButton("Stats Clients");
		btnStatsClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelLivreur.setVisible(false);
				panelPizza.setVisible(false);
				panelClient.setVisible(true);
				try {
					allClients = DAOStat.getThatDAO().GetCustomersByNbOrders();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String meilleurClient = allClients.get(0).nom + " " + allClients.get(0).prenom;
				lblPlusFidele2.setText(meilleurClient);
				String pireClient = allClients.get(allClients.size() - 1).nom + " " +
									allClients.get(allClients.size() - 1).prenom;
				lblMoinsFidele2.setText(pireClient);
			}
		});
		btnStatsClients.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStatsClients.setBounds(266, 11, 125, 40);
		add(btnStatsClients);
		
		btnStatsPizzas = new JButton("Stats Pizzas");
		btnStatsPizzas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelPizza.setVisible(true);
				panelLivreur.setVisible(false);
				panelClient.setVisible(false);
				
				try {
					allPizzas = DAOStat.getThatDAO().GetPizzasByPopularity("DESC");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String bonnePizza = allPizzas.get(0).nom;
				lblPlusVendue2.setText(bonnePizza);
				
				try {
					allIngredients = DAOStat.getThatDAO().GetIngredientsByPopularity("DESC");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String bonIngredient = allIngredients.get(0).nom;
				lblIngredient2.setText(bonIngredient);
				
				try {
					allCommandes = DAOCommande.getThatDAO().GetAll();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					famousSizeID = DAOCommande.getThatDAO().GetMostFamousSize();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String taillPlusVendue = allCommandes.get(famousSizeID).taille;
				lblTaille2.setText(taillPlusVendue);
			}
		});
		btnStatsPizzas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStatsPizzas.setBounds(483, 11, 125, 40);
		add(btnStatsPizzas);
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
}

