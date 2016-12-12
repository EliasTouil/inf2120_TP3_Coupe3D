package controle;

import parametres.Niveau;
import parametres.Parametre;
import listeners.ChargerListener;
import gestionObjets.Scene;
import java.awt.Dimension;
import javax.swing.BoxLayout;
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

	private Controller ctrlNiveau;
	private Parametre rotationXY;
	private Controller ctrlRotationXY;
	private Parametre rotationXZ;
	private Controller ctrlRotationXZ;
	private Parametre rotationYZ;
	private Controller ctrlRotationYZ;

	public PanneauControle(Scene s) {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(500,1000));
		this.setSize(new Dimension(500,1000));
		this.nomFichier = new JLabel();

		charger = new JButton("Charger");
		charger.addActionListener(new ChargerListener(s, this));
		add(charger);
		add(nomFichier);
	}

	public void initControlleurs(Scene s) {
		ctrlNiveau = new Controller(Niveau.class , s);
		add(ctrlNiveau);
	}


	public void setNomFichier(String nom) {
		nomFichier.setText(nom);
		this.repaint();
	}

}
