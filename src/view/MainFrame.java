package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {


	private static final long serialVersionUID = -70427993833584366L;
	private JPanel header;
	private JPanel footer;
	private JPanel corps;
	
	public MainFrame(){
		
		initialize();
	}
	
	private void initialize() {
		try{
			this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/view/img/logo.png")));
			this.setBounds(100, 100, 720, 520);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BorderLayout(0, 0));
			this.setResizable(false);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void header_content(){	
		this.getContentPane().add(header,BorderLayout.NORTH);
	}
	public JPanel getHeader(){
		return header;
	}
	public void setHeader(JPanel header){
		this.header = header;
	}	
	

	public void corps(){	
		this.getContentPane().add(corps,BorderLayout.CENTER);
		
	
	}
	public JPanel getCorps(){
		return corps;
		
	}
	public void setCorps(JPanel c){
		
		this.corps = c;
		
	}
	
	public void footer_content(){	
		this.getContentPane().add(footer,BorderLayout.SOUTH);
	}
	public void setFooter(JPanel footer){
		this.footer = footer;
	}
	
	public void remake(){
		corps();
		header_content();
		revalidate();
		repaint();
	}

}
