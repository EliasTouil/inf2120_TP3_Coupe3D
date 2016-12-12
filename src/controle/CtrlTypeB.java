package controle;

import gestionObjets.Scene;
import listeners.ControleurActionListener;
import listeners.ControleurChangeListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class CtrlTypeB extends Controlleur{
	
	protected JButton retirer;
	private JSlider poignee;
	protected JButton ajouter;
	

	CtrlTypeB(Class c , Scene s) {

		super( c , s);
		
		addonComponents();
		
	}
	
	
	 void addonComponents(){
		 
		retirer = new JButton("-");
		poignee = new JSlider( parametre.getMin(), parametre.getMax());
		ajouter = new JButton("+");
		
		add(retirer);
		add(poignee);	
		add(ajouter);
		
		
			
		retirer.addActionListener(actionListener);
		poignee.addChangeListener(changeListener);
		ajouter.addActionListener(actionListener);
	}
	
	@Override
	public void mettreAJour(double i){
		poignee.setValue((int)i);
		valeur.setText(Double.toString(i)); 
	}

}
