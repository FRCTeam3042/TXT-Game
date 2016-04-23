package RobotSim;

import RobotSim.commands.Drive;
import RobotSim.commands.Rotate;
import RobotSim.commands.BallLaunch;
import RobotSim.commands.Escape;
import RobotSim.commands.Intake;
import RobotSim.subsytems.SimDrive;
import static RobotSim.commands.Drive.COM.*;
import static RobotSim.commands.Rotate.COM.*;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class KeyboardOI {

    public KeyboardOI(SimDrive canvas) {

        //Get the input map and action map
        InputMap inputMap = canvas.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = canvas.getActionMap();
        
        
        KeyStroke escapePress =  KeyStroke.getKeyStroke("ESCAPE");
        inputMap.put(escapePress, "ESCAPE");
        actionMap.put("ESCAPE", new Escape());

        //forward
        KeyStroke wPress = KeyStroke.getKeyStroke("W");
        inputMap.put(wPress, "wPress");
        actionMap.put("wPress", new Drive(canvas, FORWARD));

        KeyStroke wRelease = KeyStroke.getKeyStroke("released W");
        inputMap.put(wRelease, "wRelease");
        actionMap.put("wRelease", new Drive(canvas, FORWARD_RELEASE));
        
        
        //backward
        /*
        KeyStroke sPress = KeyStroke.getKeyStroke("S");
        inputMap.put(sPress, "sPress");
        actionMap.put("sPress", new Drive(canvas, BACKWARD));
        
        KeyStroke sRelease = KeyStroke.getKeyStroke("released S");
        inputMap.put(sRelease, "sRelease");
        actionMap.put("sRelease", new Drive(canvas, BACKWARD_RELEASE));
        */
        
        //rotate left
        KeyStroke aPress = KeyStroke.getKeyStroke("A");
        inputMap.put(aPress, "aPress");
        actionMap.put("aPress", new Rotate(canvas, LEFT));
        
        KeyStroke aRelease = KeyStroke.getKeyStroke("released A");
        inputMap.put(aRelease, "aRelease");
        actionMap.put("aRelease", new Rotate(canvas, LEFT_RELEASE));
        
        
        //rotate right
        KeyStroke dPress = KeyStroke.getKeyStroke("D");
        inputMap.put(dPress, "dPress");
        actionMap.put("dPress", new Rotate(canvas, RIGHT));
        
        KeyStroke dRelease = KeyStroke.getKeyStroke("released D");
        inputMap.put(dRelease, "dRelease");
        actionMap.put("dRelease", new Rotate(canvas, RIGHT_RELEASE));
        
        
        //Release the ball with "Q"
        KeyStroke qPress = KeyStroke.getKeyStroke("Q");
        inputMap.put(qPress, "qPress");
        actionMap.put("qPress", new BallLaunch(canvas));
        
        
        //Intake the ball with "E"
        KeyStroke ePress = KeyStroke.getKeyStroke("E");
        inputMap.put(ePress, "ePress");
        actionMap.put("ePress", new Intake(canvas, true));
        
        KeyStroke eRelease = KeyStroke.getKeyStroke("released E");
        inputMap.put(eRelease, "eRelease");
        actionMap.put("eRelease", new Intake(canvas, false));

    }
}
