package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import controller.ViewController;
import javax.swing.border.LineBorder;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConnectWindow extends JPanel {

	private static final long serialVersionUID = -7305664800426191162L;
	private JTextField ndc_entry;
	private JPasswordField mdp_entry;
	@SuppressWarnings("unused")
	private MainFrame FA;
	private JPanel auth_panel = new JPanel();
	

	public ConnectWindow(MainFrame PFA){
		FA = PFA;
		panel_init();
		ndc_zone();
		mdp_zone();
	
		btn_zone();
	}
	
	/** Initialise les différents panels de la vue **/
	public void panel_init(){
		
		JPanel connect = this;
		connect.setBounds(100,100,720,468);
		connect.setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel auth_container = new JPanel();
		auth_container.setBackground(new Color(255, 255, 255));
		auth_container.setLayout(null);
		add(auth_container, BorderLayout.CENTER);
		
		auth_panel = new JPanel();
		auth_panel.setBorder(new LineBorder(new Color(150, 150, 150)));
		auth_panel.setBackground(new Color(231,231,231));
		auth_panel.setBounds(161, 89, 414, 257);
		auth_panel.setLayout(null);
		auth_container.add(auth_panel);
		
		
	}
	
	/** Initialise le label et l'entry pour le nom de compte **/
	public void ndc_zone(){
		
		JLabel ndc_label = new JLabel("Nom :");
		ndc_label.setForeground(Color.BLACK);
		ndc_label.setBounds(58, 28, 160, 32);
		ndc_label.setIcon(new ImageIcon(ConnectWindow.class.getResource("/view/img/icons/auth/user.png")));
		ndc_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		auth_panel.add(ndc_label);
		
		
		ndc_entry = new JTextField("admin");
		ndc_entry.setBounds(97, 59, 232, 20);
		ndc_entry.setColumns(20);
		auth_panel.add(ndc_entry);
		
		
	}
	
	/** Initialise le label et l'entry pour le mot de passe **/
	public void mdp_zone(){
		
		JLabel mdp_label = new JLabel(" Mot de passe :");
		mdp_label.setForeground(Color.BLACK);
		mdp_label.setBounds(58, 96, 286, 32);
		mdp_label.setIcon(new ImageIcon(ConnectWindow.class.getResource("/view/img/icons/auth/password.png")));
		mdp_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		auth_panel.add(mdp_label);
		
		
		mdp_entry = new JPasswordField("admin");
		mdp_entry.setBounds(98, 139, 231, 20);
		auth_panel.add(mdp_entry);
		
		mdp_entry.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER){
					logged();
				}
			}
		});
		
	}
	

	
	
	/** Initialise le bouton de connexion **/
	public void btn_zone(){

		
		JButton connect_btn = new JButton("Connexion");
		connect_btn.setForeground(Color.WHITE);
		connect_btn.setBorder(new LineBorder(new Color(101,125,155)));
		connect_btn.setBackground(new Color(101,125,155));
		connect_btn.setBounds(98, 208, 231, 23);
		auth_panel.add(connect_btn);
		
		connect_btn.addActionListener(new EcouteurBoutonConnection());
	}

			/** ActionListener du bouton de connexion **/
			public class EcouteurBoutonConnection implements ActionListener{
				public void actionPerformed(ActionEvent clic){
					logged();
}	
	}
	
	private void logged(){
				
				
					ViewController.setAnDrawNewView("Menu");
	}
			


}
