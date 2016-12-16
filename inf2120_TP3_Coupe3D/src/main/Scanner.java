package main;

import controle.PanneauControle;
import gestionObjets.Scene;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;


/**
 * Le Scanner est la fenetre qui contient la <Scene> et le <PanneauControle>.
 * @author Elias Touil <info@eliastouil.com>
 */
public class Scanner extends JFrame {

	private static final long serialVersionUID = 1L;
	
	Scene scene;
	PanneauControle controle; 
	JScrollPane defilable;
	
	public Scanner() {
		
		super("Scanner");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1000,1000));
		this.setSize(1000,1000);
		
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
		add(c , BorderLayout.WEST);
		setVisible(true);
		return c;
	}
	
	/**
	 * Instancie une Scene avec un fond grillé (Atron-t2A.obj). 
	 * @return s Scene
	 */
	private Scene initScene() {

		Scene s = new Scene("Atron-t2a.obj");
		add(s);
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
