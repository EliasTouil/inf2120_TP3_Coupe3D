package parametres;

import controle.Controlleur;
import gestionObjets.Scene;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class EchelleGrille extends EchelleImage{
	public EchelleGrille(Controlleur c, Scene s) {
		super( c , s );
	}
	
	@Override
	public String getNom(){
		return "Échelle Grille";
	}
	
	@Override
	public void modifier(double i) {
		double valValide = valider(i);
		s.setEchelleProfondeur((int) valValide);
		mettreAJour(valValide);
		s.repaint();
	}
	
	@Override
	public double getValeurDefaut() {
		return 0.01;
	}
}
