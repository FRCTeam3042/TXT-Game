/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobotSim.commands;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class Escape extends AbstractAction {

    public Escape() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
