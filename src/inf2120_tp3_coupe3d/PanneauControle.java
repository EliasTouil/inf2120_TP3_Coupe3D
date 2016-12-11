package inf2120_tp3_coupe3d;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class PanneauControle extends JPanel {
	
	private JButton charger;
	private JLabel nomFichier;
	//private Controleur ctrlXY;
	private JPanel ctrlXY;
	
	PanneauControle(Scene s){
		super( new GridBagLayout() );
		this.nomFichier = new JLabel();
		
		charger = new JButton("Charger");
		charger.addActionListener(new ChargerListener(s,this));
		
		ctrlXY = new Controller("Rotation XY");
		
		add(nomFichier,styleNomFichier());
		add(charger,styleCharger());
	}
	
	
	private GridBagConstraints styleNomFichier(){
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.insets=new Insets(25,50,25,50);
		
		return c;
	}
	
	private GridBagConstraints styleCharger(){
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		c.insets=new Insets(25,50,25,50);
		
		return c;
	}
	
	public void setNomFichier(String nom){
		nomFichier.setText(nom);
		this.repaint();
	}
	
}
