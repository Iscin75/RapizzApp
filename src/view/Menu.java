package view;

import javax.swing.JPanel;

import controller.ViewController;


import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import view.MainFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;
	private String purl;
	
	/** Liste des différents noms de boutons du menu == use case (obviously) **/
	String[] listName = {"Clients","Livreurs","Commandes","Stats","Pizzas"};
	
	
	public Menu(MainFrame PFA){
		
		setLayout(null);
		panel_zone();
		label_zone();
		Clients_zone();
		Livreurs_Zone();
		Commandes_Zone();
		Stats_Zone();
		Pizzas_Zone();
		Quitter_zone();
	}

	public void panel_zone() {
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 150, 440);
		panel.setBackground(new Color(66, 76, 88));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/view/img/logo2.png")));
		lblNewLabel.setBounds(21, 179, 106, 83);
		panel.add(lblNewLabel);
	}
	

	public void label_zone() {
		
		int pos = 15;
		for(int i = 0; i < 5; i++){
			String s = listName[i];
			JLabel t = new JLabel(s);
			t.setBounds(275, pos, 160, 75);
			t.setFont(new Font("Thoma", Font.BOLD, 18));
			pos += 85;
			add(t);
		}
		
	}


	public void Clients_zone() {
		
		JButton ClientsButton = new JButton(image("customer.png"));
		ClientsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Clic) {
				ViewController.setAnDrawNewView("Clients");
			}
		});
		ClientsButton.setBounds(200, 15, 70, 70);
		add(ClientsButton);
		ClientsButton.setFocusPainted(false);
		
	}

	
	public void Livreurs_Zone(){
		
		JButton LivreursButton = new JButton(image("livreurs.png"));
		LivreursButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewController.setAnDrawNewView("Livreurs");
			}
		});
		LivreursButton.setBounds(200, 100, 70, 70);
		add(LivreursButton);
		LivreursButton.setFocusPainted(false);
		
	}
	
	
	public void Commandes_Zone(){
		
		JButton CommandesButton = new JButton(image("delivery.png"));
		CommandesButton.setBounds(200, 185, 70, 70);
		add(CommandesButton);
		CommandesButton.setFocusPainted(false);
		CommandesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ViewController.setAnDrawNewView("Commandes");
			}
		});
		
	}

	/** Bouton Menu Principal -> Consultation médicament **/
	public void Stats_Zone(){
		
		JButton StatsButton = new JButton(image("stats.png"));
		StatsButton.setBounds(200, 270, 70, 70);
		add(StatsButton);
		StatsButton.setFocusPainted(false);
		
		StatsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewController.setAnDrawNewView("Stats");
			}
		});
		
	}
	
	
	public void Pizzas_Zone()
	{
		JButton Pizzas_zone = new JButton(image("pizza.png"));
		Pizzas_zone.setFocusPainted(false);
		Pizzas_zone.setBounds(200, 355, 70, 70);
		add(Pizzas_zone);
		
		Pizzas_zone.setFocusPainted(false);
		
		Pizzas_zone.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewController.setAnDrawNewView("Pizzas");
			}
		});
		
	
	}
	
	/** Bouton Menu Principal -> Authentification (Deconnexion) **/
	public void Quitter_zone(){
		
		JButton btnQuitter = new JButton(image("logout.png"));
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent quitter) {
				System.exit(0);
			}
		});
		btnQuitter.setBounds(550, 355, 70, 70);
		add(btnQuitter);
		btnQuitter.setFocusPainted(false);
		
		String s = "Quitter";
		JLabel t = new JLabel(s);
		t.setBounds(625, 355, 160, 75);
		t.setFont(new Font("Thoma", Font.BOLD, 18));
		add(t);
		
		
		
		
	}
	

	private ImageIcon image(String img){
		purl = "/view/img/icons/";
		ImageIcon image = new ImageIcon(this.getClass().getResource(purl+img));
		return image;
	}
}
