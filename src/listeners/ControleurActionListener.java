package listeners;

import parametres.Parametre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author eliastouil
 */
public class ControleurActionListener implements ActionListener {
	
	Parametre parametre;
	
	public ControleurActionListener(Parametre p){
		parametre = p ;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		Object source = ae.getSource();
		
		if (source instanceof JButton) {
			
			actionPerformed((JButton) source);

		} else if (source instanceof JTextField) {
			
			actionPerformed((JTextField) source);

		}
		
	}
	
	// Improve
	private void actionPerformed(JButton b) {
		
		if (b.getText().equals("+")) {
			parametre.ajouter();
		} else if (b.getText().equals("-")) {
			parametre.retirer();
			
		}
	}

	private void actionPerformed(JTextField t) {
		double valeur = Double.parseDouble(t.getText());
		parametre.modifier(valeur);
	}

}
