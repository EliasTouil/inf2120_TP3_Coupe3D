package main;

import controle.PanneauControle;
import gestionObjets.Scene;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;

public class Scanner extends JFrame {

	private static final long serialVersionUID = 1L;
	
	Scene scene;
	PanneauControle controle; 
	
	public Scanner() {
		
		super("Scanner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(600, 600);

		scene = initScene();
		controle = initControle(scene);
		
		
		this.repaint();
	} 
	
	private PanneauControle initControle(Scene s){
		PanneauControle c = new PanneauControle(s);
		add(c , BorderLayout.EAST);
		setVisible(true);
		return c;
	}
	
	

	private Scene initScene() {

		Scene s = new Scene("Atron-t2a.obj");
		add(s, BorderLayout.WEST);
		pack();
		setVisible(true);
		s = ajouterOptionsDefaut(s);
		
		return s;
	}
	
	private Scene ajouterOptionsDefaut(Scene s){
		// Shoulde be deleted when all min and max for controllers are setup
		s.setEchelleGrille(0.01);
		s.setEchelleImage(5);
		s.setNiveau(50);
		s.setRotationXZ(0);
		
		return s;
	}
	
	public Component getScene() {
		return scene;
	}
	Component getControleur(){
		return controle;
	}

}
