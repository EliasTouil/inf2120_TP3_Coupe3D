package parametres;

import controle.Controlleur;
import gestionObjets.Scene;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class EchelleImage extends Parametre{
	
	public EchelleImage(Controlleur c, Scene s) {
		super( c , s );
	}
	
	@Override
	public String getNom() {
		return "Echelle Image";
	}

	@Override
	public int getMin() {
		return 0;
	}

	@Override
	public int getMax() {
		return 100;
	}

	@Override
	public double getValeurDefaut() {
		return 4;
	}

	@Override
	public double traduireValeur(double i) {
		return i;
	}

	@Override
	public double valider(double i) {
		
		if ( i < 0 ){
			i = 0 ;
		}
		
		return i ;
	}

	@Override
	public void modifier(double i) {
		double valValide = valider(i);
		s.setEchelleImage((int) valValide);
		mettreAJour(valValide);
		s.repaint();
	}
	
	@Override
	public void ajouter() {
		System.out.println(s.getNiveau());
		modifier(s.getEchelleImage()+ 1);
	}
	
	@Override
	public void retirer() {
		modifier(s.getEchelleImage() - 1);
	}
	
}
