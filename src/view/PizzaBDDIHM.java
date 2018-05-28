package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PizzaBDDIHM {

	private JFrame frame;
	public JPanel panelCentral;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaBDDIHM window = new PizzaBDDIHM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PizzaBDDIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 125, 468);
		frame.getContentPane().add(panel);
		
		JButton btnClients = new JButton("Clients");
		panel.add(btnClients);
		
		JButton btnCommandes = new JButton("Commandes");
		panel.add(btnCommandes);
		
		JButton btnLivraisons = new JButton("Livraisons");
		panel.add(btnLivraisons);
		
		JButton btnStatistiques = new JButton("Statistiques");
		panel.add(btnStatistiques);
		
		JPanel panel_1 = new VueClients();
		panel_1.setBounds(145, 11, 649, 468);
		panelCentral = panel_1;
		frame.getContentPane().add(panel_1);
	}
}
