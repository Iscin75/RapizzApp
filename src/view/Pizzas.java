package view;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ViewController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JLabel;
import java.awt.Font;



public class Pizzas extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel lblInformations;
	JLabel lblNom;
	JLabel lblIngrdients;
	JLabel lblTarifs;
	JLabel lblNaine;
	JLabel lblHumaine;
	JLabel lblOgresse;
	JTree ArbrePizzas;
	
	public Pizzas(MainFrame menu) {
		
		setBackground(Color.LIGHT_GRAY);
		setBounds(100,100,720,423);
		CreatePizzaTree();
		DisplayPizzaInfos();
		OnSelectionShowPizzaInfos(0);
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


	
	//TODO Au clic sur un element du Jtree afficher les caract de la pizza dans les labels correspondants (nom + ingrédients + tarif naine/humaine/ogresse)
	// Par défault choisir la pizza 0
	void OnSelectionShowPizzaInfos(int index)
	{
		
	}
	
	void DisplayPizzaInfos() {
		
		lblInformations = new JLabel("Informations :");
		lblInformations.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInformations.setBounds(180, 15, 200, 20);
		add(lblInformations);
		
		lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNom.setBounds(180, 78, 46, 14);
		add(lblNom);
		
		lblIngrdients = new JLabel("Ingr\u00E9dients :");
		lblIngrdients.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngrdients.setBounds(180, 147, 151, 20);
		add(lblIngrdients);
		
		lblTarifs = new JLabel("Tarifs :");
		lblTarifs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTarifs.setBounds(180, 270, 51, 20);
		add(lblTarifs);
		
		lblNaine = new JLabel("Naine");
		lblNaine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNaine.setBounds(330, 241, 51, 20);
		add(lblNaine);
		
		lblHumaine = new JLabel("Humaine");
		lblHumaine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHumaine.setBounds(420, 241, 82, 20);
		add(lblHumaine);
		
		lblOgresse = new JLabel("Ogresse");
		lblOgresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOgresse.setBounds(510, 241, 82, 20);
		add(lblOgresse);
	}
	
	void CreatePizzaTree()
	{
		ArbrePizzas = new JTree();
		ArbrePizzas.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Liste des pizzas") {
				{
					add(new DefaultMutableTreeNode("TODO"));
					add(new DefaultMutableTreeNode(""));
				}
			}
		));
		ArbrePizzas.setBounds(0, 0, 141, 420);
		add(ArbrePizzas);
	}
}
