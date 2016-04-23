
package RobotSim;

import java.awt.Color;

public class AnimMap {
    
    //The delay between animation frames
    public static final int FRAME_DELAY = 10;
    
    //Dimensions of the animation panel
    public static final int XDim = 602;
    public static final int YDim = 467;

    //Initial conditionas and properties of the ball
    public static final int BALL_RADIUS = 40;
    public static final int ROBOT_HEIGHT = 40;
    public static final int X0 = 525;
    public static final int Y0 = 230;    
    
    public static final Color BALL_COLOR_START = Color.RED;
    public static final Color BALL_COLOR_1 = Color.BLUE;
    public static final Color BALL_COLOR_2 = Color.YELLOW;
    public static final Color BALL_COLOR_3 = Color.GREEN;

    public static final int ROBOT_MOVE_SPEED = 1;
    public static final int ROBOT_ROTATE_SPEED = 4;
    public static final int BALL_SPEED = 5;
    public static final double BALL_DECEL = 0.995;     //The deceleration of the ball
}
