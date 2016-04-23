/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RobotSim.commands;

import RobotSim.AnimMap;
import RobotSim.subsytems.SimDrive;
import static RobotSim.commands.Rotate.COM.*;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class Rotate extends AbstractAction{

    public static enum COM { LEFT, LEFT_RELEASE, RIGHT, RIGHT_RELEASE; }
    COM com;
    
    static Boolean leftPressed = false;
    static Boolean rightPressed = false;
    
    //The canvas drawing subsystem
    SimDrive canvas;
    
    private void resolveState() {
        if (com == LEFT) leftPressed = true;
        if (com == LEFT_RELEASE) leftPressed = false;
        if (com == RIGHT) rightPressed = true;
        if (com == RIGHT_RELEASE) rightPressed = false;    }
    
    private int getSpeed() {
        resolveState();

        int speed = 0;
        if (leftPressed)  speed -= AnimMap.ROBOT_ROTATE_SPEED;
        if (rightPressed) speed += AnimMap.ROBOT_ROTATE_SPEED;
        
        return speed;
    }
    

    
    /**
     * Constructor to link to the canvas subsystem
     * @param canvas 
     * @param com 
     */
    public Rotate(SimDrive canvas, COM com) {
        this.canvas = canvas;
        this.com = com;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        canvas.robot.setSpeedTheta(getSpeed());
    }
      
}
