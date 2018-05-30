package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import controller.ViewController;
import javax.swing.LayoutStyle.ComponentPlacement;

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
	
	public Livreurs(MainFrame menu) {
		
			
			setBackground(Color.LIGHT_GRAY);
			setBounds(100,100,720,423);
			setLayout(null);
			InitLivreursTable();
			Button_Return();
			DisplayLivreurInfos();
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
	
	// TODO Remplir la table "LivreursTable" au chargement du panel (Colonnes : "Nom", "Prenom", "Argent rapporté (total)")
	void OnLoadFillCmdTable()
	{
				
	}
		
	// TODO Afficher toutes les infos d'un livreur lorsque la ligne dans "LivreursTable est selectionnée en s'aidant des différents labels 
	// (nom + prenom livreur + vehicule le plus utilisé + nb total de livraisons effectuées + nb de commandes en retard + argent total rapporté)
	// Par défaut afficher la cmd à l'index 0
	void OnSelectionShowInfos()
	{
				
	}
	  private void DisplayLivreurInfos() {

	     
	        
	        lblInformationsComplmentaires = new JLabel("Informations compl\u00E9mentaires :");
	        lblInformationsComplmentaires.setBounds(21, 249, 339, 29);
	        lblInformationsComplmentaires.setFont(new Font("Tahoma", Font.PLAIN, 24));
	        
	        lblNom = new JLabel("Nom :");
	        lblNom.setBounds(21, 300, 38, 17);
	        lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        lblPrenom = new JLabel("Prenom :");
	        lblPrenom.setBounds(226, 300, 72, 17);
	        lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        lblBestVehicle = new JLabel("V\u00E9hicule pr\u00E9f\u00E9r\u00E9 :");
	        lblBestVehicle.setBounds(21, 347, 119, 17);
	        lblBestVehicle.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        lblNbLivraisons = new JLabel("Nombre de livraisons:");
	        lblNbLivraisons.setBounds(226, 344, 131, 17);
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
	        lblNombreDeRetards.setBounds(416, 347, 131, 17);
	        add(lblNombreDeRetards);
	        
	        lblArgentTotalRapport = new JLabel("Argent total rapport\u00E9 :");
	        lblArgentTotalRapport.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblArgentTotalRapport.setBounds(416, 303, 157, 17);
	        add(lblArgentTotalRapport);
	    }
	  
	  void InitLivreursTable()
	  {
		   jScrollPane1 = new javax.swing.JScrollPane();
	        jScrollPane1.setBounds(21, 22, 679, 204);
	        LivreursTable = new javax.swing.JTable();

	        LivreursTable.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null},
	                {null, null, null},
	                {null, null, null},
	                {null, null, null},
	                {null, null, null},
	                {null, null, null},
	                {null, null, null},
	                {null, null, null},
	                {null, null, null},
	                {null, null, null},
	                {null, null, null},
	                {null, null, null}
	            },
	            new String [] {
	                "Nom", "Prenom", "Argent rapporté"
	            }
	        ) {

				private static final long serialVersionUID = 1L;
				Class[] types = new Class [] {
	                java.lang.String.class, java.lang.String.class, java.lang.Float.class
	            };
	            boolean[] canEdit = new boolean [] {
	                false, false, false
	            };

	            public Class getColumnClass(int columnIndex) {
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
