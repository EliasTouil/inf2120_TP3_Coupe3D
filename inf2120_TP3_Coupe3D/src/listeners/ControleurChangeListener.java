package listeners;

import parametres.Parametre;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class ControleurChangeListener implements ChangeListener {

	Parametre parametre;

	public ControleurChangeListener(Parametre p) {
		parametre = p;
	}

	/**
	 * Appelle la fonction actionPerformed avec le bon parametre
	 * @param ae 
	 */
	@Override
	public void stateChanged(ChangeEvent ce) {
		Object source = ce.getSource();

		if (source instanceof JSlider) {

			stateChanged((JSlider) source);

		}
	}
	
	/**
	 * /**
	 * Ajoute la valeur du Slider au Paramètre. 
	 * @param t 
	 * param s 
	 */
	public void stateChanged(JSlider s) {
		parametre.modifier(s.getValue());
	}

}
