package controle;

import listeners.ChargerListener;
import gestionObjets.Scene;
import java.awt.Dimension;
import javax.swing.*;
import parametres.*;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class PanneauControle extends JPanel {

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
		style();
		initComponents(s);
		initListeners(s);
		ajouterComponents();
		this.repaint();
	}
	
	public void style(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(500,1000));
	}
	
	public void initComponents(Scene s){
		nomFichier = new JLabel();
		charger = new JButton("Charger");
	}
	
	public void initControlleurs(Scene s){	
		
		ctrlNiveau = new CtrlTypeB(Niveau.class , s);
		ctrlRotationXY = new CtrlTypeB( RotationXY.class , s);
		ctrlRotationXZ = new CtrlTypeB( RotationXZ.class , s);
		ctrlRotationYZ = new CtrlTypeB( RotationYZ.class , s);
		
		ctrlEchelleImage = new Controlleur( EchelleImage.class , s );
		ctrlEchelleProfondeur = new Controlleur( EchelleProfondeur.class , s );
		ctrlEchelleGrille = new Controlleur( EchelleGrille.class , s );
		
		add(ctrlNiveau);
		add(ctrlRotationXY);
		add(ctrlRotationXZ);
		add(ctrlRotationYZ);
		
		add(ctrlEchelleImage);
		add(ctrlEchelleProfondeur);
		add(ctrlEchelleGrille);
		
		this.repaint();
	}
	
	public void initListeners(Scene s){
		charger.addActionListener(new ChargerListener(s, this));
	}
	
	public void ajouterComponents(){
		add(charger);
		add(nomFichier);
	}

	public void setNomFichier(String nom) {
		nomFichier.setText(nom);
		this.repaint();
	}

}
