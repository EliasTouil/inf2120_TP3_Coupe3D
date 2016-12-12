package main;

import controle.PanneauControle;
import gestionObjets.Scene;
import java.awt.BorderLayout;
import javax.swing.JFrame;


/**
 * Le Scanner est la fenetre qui contient la <Scene> et le <PanneauControle>.
 * @author Elias Touil <info@eliastouil.com>
 */
public class Scanner extends JFrame {

	private static final long serialVersionUID = 1L;
	
	Scene scene;
	PanneauControle controle; 
	
	public Scanner() {
		
		super("Scanner");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		scene = initScene();
		controle = initControle(scene);
		
		
		this.repaint();
	} 
	
	/**
	 * Instancie un nouveau PanneauControle lié à la scène entrée en paramètre. 
	 * 
	 * @param s
	 * @return c <PanneauControle>.
	 */
	private PanneauControle initControle(Scene s){
		PanneauControle c = new PanneauControle(s);
		add(c , BorderLayout.EAST);
		setVisible(true);
		return c;
	}
	
	/**
	 * Instancie une Scene avec un fond grillé (Atron-t2A.obj). 
	 * @return s Scene
	 */
	private Scene initScene() {

		Scene s = new Scene("Atron-t2a.obj");
		add(s, BorderLayout.WEST);
		pack();
		setVisible(true);
		s = ajouterOptionsDefaut(s);
		
		return s;
	}
	
	/**
	 * Retourne une scène avec ses paramètre mis à la valeur par défaut
	 * @param s
	 * @return 
	 */
	private Scene ajouterOptionsDefaut(Scene s){
		
		// Utiliser getValeurDefaut des classes paramètres 
		s.setEchelleGrille(0.01);
		s.setEchelleImage(4);
		s.setEchelleProfondeur(1);
		s.setNiveau(50);
		s.setRotationXZ(0);
		s.setRotationXY(0);
		s.setRotationYZ(0);
		
		s.repaint();
		
		return s;
	}

}
