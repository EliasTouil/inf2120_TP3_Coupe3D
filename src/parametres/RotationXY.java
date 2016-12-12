package parametres;

import controle.Controlleur;
import gestionObjets.Scene;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class RotationXY extends Parametre{
	
	public RotationXY(Controlleur c, Scene s) {
		super(c, s);
	}

	@Override
	public double traduireValeur(double i) {
		return Math.PI * i / 180.00;
	}

	@Override
	public void modifier(double i) {
		double valValide = valider(i);
		s.setRotationXY( traduireValeur(valValide));
		mettreAJour(valValide);
		s.repaint();
	}

	

	@Override
	public int getMin() {
		return -180;
	}

	@Override
	public int getMax() {
		return 180;
	}

	@Override
	public double getValeurDefaut() {
		return 0;
	}

	@Override
	public double valider(double entree) {
		
		if (entree > 180 ){
			entree = 180;
		} else if ( entree < -180 ){
			entree = -180 ; 
		}
		
		return entree;
	}

	@Override
	public String getNom() {
		return "Rotation XY";
	}

}
