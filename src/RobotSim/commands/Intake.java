
package RobotSim.commands;

import RobotSim.subsytems.SimDrive;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;


public class Intake extends AbstractAction{

    //The canvas drawing subsystem
    SimDrive canvas;
    boolean status;
    
    /**
     * Constructor to link to the canvas subsystem
     * @param canvas 
     * @param inputStatus 
     */
    public Intake (SimDrive canvas, boolean inputStatus) {
        this.canvas = canvas;
        status = inputStatus;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        canvas.intake(status);     
    }
      
}