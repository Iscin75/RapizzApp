package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ViewController;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import DAO.DAOClient;
import metier.Client;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Clients extends JPanel {

	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable ClientsTable;
	    
	private static final long serialVersionUID = 1L;
	private JLabel lblInformationsComplmentaires;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblAdresse;
	private JLabel lblVille;
	private JLabel lblSolde;
	private JLabel lblNombreDeCommandes;
	
	public Vector<Client> allClients = null;


	public Clients(MainFrame menu) {
		setBackground(Color.LIGHT_GRAY);
		setBounds(100,100,720,423);
		setLayout(null);
		DisplayClientInfos();
		InitClientsTable();
		OnSelectionShowInfos(0);
	
		
		Button_Return();

	}
	
	
	// TODO Nb de Cmd
	void OnSelectionShowInfos(int index) 
	{
		String nomString = "Nom : " + allClients.get(index).nom;
		String prenomString = "Prenom : " + allClients.get(index).prenom;
		String adrString = "Adresse : " + allClients.get(index).adresse;
		String soldeString = "Solde : " + allClients.get(index).solde + "€";
		String villeString = "Ville : " + allClients.get(index).ville;
		String nbComString = "";
		try {
			nbComString = "Nombre de commandes : "  + Integer.toString(DAOClient.getThatDAO().GetNbOrderById(index+1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblNom.setText(nomString);
		lblPrenom.setText(prenomString);
		lblAdresse.setText(adrString);
		lblSolde.setText(soldeString);
		lblVille.setText(villeString);
		lblNombreDeCommandes.setText(nbComString);		
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
	
	  private void DisplayClientInfos() {

	      
	        
	        lblInformationsComplmentaires = new JLabel("Informations compl\u00E9mentaires :");
	        lblInformationsComplmentaires.setBounds(21, 249, 339, 29);
	        lblInformationsComplmentaires.setFont(new Font("Tahoma", Font.PLAIN, 24));
	        add(lblInformationsComplmentaires);
	        
	        lblNom = new JLabel("Nom :");
	        lblNom.setBounds(21, 300, 179, 17);
	        lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        add(lblNom);
	        
	        lblPrenom = new JLabel("Prenom :");
	        lblPrenom.setBounds(210, 300, 134, 17);
	        lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        add(lblPrenom);
	        
	        lblAdresse = new JLabel("Adresse :");
	        lblAdresse.setBounds(373, 300, 327, 17);
	        lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        add(lblAdresse);
	        
	        lblVille = new JLabel("Ville :");
	        lblVille.setBounds(373, 328, 327, 17);
	        lblVille.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        add(lblVille);
	        
	        lblSolde = new JLabel("Solde :");
	        lblSolde.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblSolde.setBounds(21, 362, 195, 17);
	        add(lblSolde);
	        
	        lblNombreDeCommandes = new JLabel("Nombre de commandes :");
	        lblNombreDeCommandes.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblNombreDeCommandes.setBounds(229, 362, 306, 17);
	        add(lblNombreDeCommandes);

	    }
	  
	  void InitClientsTable()
	  {
		  jScrollPane1 = new javax.swing.JScrollPane();
	        ClientsTable = new javax.swing.JTable();
	        ClientsTable.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent arg0) {
	        		
	        		JTable table = (JTable)arg0.getSource();
	        		Point p = arg0.getPoint();
	        		int row = table.rowAtPoint(p);
	        		
	        		OnSelectionShowInfos(row);
	        	}
	        });
	       
	        jScrollPane1.setBounds(21, 22, 679, 204);

	        try {
				allClients = DAOClient.getThatDAO().GetAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        Object[][] clientObject = new Object[allClients.size()][3];
	        
	        for (int i = 0; i < allClients.size(); i++) {
	        	clientObject[i][0] = allClients.get(i).nom;
	        	clientObject[i][1] = allClients.get(i).prenom;
	        	clientObject[i][2] = allClients.get(i).solde;
	        }

	        ClientsTable.setModel(new javax.swing.table.DefaultTableModel(
	            clientObject,
	            new String [] {
	                "Nom", "Prenom", "Solde"
	            }
	        ) {
	            /**
				 * 
				 */
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
	        ClientsTable.setColumnSelectionAllowed(true);
	        ClientsTable.getTableHeader().setReorderingAllowed(false);
	        jScrollPane1.setViewportView(ClientsTable);
	        ClientsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        if (ClientsTable.getColumnModel().getColumnCount() > 0) {
	            ClientsTable.getColumnModel().getColumn(0).setResizable(false);
	            ClientsTable.getColumnModel().getColumn(1).setResizable(false);
	            ClientsTable.getColumnModel().getColumn(2).setResizable(false);
	        }
	       
	        add(jScrollPane1);

	  }
	  
	  
}
