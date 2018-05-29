package view.includes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.border.MatteBorder;


public class Footer extends JPanel {

	private static final long serialVersionUID = -3970006906907270831L;

	public Footer( ){
		setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		init();
	}
	
	private void init(){

		JPanel footer = this;
		footer.setBackground(new Color(101,125,155));
		setLayout(new BorderLayout(0, 0));
		
		//----------/ Texte Droit du bas de page
		JLabel lbl_date = new JLabel("Rapizz 2017/2018");
		lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_date.setForeground(Color.WHITE);
		lbl_date.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_date.setBounds(307, 0, 87, 14);
		footer.add(lbl_date);
		
		//----------/ Texte Gauche du bas de page
		JLabel lbl_team = new JLabel("Moua/Jouniot/Xiao/Siarri");
		lbl_team.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_team.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_team.setForeground(Color.WHITE);
		lbl_team.setBounds(0, 0, 169, 14);
		footer.add(lbl_team, BorderLayout.WEST);
	}


}
