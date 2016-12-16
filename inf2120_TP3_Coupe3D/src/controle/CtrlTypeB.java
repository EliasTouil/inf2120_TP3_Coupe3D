package controle;

import gestionObjets.Scene;
import javax.swing.JButton;
import javax.swing.JSlider;

/**
 *Un Controlleur avec un Jslider et deux boutons.
 * Le Jslider représente la valeur et les bouton permettent d'ajouter ou de retirer à la valeur. 
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
	
	/**
	 * permet d'ajouter les Component supplémentaires.
	 */
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
