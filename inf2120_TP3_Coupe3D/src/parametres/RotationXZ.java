package parametres;

import controle.Controlleur;
import gestionObjets.Scene;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class RotationXZ extends RotationXY {

	public RotationXZ(Controlleur c, Scene s) {
		super(c, s);
	}

	@Override
	public String getNom() {
		return "Rotation XZ";
	}

	@Override
	public void modifier(double i) {
		double valValide = valider(i);
		s.setRotationXZ(traduireValeur(valValide));
		mettreAJour(valValide);
		s.repaint();
	}

	@Override
	public void ajouter() {
		modifier(traduireValeurInverse(s.getRotationXZ()) + 1);
	}

	@Override
	public void retirer() {
		modifier(traduireValeurInverse(s.getRotationXZ()) - 1);
	}
}
