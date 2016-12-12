package parametres;

import controle.Controlleur;
import gestionObjets.Scene;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public abstract class Parametre {
	Scene s;
	Controlleur c;
	int valeur;
	
	public Parametre(Controlleur controller, Scene scene) {
		s = scene;
		c = controller;
	}
	
	public void ajouter() {
		modifier(s.getNiveau() + 1);
	}
	public void retirer() {
		modifier(s.getNiveau() - 1);
	}
	
	public void mettreAJour(double i) {
		c.mettreAJour((int)i);
		s.repaint();
	}
	
	public double getValeurDefaut(){
		return 0;
	}
	
	public abstract String getNom();
	public abstract int getMin();
	public abstract int getMax();
	
	
	public abstract double traduireValeur(double i);
	public abstract double valider(double i);
	public abstract void modifier(double i);
	
	
	
	
	
}
