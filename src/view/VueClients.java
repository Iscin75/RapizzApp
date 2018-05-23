package vue;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
//Deprecated
public class VueClients extends JPanel {
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the panel.
	 */
	public VueClients() {
		setBounds(145, 11, 649, 468);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 11, 381, 446);
		add(scrollPane);
		
		table_1 = setJTableBis();
		scrollPane.setViewportView(table_1);
		
		JLabel lblNom = new JLabel("nom");
		lblNom.setBounds(435, 12, 86, 14);
		add(lblNom);
		
		JLabel lblMdp = new JLabel("mdp");
		lblMdp.setBounds(435, 37, 86, 14);
		add(lblMdp);
		
		JLabel lblSolde = new JLabel("solde");
		lblSolde.setBounds(435, 59, 86, 14);
		add(lblSolde);
		
		JLabel lblNbcommandes = new JLabel("nbCommandes");
		lblNbcommandes.setBounds(435, 84, 86, 14);
		add(lblNbcommandes);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(412, 154, 214, 303);
		add(scrollPane_1);
		
		table_2 = setJTable();
		scrollPane_1.setViewportView(table_2);
		
		

	}
	
	public JTable setJTable(){
		Object[][] donnees = {
                {"Johnathan",  true, Sport.TENNIS},
                {"Nicolas",  true, Sport.FOOTBALL},
                {"Damien",  true, Sport.RIEN},
                {"Corinne",  false, Sport.NATATION},
                {"Emilie",  false, Sport.FOOTBALL},
                {"Delphine",  false, Sport.TENNIS},
                {"Eric", true, Sport.FOOTBALL},
        };
 
        String[] entetes = { "Nom", "solde", "Nbre Commande" };
        
        table = new JTable(donnees, entetes);
        table.setAutoCreateRowSorter(true);
        return table;
	}
	
	public JTable setJTableBis(){
		Object[][] donnees = {
                {"Johnathan", "Sykes", Color.red, true, Sport.TENNIS},
                {"Nicolas", "Van de Kampf", Color.black, true, Sport.FOOTBALL},
                {"Damien", "Cuthbert", Color.cyan, true, Sport.RIEN},
                {"Corinne", "Valance", Color.blue, false, Sport.NATATION},
                {"Emilie", "Schrödinger", Color.magenta, false, Sport.FOOTBALL},
                {"Delphine", "Duke", Color.yellow, false, Sport.TENNIS},
                {"Eric", "Trump", Color.pink, true, Sport.FOOTBALL},
        };
 
        String[] entetes = {"Date", "ID Commande", "Prix", "ID Livraison", "Etat"};
        
        table = new JTable(donnees, entetes);
        table.setAutoCreateRowSorter(true);
        return table;
	}
	public enum Sport {
	    TENNIS,
	    FOOTBALL,
	    NATATION,
	    RIEN;
	}
}


