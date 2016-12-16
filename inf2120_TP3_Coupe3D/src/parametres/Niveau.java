package parametres;

import controle.Controlleur;
import gestionObjets.Scene;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class Niveau extends Parametre {

	public Niveau(Controlleur c, Scene s) {
		super(c, s);
	}

	@Override
	public double traduireValeur(double i) {
		return i;
	}

	@Override
	public void modifier(double i) {
		double valValide = valider(i);
		s.setNiveau((int) valValide);
		mettreAJour(valValide);
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
	public double getValeurDefaut() {
		return 50;
	}

	@Override
	public double valider(double entree) {

		if (entree > s.getNiveauMaximum()) {
			entree = s.getNiveauMaximum();
		} else if (entree < 0) {
			entree = 0;
		}

		return entree;
	}

	@Override
	public String getNom() {
		return "niveau";
	}

	@Override
	public void ajouter() {
		modifier(s.getNiveau() + 1);
	}

	@Override
	public void retirer() {
		modifier(s.getNiveau() - 1);
	}

}
