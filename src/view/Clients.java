package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ViewController;

public class Clients extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Clients(MainFrame menu) {
		setBackground(Color.LIGHT_GRAY);
		setBounds(100,100,720,423);
		setLayout(null);
		Button_Return();
	}
	
	public void Button_Return(){
		
		JButton btnReturn = new JButton("Retour");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent quitter) {
				ViewController.setAnDrawNewView("Menu");
			}
		});
		btnReturn.setBounds(600, 390, 100, 30);
		add(btnReturn);
		btnReturn.setFocusPainted(false);
		
	}

}
