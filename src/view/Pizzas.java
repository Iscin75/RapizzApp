package view;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ViewController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Pizzas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public Pizzas(MainFrame menu) {
		
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
