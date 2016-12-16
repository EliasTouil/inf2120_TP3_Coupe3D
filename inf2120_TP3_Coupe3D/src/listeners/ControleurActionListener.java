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
	
	/**
	 * Appelle la fonction actionPerformed avec le bon parametre
	 * @param ae 
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		Object source = ae.getSource();
		
		if (source instanceof JButton) {
			
			actionPerformed((JButton) source);

		} else if (source instanceof JTextField) {
			
			actionPerformed((JTextField) source);

		}
		
	}
	
	/**
	 * Ajoute 1 ou retire 1 de la valeur du Parametre selon le bouton appuyé.
	 * @param b 
	 */
	private void actionPerformed(JButton b) {
		
		if (b.getText().equals("+")) {
			parametre.ajouter();
		} else if (b.getText().equals("-")) {
			parametre.retirer();
			
		}
	}
	
	/**
	 * Ajoute la valeur passée en paramètre au Paramètre. 
	 * @param t 
	 */
	private void actionPerformed(JTextField t) {
		try {
			
			double valeur = Double.parseDouble(t.getText());
			parametre.modifier(valeur);
			
		} catch (Exception e) {
			
			parametre.modifier(parametre.getValeurDefaut());
			System.err.println("valeur entrée n'est pas un nombre");
			
		}
	}

}
