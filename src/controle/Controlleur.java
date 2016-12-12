package controle;

import gestionObjets.Scene;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import listeners.ControleurActionListener;
import listeners.ControleurChangeListener;
import parametres.Parametre;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class Controlleur extends JPanel {
	protected Parametre parametre;
	protected JLabel nom;
	protected JTextField valeur;
	
	ControleurActionListener actionListener;
	ControleurChangeListener changeListener;
	
	Controlleur(Class c , Scene s) {

		super();
		
		obtenirParametre( c , s );
		
		initComponents();
		
		actionListener = new ControleurActionListener(parametre);
		
		changeListener = new ControleurChangeListener(parametre);
		
		ajouterListeners();
		
		setVisible(true);
		
		ajouterComponents();
		
	}
	
	void obtenirParametre( Class c , Scene  s ){
		
		try {
			parametre = (Parametre) c.getDeclaredConstructor( Controlleur.class , Scene.class ).newInstance(this , s);
		} catch (Exception ex) {
			System.err.println("impossible d'instancier un parametre  " + nom);
			ex.printStackTrace();
			System.exit(1);
		}
		
	}
	
	 void initComponents(){
		
		nom = new JLabel( parametre.getNom() );
		valeur = new JTextField(3);
		valeur.setText( Integer.toString( parametre.getValeurDefaut() ) );
		
	}
	 
	 public void ajouterComponents(){
		add(nom);
		add(valeur);
	}
	
	public void ajouterListeners(){
	
		ControleurActionListener aListener = new ControleurActionListener(parametre);
		valeur.addActionListener(aListener);
	
	}
	public void mettreAJour(double i){
	}
}
