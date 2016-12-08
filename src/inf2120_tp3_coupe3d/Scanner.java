
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Scanner extends JFrame {
	private static final long serialVersionUID = 1L;

	public Scanner() {
		super( "Scanner" );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setLayout( new BorderLayout() );

		Scene s = new Scene( "Atron-t2a.obj" );
		add( s, BorderLayout.CENTER );		
		
		JPanel panneauNorth = new JPanel( new GridBagLayout() );
		GridBagConstraints c = new GridBagConstraints();
		
		
		
		JButton load = new JButton( "Charger" );
		JLabel nomFichier = new JLabel( "." );
		load.addActionListener( (e) -> {
		    JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter( "Fichier obj", "obj" );
		    chooser.setFileFilter( filter );
		    int returnVal = chooser.showOpenDialog( this );
		    if( returnVal == JFileChooser.APPROVE_OPTION ) {
		    	nomFichier.setText( chooser.getSelectedFile().getName() );
		    	s.chargerFichierObj( chooser.getSelectedFile() );
				
				s.repaint();
		    }
		} );
		c.gridx = 0;
		c.gridy = 0;
		panneauNorth.add( load, c );
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		panneauNorth.add( nomFichier, c );
		c.gridwidth = 1;
		
		
		add( panneauNorth, BorderLayout.NORTH );
		
		
		
		
		
		pack();
		setVisible( true );
		s.repaint();
	}
	
	public static void main( String [] argv ) {
		javax.swing.SwingUtilities.invokeLater( () -> new Scanner() );
	}
}
