package controle;

import gestionObjets.Scene;
import listeners.ControleurActionListener;
import listeners.ControleurChangeListener;
import parametres.Parametre;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class Controller extends JPanel {
	
	protected Parametre parametre;
	
	protected JLabel nom;
	protected JButton retirer = new JButton("-");
	private JSlider poignee;
	protected JButton ajouter = new JButton("+");
	protected JTextField valeur;
	

	Controller(Class c , Scene s) {

		super();
		
		obtenirParametre( c , s );
		
		initComponents();
		
		ajouterListeners();
		
		setVisible(true);
		
		ajouterComponents();
		
	}
	
	private void obtenirParametre( Class c , Scene  s ){
		
		try {
			parametre = (Parametre) c.getDeclaredConstructor(Scene.class).newInstance(s);
		} catch (Exception ex) {
			System.err.println("impossible d'instancier un parametre  " + nom);
			System.exit(1);
		}
		
	}

	public void initComponents(){
		
		nom = new JLabel( parametre.getNom() );
		poignee = new JSlider( parametre.getMin(), parametre.getMax());
		valeur = new JTextField(3);
		valeur.setText( "" + parametre.getValeurDefaut());  // improve
		
	}
	
	public void ajouterComponents(){
		add(nom);
		add(retirer);
		add(poignee);	
		add(ajouter);
		add(valeur);
	}
	
	@Override
	public void setVisible(boolean flag) {
		nom.setVisible(flag);
		ajouter.setVisible(flag);
		poignee.setVisible(flag);
		retirer.setVisible(flag);
		valeur.setVisible(flag);

	}
	
	public void ajouterListeners(){
	
		ControleurActionListener aListener = new ControleurActionListener(parametre);
		ControleurChangeListener cListener = new ControleurChangeListener(parametre);
			
		retirer.addActionListener(aListener);
		poignee.addChangeListener(cListener);
		ajouter.addActionListener(aListener);
		valeur.addActionListener(aListener);
	
	}

	public JSlider getPoignee() {
		return poignee;
	}

}
