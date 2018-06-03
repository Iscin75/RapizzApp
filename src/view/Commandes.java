package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import DAO.DAOCommande;

import javax.swing.GroupLayout.Alignment;

import controller.ViewController;
import metier.Commande;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Commandes extends JPanel {


	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable CmdTable;
	    
	private static final long serialVersionUID = 1L;
	private JLabel lblInformationsComplmentaires;
	private JLabel lblClient;
	private JLabel lblLivreur;
	private JLabel lblTarif;
	private JLabel lblDateCommande;
	private JLabel lblDateLivraison;
	private JButton btnReturn;
	private JLabel lblPizzaChoisie;
	private JLabel lblTaille;
	
	public Vector<Commande> allCmds = null;

	/**
	 * Create the panel.
	 */
	public Commandes(MainFrame menu) {
		
			setBackground(Color.LIGHT_GRAY);
			setBounds(100,100,720,423);
			setLayout(null);
			InitCommandesTable();
			Button_Return();
			DisplayCommandesInfos();
			OnSelectionShowInfos(0);
	}
	
	// TODO Remplir la table "CmdTable" au chargement du panel (Colonnes : "N° Commande", "Client", "Date", "Tarif")
	void OnLoadFillCmdTable()
	{
			
	}
	
	// TODO Afficher toutes les infos d'une commande lorsque la ligne dans "CmdTable est selectionnée en s'aidant des différents labels 
	// (client (nom + prenom), livreur(nom + prenom), tarifCmd, dateCmd, dateLivraison, pizza choisie et taille)
	// Par défaut afficher la cmd à l'index 0
	void OnSelectionShowInfos(int index)
	{
		String clientStr = "Client : " + allCmds.get(index).client.nom + " "
                + allCmds.get(index).client.prenom;

		String livreurStr = "Livreur : " + allCmds.get(index).livraison.livreur.nom + " " 
						     + allCmds.get(index).livraison.livreur.prenom;
		
		String tarifStr = "Tarif : " + allCmds.get(index).prix;
		String dateCmdStr = "Date de commande : " + allCmds.get(index).dateCommande;
		//String dateLivStr = "Date de livraison : " + allCmds.get(index).livraison.livreur.
		String pizzaStr = "Pizza choisie : " + allCmds.get(index).pizza.nom;
		String tailleStr = "Taille : " + allCmds.get(index).taille;
		lblClient.setText(clientStr);
		lblLivreur.setText(livreurStr);
		lblTarif.setText(tarifStr);
		lblDateCommande.setText(dateCmdStr);
		//lblDateLivraison.setText(dateLivStr);
		lblPizzaChoisie.setText(pizzaStr);
		lblTaille.setText(tailleStr);
	}
	
	public void Button_Return(){
		
		btnReturn = new JButton("Retour");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent quitter) {
				ViewController.setAnDrawNewView("Menu");
			}
		});
		btnReturn.setBounds(600, 390, 100, 30);
		add(btnReturn);
		btnReturn.setFocusPainted(false);
		
	}
	

	  private void DisplayCommandesInfos() {

		  

	        lblInformationsComplmentaires = new JLabel("Informations compl\u00E9mentaires :");
	        lblInformationsComplmentaires.setBounds(10, 253, 339, 29);
	        lblInformationsComplmentaires.setFont(new Font("Tahoma", Font.PLAIN, 24));
	        
	        lblClient = new JLabel("Client :");
	        lblClient.setBounds(10, 293, 151, 17);
	        lblClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        lblLivreur = new JLabel("Livreur :");
	        lblLivreur.setBounds(175, 293, 147, 17);
	        lblLivreur.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        lblTarif = new JLabel("Tarif :");
	        lblTarif.setBounds(336, 293, 257, 17);
	        lblTarif.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        lblDateCommande = new JLabel("Date de commande :");
	        lblDateCommande.setBounds(10, 328, 312, 17);
	        lblDateCommande.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        lblDateLivraison = new JLabel("Date de livraison :");
	        lblDateLivraison.setBounds(336, 328, 257, 17);
	        lblDateLivraison.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        setLayout(null);
	        add(btnReturn);
	        add(jScrollPane1);
	        add(lblInformationsComplmentaires);
	        add(lblClient);
	        add(lblDateLivraison);
	        add(lblLivreur);
	        add(lblTarif);
	        add(lblDateCommande);
	        
	        lblPizzaChoisie = new JLabel("Pizza choisie :");
	        lblPizzaChoisie.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblPizzaChoisie.setBounds(10, 371, 312, 17);
	        add(lblPizzaChoisie);
	        
	        lblTaille = new JLabel("Taille :");
	        lblTaille.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblTaille.setBounds(336, 371, 142, 17);
	        add(lblTaille);
	        setLayout(null);
	        add(btnReturn);
	        add(jScrollPane1);
	        add(lblInformationsComplmentaires);
	        add(lblClient);
	        add(lblDateLivraison);
	        add(lblLivreur);
	        add(lblTarif);
	        add(lblDateCommande);
	        add(lblPizzaChoisie);
	        add(lblTaille);
	    }
	  
	  void InitCommandesTable()
	  {
		  jScrollPane1 = new javax.swing.JScrollPane();
		   jScrollPane1.setLocation(10, 22);
		   jScrollPane1.setSize(700, 204);
	        CmdTable = new javax.swing.JTable();
	        CmdTable.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		JTable table = (JTable)e.getSource();
	        		Point p = e.getPoint();
	        		int row = table.rowAtPoint(p);       		
	        		OnSelectionShowInfos(row);
	        	}
	        });

	        setPreferredSize(new java.awt.Dimension(720, 423));

	        try {
				allCmds = DAOCommande.getThatDAO().GetAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        Object[][] cmdObject = new Object[allCmds.size()][4];
	        
	        for (int i = 0; i < allCmds.size(); i++) {
	        	cmdObject[i][0] = allCmds.get(i).id;
	        	cmdObject[i][1] = allCmds.get(i).client.nom + " " + allCmds.get(i).client.prenom;
	        	cmdObject[i][2] = allCmds.get(i).dateCommande;
	        	cmdObject[i][3] = allCmds.get(i).prix;
	        }

	        CmdTable.setModel(new javax.swing.table.DefaultTableModel(
	            cmdObject,
	            new String [] {
	                "N Commande", "Client", "Date", "Tarif"
	            }
	        ) {
	            /**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				Class[] types = new Class [] {
	                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
	            };
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false
	            };

	            public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
	        CmdTable.setColumnSelectionAllowed(true);
	        CmdTable.getTableHeader().setReorderingAllowed(false);
	        jScrollPane1.setViewportView(CmdTable);
	        CmdTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        if (CmdTable.getColumnModel().getColumnCount() > 0) {
	            CmdTable.getColumnModel().getColumn(0).setResizable(false);
	            CmdTable.getColumnModel().getColumn(1).setResizable(false);
	            CmdTable.getColumnModel().getColumn(2).setResizable(false);
	            CmdTable.getColumnModel().getColumn(3).setResizable(false);
	        }
  
	  }

}
