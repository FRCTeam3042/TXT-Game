/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobotSim.commands;

import RobotSim.AnimMap;
import RobotSim.subsytems.SimDrive;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class BallLaunch extends AbstractAction {

    //The canvas drawing subsystem
    SimDrive canvas;

    /**
     * Constructor to link to the canvas subsystem
     *
     * @param canvas
     */
    public BallLaunch(SimDrive canvas) {
        this.canvas = canvas;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (canvas.ball.getCarrying()) {
            canvas.ball.setCarrying(false);
            double theta1 = canvas.robot.getTheta();
            double vx = AnimMap.BALL_SPEED * (Math.cos(Math.toRadians(theta1)));
            double vy = AnimMap.BALL_SPEED * (Math.sin(Math.toRadians(theta1)));
            canvas.ball.setVelocity(vx, vy);
        }
    }

}
