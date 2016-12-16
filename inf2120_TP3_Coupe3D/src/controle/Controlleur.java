package controle;

import gestionObjets.Scene;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import listeners.ControleurActionListener;
import listeners.ControleurChangeListener;
import parametres.Parametre;

/**
 *Un Controlleur a des Component qui décrivent et affectent un Parametre.
 * Les Component de base sont un JTextField représentant la valeur et un JLabel nom.
 * Les sous-classes du Controlleurs permettent d'ajouter des components supplémentaires.
 * @author Elias Touil <info@eliastouil.com>
 */
public class Controlleur extends JPanel {

	protected Parametre parametre;
	protected JLabel nom;
	protected JTextField valeur;

	ControleurActionListener actionListener;
	ControleurChangeListener changeListener;

	Controlleur(Class c, Scene s) {

		super();

		obtenirParametre(c, s);

		initComponents();

		actionListener = new ControleurActionListener(parametre);

		changeListener = new ControleurChangeListener(parametre);

		initListeners();

		initStyle();

		setVisible(true);

		ajouterComponents();

	}

	void initStyle() {
		// doit rester un méthode concrète
	}
	
	/**
	 * Permet d'instancier un parametre à partir de sa classe.
	 * @param c
	 * @param s 
	 */
	void obtenirParametre(Class c, Scene s) {

		try {
			parametre = (Parametre) c.getDeclaredConstructor(Controlleur.class, Scene.class).newInstance(this, s);
		} catch (Exception ex) {
			System.err.println("impossible d'instancier un parametre  " + nom);
			System.exit(1);
		}

	}
	
	/**
	 * Instancie les Components du Controlleur.
	 */
	void initComponents() {

		nom = new JLabel(parametre.getNom());
		valeur = new JTextField(3);
		valeur.setText(Double.toString(parametre.getValeurDefaut()));

	}
	
	/**
	 * Ajoute les components au Controlleur.
	 */
	public void ajouterComponents() {
		add(nom);
		add(valeur);
	}
	
	/**
	 * Ajoute les listeners au Components.
	 */
	public void initListeners() {

		ControleurActionListener aListener = new ControleurActionListener(parametre);
		valeur.addActionListener(aListener);

	}
	
	/**
	 * Met à jour la valeur des Component du Controlleur. 
	 * @param i 
	 */
	public void mettreAJour(double i) {
		valeur.setText(Double.toString(i)); 
	}
}
