package view;
import javax.swing.JButton;
import javax.swing.JPanel;


import controller.ViewController;
import metier.Pizza;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;

import java.util.Vector;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import DAO.DAOPizza;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JTextPane;



public class Pizzas extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel lblInformations;
	JLabel lblNom;
	JTextPane lblIngrdients = new JTextPane();
	JLabel lblTarifs;
	JLabel lblNaine;
	JLabel lblHumaine;
	JLabel lblOgresse;
	JTree ArbrePizzas;
	JLabel lblPrixNaine = new JLabel("");
	JLabel lblPrixHumaine = new JLabel("");
	JLabel lblPrixOgresse = new JLabel("");
	Vector<Pizza> allPizzas = null;
	int[] startIndex = new int[1];
	

	public Pizzas(MainFrame menu) {
		
		startIndex[0] = 1;
		setBackground(Color.LIGHT_GRAY);
		setBounds(100,100,720,423);
		CreatePizzaTree();
		DisplayPizzaInfos();
		OnSelectionShowPizzaInfos(startIndex);
		Button_Return();
	
		
			
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


	void OnSelectionShowPizzaInfos(int index[])
	{
		if(index[0] != 0)
		{
		lblNom.setText("Nom : " + allPizzas.get(index[0]-1).nom);
		
		lblIngrdients.setText("Ingrédients : ");
		for(int i = 0; i < allPizzas.get(index[0]-1).ingredients.size(); i++)
		{
			
			lblIngrdients.setText(lblIngrdients.getText() + allPizzas.get(index[0]-1).ingredients.get(i).nom + ", " );
		}
		DecimalFormat df = new DecimalFormat("##.00");
		lblPrixNaine.setText(String.valueOf(df.format(allPizzas.get(index[0]-1).base_prix * 0.66f)));
		lblPrixHumaine.setText(String.valueOf(df.format(allPizzas.get(index[0]-1).base_prix)));
		lblPrixOgresse.setText(String.valueOf(df.format(allPizzas.get(index[0]-1).base_prix * 1.33f)));
		}
	}
	
	void DisplayPizzaInfos() {
		
		lblPrixNaine.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixNaine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrixNaine.setBounds(315, 315, 66, 20);
		add(lblPrixNaine);
		
		lblIngrdients.setBackground(Color.LIGHT_GRAY);
		lblIngrdients.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngrdients.setBounds(180, 136, 520, 98);
		add(lblIngrdients);
		
		lblPrixHumaine.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixHumaine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrixHumaine.setBounds(420, 315, 66, 20);
		add(lblPrixHumaine);
		
		
		lblPrixOgresse.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixOgresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrixOgresse.setBounds(510, 315, 66, 20);
		add(lblPrixOgresse);
		
		
		lblInformations = new JLabel("Informations :");
		lblInformations.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInformations.setBounds(180, 15, 200, 20);
		add(lblInformations);
		
		lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNom.setBounds(180, 78, 412, 30);
		add(lblNom);
		
		lblTarifs = new JLabel("Tarifs :");
		lblTarifs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTarifs.setBounds(180, 310, 51, 20);
		add(lblTarifs);
		
		lblNaine = new JLabel("Naine");
		lblNaine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNaine.setBounds(330, 281, 51, 20);
		add(lblNaine);
		
		lblHumaine = new JLabel("Humaine");
		lblHumaine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHumaine.setBounds(420, 281, 82, 20);
		add(lblHumaine);
		
		lblOgresse = new JLabel("Ogresse");
		lblOgresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOgresse.setBounds(510, 281, 82, 20);
		add(lblOgresse);
	}
	
	void CreatePizzaTree()
	{
		ArbrePizzas = new JTree();
		ArbrePizzas.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				
				
        
        		OnSelectionShowPizzaInfos(ArbrePizzas.getSelectionRows());

        		
			}
		});
		try {
			allPizzas = DAOPizza.getThatDAO().GetAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArbrePizzas.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Liste des pizzas") {
				/**
				 * 
				 */
				private static final long serialVersionUID = -6921231561470139968L;

				{
					for(int i = 0; i<allPizzas.size();i++)
					{
						DefaultMutableTreeNode dmtn = new DefaultMutableTreeNode(allPizzas.get(i).nom);
						add(dmtn);
						
					}
					
				}
			}
		));
		ArbrePizzas.setBounds(0, 0, 160, 420);
		add(ArbrePizzas);
	}
}
