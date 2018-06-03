package view;

import java.awt.Color;
import metier.Livreur;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;


import controller.ViewController;

import DAO.DAOLivreur;
import DAO.DAOTransport;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Livreurs extends JPanel {


	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable LivreursTable;
	    
	private static final long serialVersionUID = 1L;
	private JLabel lblInformationsComplmentaires;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblBestVehicle;
	private JLabel lblNbLivraisons;  
	private JButton btnReturn;
	private JLabel lblNombreDeRetards;
	private JLabel lblArgentTotalRapport;
	
	public Vector<Livreur> allLivreurs = null;
	
	public Livreurs(MainFrame menu) {
		
			
		setBackground(Color.LIGHT_GRAY);
		setBounds(100,100,720,423);
		setLayout(null);
		InitLivreursTable();
		Button_Return();
		DisplayLivreurInfos();
		OnSelectionShowInfos(0);
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
	
	void OnSelectionShowInfos(int index)
	{
		String nomString = "Nom : " + allLivreurs.get(index).nom;
		String prenomString = "Prenom : " + allLivreurs.get(index).prenom;
		String nbLivraisonString = "";
		String argentString = "";
		String vehiculeString = "";
		String nbRetardString = "";
		
		int vehicleID = 0;
		try {
			nbLivraisonString = "Nombre de livraisons : " + Integer.toString(DAOLivreur.getThatDAO().GetNbDeliveryById(index + 1));
			argentString = "Argent total rapporté : " + String.valueOf(DAOLivreur.getThatDAO().GetMoneyEarnedById(index + 1));
			vehicleID = DAOLivreur.getThatDAO().GetFavoriteVehiculeById(index + 1);
			if(vehicleID != 0)
			{
				vehiculeString = "Véhicule préféré : " + DAOTransport.getThatDAO().GetById(vehicleID).nom;
			}
			else
			{
				vehiculeString = "Véhicule préféré : Aucun" ;
			}
		
			nbRetardString = "Nombre de retards : " + Integer.toString(DAOLivreur.getThatDAO().GetNbLateDeliveryById(index + 1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblNom.setText(nomString);
		lblPrenom.setText(prenomString);
		lblArgentTotalRapport.setText(argentString);
		lblBestVehicle.setText(vehiculeString);
		lblNbLivraisons.setText(nbLivraisonString);
		lblNombreDeRetards.setText(nbRetardString);
	}
	  private void DisplayLivreurInfos() {

	     
	        
		  	lblInformationsComplmentaires = new JLabel("Informations compl\u00E9mentaires :");
	        lblInformationsComplmentaires.setBounds(21, 249, 339, 29);
	        lblInformationsComplmentaires.setFont(new Font("Tahoma", Font.PLAIN, 24));
	        
	        lblNom = new JLabel("Nom :");
	        lblNom.setBounds(21, 300, 191, 17);
	        lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        lblPrenom = new JLabel("Prenom :");
	        lblPrenom.setBounds(226, 300, 176, 17);
	        lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        lblBestVehicle = new JLabel("V\u00E9hicule pr\u00E9f\u00E9r\u00E9 :");
	        lblBestVehicle.setBounds(21, 347, 191, 17);
	        lblBestVehicle.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        lblNbLivraisons = new JLabel("Nombre de livraisons:");
	        lblNbLivraisons.setBounds(226, 347, 176, 17);
	        lblNbLivraisons.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        setLayout(null);
	        add(btnReturn);
	        add(lblNom);
	        add(jScrollPane1);
	        add(lblInformationsComplmentaires);
	        add(lblPrenom);
	        add(lblBestVehicle);
	        add(lblNbLivraisons);
	        
	        lblNombreDeRetards = new JLabel("Nombre de retards:");
	        lblNombreDeRetards.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblNombreDeRetards.setBounds(416, 347, 284, 17);
	        add(lblNombreDeRetards);
	        
	        lblArgentTotalRapport = new JLabel("Argent total rapport\u00E9 :");
	        lblArgentTotalRapport.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblArgentTotalRapport.setBounds(416, 303, 284, 17);
	        add(lblArgentTotalRapport);
	    }
	  
	  void InitLivreursTable()
	  {
		   jScrollPane1 = new javax.swing.JScrollPane();
	        jScrollPane1.setBounds(21, 22, 679, 204);
	        LivreursTable = new javax.swing.JTable();
	        LivreursTable.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent arg0) {
	        		JTable table = (JTable)arg0.getSource();
	        		Point p = arg0.getPoint();
	        		int row = table.rowAtPoint(p);     		
	        		OnSelectionShowInfos(row);
	        	}
	        });

	        try {
				allLivreurs = DAOLivreur.getThatDAO().GetAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Object[][] livreurObject = new Object[allLivreurs.size()][3];
	        
	        for (int i = 0; i < allLivreurs.size(); i++) {
	        	livreurObject[i][0] = allLivreurs.get(i).nom;
	        	livreurObject[i][1] = allLivreurs.get(i).prenom;
	        	try {
					livreurObject[i][2] = DAOLivreur.getThatDAO().GetMoneyEarnedById(allLivreurs.get(i).id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }

	        LivreursTable.setModel(new javax.swing.table.DefaultTableModel(
	            livreurObject,
	            new String [] {
	                "Nom", "Prenom", "Argent rapporte"
	            }
	        ) {

				private static final long serialVersionUID = 1L;
				@SuppressWarnings("rawtypes")
				Class[] types = new Class [] {
	                java.lang.String.class, java.lang.String.class, java.lang.Float.class
	            };
	            boolean[] canEdit = new boolean [] {
	                false, false, false
	            };

	            public Class<?> getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
	        LivreursTable.setColumnSelectionAllowed(true);
	        LivreursTable.getTableHeader().setReorderingAllowed(false);
	        jScrollPane1.setViewportView(LivreursTable);
	        LivreursTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        if (LivreursTable.getColumnModel().getColumnCount() > 0) {
	            LivreursTable.getColumnModel().getColumn(0).setResizable(false);
	            LivreursTable.getColumnModel().getColumn(1).setResizable(false);
	            LivreursTable.getColumnModel().getColumn(2).setResizable(false);
	        }
	  }

}
