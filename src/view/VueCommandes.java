package view;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
//Deprecated
public class VueCommandes extends JPanel {
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the panel.
	 */
	public VueCommandes() {
		setBounds(145, 11, 649, 468);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 11, 381, 446);
		add(scrollPane);
		
		table_1 = setJTableBis();
		scrollPane.setViewportView(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(412, 154, 214, 303);
		add(scrollPane_1);
		
		table_2 = setJTable();
		scrollPane_1.setViewportView(table_2);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(413, 12, 99, 14);
		add(lblPrix);
		
		JLabel lblLivreur = new JLabel("Livreur");
		lblLivreur.setBounds(412, 37, 100, 14);
		add(lblLivreur);
		
		JLabel lblDateDeLivraison = new JLabel("Date de Livraison");
		lblDateDeLivraison.setBounds(413, 62, 99, 14);
		add(lblDateDeLivraison);
		
		JLabel lblTransports = new JLabel("Transports");
		lblTransports.setBounds(412, 86, 100, 14);
		add(lblTransports);
		
		JLabel lblFormat = new JLabel("Format");
		lblFormat.setBounds(412, 111, 100, 14);
		add(lblFormat);
		
		

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
 
        String[] entetes = {"date", "ID Commande", "Pizza", "ID Livraison", "Etat"};
        
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


