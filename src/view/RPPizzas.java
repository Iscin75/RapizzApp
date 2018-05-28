package view;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RPPizzas extends JPanel {

	/**
	 * Create the panel.
	 */
	public RPPizzas() {
		setBounds(228, 0, 706, 561);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 189, 539);
		add(scrollPane);
		
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(230, 11, 108, 43);
		add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(230, 127, 108, 43);
		add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setBounds(230, 237, 108, 43);
		add(label_1);
	}
}
