package inf2120_tp3_coupe3d;

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
		
		
		scene.setEchelleGrille(0.01);
		scene.setEchelleImage(10);
		scene.setNiveau(50);
		scene.setRotationXZ(2.5);
		
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
		s.repaint();
		
		return s;
	}
	
	Component getScene() {
		return scene;
	}
	Component getControleur(){
		return controle;
	}

}
