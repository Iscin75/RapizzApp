package view;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LPConnexion extends JPanel {

	/**
	 * Create the panel.
	 */
	private BufferedImage image;
	private JTextField textField;
	private JTextField textField_1;
	public LPConnexion() {

		try {
			JLabel background = new JLabel(new ImageIcon(ImageIO.read(new File("d:/basketball_colour.jpg"))));
			  File input = new File("d:/basketball_colour.jpg");
			     image = ImageIO.read(input);
			      
			    } catch (IOException ie) {
			      System.out.println("Error:"+ie.getMessage());
			    }
	   
		

		setBounds(0, 0, 218, 561);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Connexion :");
		lblNewLabel.setBounds(10, 109, 86, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 134, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe :");
		lblNewLabel_1.setBounds(10, 165, 86, 14);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 190, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);

	}
	
    public void paintComponent(Graphics g) {
    	g.drawImage( image, 10, 10, 100,100, null);
    } 
}
