import java.util.Vector;



import DAO.*;
import metier.*;

public class main {

	public static void main(String[] args) {
		

		DAOPizza daoPizza = DAOPizza.getThatDAO();
		Vector<Pizza> pizzas = daoPizza.GetAll();
		for (int i=0; i<pizzas.size();i++) {
			System.out.print(pizzas.get(i).id+pizzas.get(i).nom );
			for (int j=0; j<pizzas.get(i).ingredients.size();j++) {
				System.out.print(pizzas.get(i).ingredients.get(j).id +pizzas.get(i).ingredients.get(j).nom );
			}
			System.out.println("");
		}
		//TODO créer la commande affichant la JFrame
	}

}
