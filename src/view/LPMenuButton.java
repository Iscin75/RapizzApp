package vue;

import javax.swing.JPanel;
import javax.swing.JButton;

public class LPMenuButton extends JPanel {

	/**
	 * Create the panel.
	 */
	public LPMenuButton() {
		setBounds(0, 0, 218, 561);
		setLayout(null);
		
		JButton btnNewButton = new JButton("Commandes");
		btnNewButton.setBounds(10, 225, 198, 73);
		add(btnNewButton);
		
		JButton button = new JButton("Pizzas");
		button.setBounds(10, 309, 198, 73);
		add(button);
		
		JButton button_1 = new JButton("Clients");
		button_1.setBounds(10, 393, 198, 73);
		add(button_1);
		
		JButton button_2 = new JButton("Statistiques");
		button_2.setBounds(10, 477, 198, 73);
		add(button_2);
	}
}
