package RobotSim.commands;

import RobotSim.AnimMap;
import static RobotSim.commands.Drive.COM.*;
import RobotSim.subsytems.SimDrive;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class Drive extends AbstractAction {

    public static enum COM { FORWARD, FORWARD_RELEASE, BACKWARD, BACKWARD_RELEASE; }
    COM com;
    
    static Boolean forwardPressed = false;
    static Boolean reversePressed = false;
    
    //The drawing canvas JPanel
    SimDrive canvas;
        
    /**
     * Constructor to get the drawing canvas
     * @param canvas 
     * @param com 
     */
    public Drive(SimDrive canvas, COM com) {
        this.canvas = canvas;
        this.com = com;
    }
    
    private void resolveState() {
        if (com == FORWARD) forwardPressed = true;
        if (com == FORWARD_RELEASE) forwardPressed = false;
        if (com == BACKWARD) reversePressed = true;
        if (com == BACKWARD_RELEASE) reversePressed = false;    }
    
    private int getSpeed() {
        resolveState();

        int speed = 0;
        
        if (forwardPressed)  speed += AnimMap.ROBOT_MOVE_SPEED;
        if (reversePressed) speed -= AnimMap.ROBOT_MOVE_SPEED;
        
        return speed;
    }
    
    /**
     * Define the action to take for the event
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {        
        canvas.robot.setSpeed(getSpeed());
    }
}
