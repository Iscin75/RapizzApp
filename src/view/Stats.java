package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ViewController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;



public class Stats extends JPanel {

private static final long serialVersionUID = 1L;
	
	
	JButton btnStatsLivreurs;
	JButton btnStatsClients;
	JButton btnStatsPizzas;

	public Stats(MainFrame menu) {
		
		setBackground(Color.LIGHT_GRAY);
		setBounds(100,100,720,423);
		InitStatsChoiceButtons();
		Button_Return();
		
		
	}
	
	// TODO Au clic sur le boutton btnStatsLivreurs afficher les infos suivantes : celui qui a fait le plus de livraisons, le plus rapide, le plus en retard
	void OnClickStatsLivreurs()
	{
		
	}
	
	// TODO Au clic sur le boutton btnStatsClients afficher les infos suivantes : le client le plus fidele (+ de commandes/plus d'argent, le moins fidele)
	void OnClickStatsClients()
	{
		
	}
	
	// TODO Au clic sur le boutton btnStatsPizzas afficher les infos suivantes : la pizza la plus vendue, l'ingrédient le plus utilisé, la taille de pizza la plus vendue)
	void OnClickStatsPizzas()
	{
		
	}
	
	void InitStatsChoiceButtons()
	{
		btnStatsLivreurs = new JButton("Stats Livreurs");
		btnStatsLivreurs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStatsLivreurs.setBounds(10, 11, 125, 40);
		add(btnStatsLivreurs);
		
		btnStatsClients = new JButton("Stats Clients");
		btnStatsClients.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStatsClients.setBounds(176, 11, 125, 40);
		add(btnStatsClients);
		
		btnStatsPizzas = new JButton("Stats Pizzas");
		btnStatsPizzas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStatsPizzas.setBounds(341, 11, 125, 40);
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

