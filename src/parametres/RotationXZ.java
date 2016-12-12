package parametres;

import controle.Controlleur;
import gestionObjets.Scene;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class RotationXZ extends RotationXY{
	
	public RotationXZ(Controlleur c, Scene s) {
		super(c, s);
	}
	
	@Override
	public void modifier(double i) {
		double valValide = valider(i);
		s.setRotationXZ(traduireValeur(valValide));
		mettreAJour(valValide);
		s.repaint();
	}
	
}
