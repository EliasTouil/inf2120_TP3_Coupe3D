package controle;

import listeners.ChargerListener;
import gestionObjets.Scene;
import java.awt.Dimension;
import javax.swing.*;
import parametres.*;

/**
 *Un Panneau de controle permet de contenir les Components qui controlent la scène.
 * @author Elias Touil <info@eliastouil.com>
 */
public class PanneauControle extends JLayeredPane {

	private JButton charger;
	private JLabel nomFichier;

	private CtrlTypeB ctrlNiveau;
	private CtrlTypeB ctrlRotationXY;
	private CtrlTypeB ctrlRotationXZ;
	private CtrlTypeB ctrlRotationYZ;
	
	private Controlleur ctrlEchelleImage;
	private Controlleur ctrlEchelleProfondeur;
	private Controlleur ctrlEchelleGrille;

	public PanneauControle(Scene s) {
		super();
		initStyle();
		initComponents(s);
		initListeners(s);
		ajouterComponents();
		this.repaint();
	}
	
	/**
	 * initialise les style du PanneauControle.
	 */
	public void initStyle(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(500,0));
	}
	
	/**
	 * Intancie les Components nécessaires à la première interaction utilisateur.
	 * @param s 
	 */
	public void initComponents(Scene s){
		nomFichier = new JLabel();
		charger = new JButton("Charger");
	}
	
	/**
	 * Instancie Les components et les ajoute au panneau.
	 * @param s 
	 */
	public void initControlleurs(Scene s){	
		
		ctrlNiveau = new CtrlTypeB(Niveau.class , s);
		ctrlRotationXY = new CtrlTypeB( RotationXY.class , s);
		ctrlRotationXZ = new CtrlTypeB( RotationXZ.class , s);
		ctrlRotationYZ = new CtrlTypeB( RotationYZ.class , s);
		
		ctrlEchelleImage = new Controlleur( EchelleImage.class , s );
		ctrlEchelleProfondeur = new Controlleur( EchelleProfondeur.class , s );
		ctrlEchelleGrille = new Controlleur( EchelleGrille.class , s );
		
		//SRP
		add(ctrlNiveau);
		add(ctrlRotationXY);
		add(ctrlRotationXZ);
		add(ctrlRotationYZ);
		
		add(ctrlEchelleImage);
		add(ctrlEchelleProfondeur);
		add(ctrlEchelleGrille);
		
		this.repaint();
	}
	
	/**
	 * ajoute les listeners aux controlleurs.
	 * @param s 
	 */
	public void initListeners(Scene s){
		charger.addActionListener(new ChargerListener(s, this));
	}
	
	/**
	 * Ajoute les components nécessaire à la première interaction utilisateur au PanneauControle
	 */
	public void ajouterComponents(){
		add(charger);
		add(nomFichier);
	}
	
	/**
	 * Change le nom du fichier et repaint la Scene.
	 * @param nom 
	 */
	public void setNomFichier(String nom) {
		nomFichier.setText(nom);
		this.repaint();
	}

}
