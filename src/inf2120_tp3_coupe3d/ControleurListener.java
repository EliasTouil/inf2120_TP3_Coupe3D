
package inf2120_tp3_coupe3d;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public class ControleurListener implements ChangeListener {
    
    
    
  
    
    public void stateChanged(JSlider s){
        //Do something
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        // call the function that takes a slider as parameter
		System.out.println("state changed");
    }
    
}
