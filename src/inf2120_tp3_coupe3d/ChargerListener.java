package inf2120_tp3_coupe3d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class ChargerListener implements ActionListener {

	Scene scene;
	PanneauControle controle;

	ChargerListener(Scene s, PanneauControle c) {
		super();
		scene = s;
		controle = c;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier obj", "obj");
		chooser.setFileFilter(filter);

		int returnVal = chooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			controle.setNomFichier(chooser.getSelectedFile().getName());
			scene.chargerFichierObj(chooser.getSelectedFile());
			
			
			scene.repaint();
			controle.repaint();
		}

	}
}
