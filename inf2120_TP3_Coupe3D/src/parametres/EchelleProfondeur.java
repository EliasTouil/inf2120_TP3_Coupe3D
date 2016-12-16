package parametres;

import controle.Controlleur;
import gestionObjets.Scene;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class EchelleProfondeur extends EchelleImage {
	
	public EchelleProfondeur(Controlleur c, Scene s) {
		super( c , s );
	}
	
	@Override
	public String getNom(){
		return "Profondeur";
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
		return 1;
	}
	
	@Override
	public void ajouter() {
		modifier(s.getEchelleProfondeur() + 1);
	}
	
	@Override
	public void retirer() {
		modifier(s.getEchelleProfondeur() - 1);
	}
}
