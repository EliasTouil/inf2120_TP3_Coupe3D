package parametres;

import gestionObjets.Scene;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class Niveau implements Parametre {

	Scene s;

	public Niveau(Scene scene) {
		s = scene;
	}

	@Override
	public double traduireValeur(double i) {
		return i;
	}

	@Override
	public void modifier(double i) {
		s.setNiveau((int) valider(i));
		s.repaint();
	}

	@Override
	public void ajouter() {
		s.setNiveau(s.getNiveau() + 1);
		s.repaint();
	}

	@Override
	public void retirer() {
		s.setNiveau(s.getNiveau() - 1);
		s.repaint();
	}

	@Override
	public int getMin() {
		return 0;
	}

	@Override
	public int getMax() {
		return s.getNiveauMaximum();
	}

	@Override
	public int getValeurDefaut() {
		return 50;
	}

	@Override
	public double valider(double entree) {
		
		if (entree > s.getNiveauMaximum() ){
			entree = s.getNiveauMaximum();
		} else if ( entree < 0 ){
			entree = 0 ; 
		}
		
		return entree;
	}

	@Override
	public void mettreAJour(double i) {
		s.setNiveau((int) i);
		
	}

	@Override
	public String getNom() {
		return "niveau";
	}

}
