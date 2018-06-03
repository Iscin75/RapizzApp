package controller;

import view.MainFrame;
import view.includes.Footer;
import view.includes.Header;
import view.ConnectWindow;
import view.Stats;
import view.Menu;
import view.Pizzas;
import view.Livreurs;


import view.Clients;
import view.Commandes;

public class ViewController {

	static String  toDraw=null;
	static MainFrame FA = new MainFrame();
	public static String id;
	public static int row;

	public static void main(String[] args) {
		try{
			
			drawNewView();

			}
		catch (Exception e) {
		 	e.printStackTrace();
		}

	}

	public static void setAnDrawNewView(String pToDraw){
		setToDraw(pToDraw);
		drawNewView();
		
	}
	public static void setToDraw(String pToDraw){
		toDraw = pToDraw;
	}
	public static void drawNewView(){
		if (toDraw==null){
			AuthentificationView();
		}else{
			switch (toDraw) {
				case "Menu":
					MenuView();
					break;
				case "Livreurs":
					ShowLivreursView();
					break;
				case "Clients":
					ShowClientsView();
					break;
				case "Stats":
					ShowStatsView();
					break;
				case "Pizzas":
					ShowPizzaView();
					break;
				case "Commandes":
					ShowCommandesView();
					break;
		
			}
				
		}
		
		
	}
	
	
	private static void AuthentificationView(){
		FA.setHeader(new Header("Authentification"));
		FA.header_content();
		
		//New footer
		FA.setFooter(new Footer());
		FA.footer_content();
		
		//New corps
		FA.setCorps(new ConnectWindow(FA));
		FA.corps();
		
		//Parametre de notre fenetre
		FA.setTitle("Rapizz - Authentification");
		FA.setVisible(true);
	}
	private static void MenuView(){
		Menu menu = new Menu(FA);
		Header menu_header = new Header("Menu Principal");
		FA.remove(FA.getCorps());
		FA.remove(FA.getHeader());
		FA.setCorps(menu);
		FA.setHeader(menu_header);
		FA.remake();
	}
	private static void ShowLivreursView(){
		Livreurs reporting = new Livreurs(FA);
		FA.remove(FA.getCorps());
		FA.remove(FA.getHeader());
		FA.setCorps(reporting);
		FA.setHeader(new Header("Consultation des livreurs"));
		FA.remake();
	}
	private static void ShowClientsView(){
		Clients reporting = new Clients(FA);
		FA.remove(FA.getCorps());
		FA.remove(FA.getHeader());
		FA.setCorps(reporting);
		FA.setHeader(new Header("Consultation des clients"));
		FA.remake();
	}
	private static void ShowStatsView(){
		Stats visiteurs = new Stats(FA);
		FA.remove(FA.getCorps());
		FA.remove(FA.getHeader());
		FA.setCorps(visiteurs);
		FA.setHeader(new Header("Consultation des statistiques"));
		FA.remake();
	}
	private static void ShowPizzaView(){
		Pizzas practiciens = new Pizzas(FA);
		FA.remove(FA.getCorps());
		FA.remove(FA.getHeader());
		FA.setCorps(practiciens);
		FA.setHeader(new Header("Consultation des pizzas"));
		FA.remake();
	}
	private static void ShowCommandesView(){
		Commandes medicaments = new Commandes(FA);
		FA.remove(FA.getCorps());
		FA.remove(FA.getHeader());
		FA.setCorps(medicaments);
		FA.setHeader(new Header("Consultation des commandes"));
		FA.remake();
	}


	
	
}
