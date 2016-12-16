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
	public String getNom() {
		return "Rotation YZ";
	}
	
	@Override
	public void modifier(double i) {
		double valValide = valider(i);
		s.setRotationYZ(traduireValeur(valValide));
		mettreAJour(valValide);
		s.repaint();
	}
	
	@Override
	public void ajouter() {
		modifier(traduireValeurInverse(s.getRotationYZ()) + 1);
	}
	
	@Override
	public void retirer() {
		modifier(traduireValeurInverse(s.getRotationYZ()) - 1);
	}
}
