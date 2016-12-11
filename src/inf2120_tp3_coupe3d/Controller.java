package inf2120_tp3_coupe3d;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class Controller extends JPanel{
	    protected JLabel nom; 
    protected JButton ajouter = new JButton();
    private JSlider poignee = new JSlider(0,100);
    protected JTextField valeur = new JTextField();
    protected JButton retirer = new JButton();
    
     //private ControleurListener listener = new ControleurListener();
    
    Controller(String nomEntree){
        
        super();
		
        nom = new JLabel(nomEntree);
        this.setVisible(true);
        add(nom);
        add(ajouter);
        
        add(poignee); 
        //poignee.addChangeListener(listener);
		
        add(retirer);
        add(valeur);
        
    }
    
    @Override
    public void setVisible(boolean flag){
        nom.setVisible(flag);
        ajouter.setVisible(flag);
        poignee.setVisible(flag);
        retirer.setVisible(flag);
        valeur.setVisible(flag);
		
    }
    
    public JSlider getPoignee(){
        return poignee;
    }
    
}
