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
	
	/**
	 * Appelle la fonction modifier avec 1 en paramètre.
	 */
	public void ajouter() {
		modifier(s.getNiveau() + 1);
	}
	/**
	 * Appelle la fonction modifier avec -1 en paramètre.
	 */
	public void retirer() {
		modifier(s.getNiveau() - 1);
	}
	
	/**
	 * Modifie ce que le parametre controle. Utiliser une valeur traduite et validé en paramètre. 
	 * @param i 
	 */
	public abstract void modifier(double i);
	
	/** 
	 * appelle la fonction mettreAJour() du Controlleur.
	 * @param i 
	 */
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
	
	/**
	 * Traduit la valeur donnée (pour un changement). Dans le cas ou le destinataire (Scene) prenne des
	 * unités différentes du Controlleur. 
	 * @param i
	 * @return 
	 */
	public abstract double traduireValeur(double i);
	
	/**
	 * Valide la valeur donnée (pour un changement). Retourne un valeur valide dans le cas échéant.
	 * @param i
	 * @return 
	 */
	public abstract double valider(double i);
	
}
