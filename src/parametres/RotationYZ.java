package parametres;

import controle.Controlleur;
import gestionObjets.Scene;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class RotationYZ extends RotationXY{
	
	public RotationYZ(Controlleur c, Scene s) {
		super(c, s);
	}
	
	@Override
	public void modifier(double i) {
		double valValide = valider(i);
		s.setRotationYZ(traduireValeur(valValide));
		mettreAJour(valValide);
		s.repaint();
	}
}
