package RobotSim.subsytems;
import RobotSim.AnimMap;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Robot extends Rectangle.Double {

    //Initial Properties of the ball
    int robotSize = AnimMap.ROBOT_HEIGHT;
    double theta = 180.0;
    double vel = 0;
    double vtheta = 0;

    Image robotImage;
    
    SimDrive canvas;
    
    ScoreTracker scoreTracker;
    /**
     * Constructor to load the robot image file
     */
    public Robot() {
        
        scoreTracker = new ScoreTracker();
        
        x = AnimMap.X0-robotSize;
        y = AnimMap.Y0-robotSize;
        height = 2*robotSize;
        width = 2*robotSize;
        
        try {
            File robotFile = new File("robotsprite.png");
            robotImage = ImageIO.read(robotFile);
        } catch (IOException e) {
            System.out.println("Can't find file");
        }
    }

    /**
     * Updates the robot's position and speed between animation frames
     */
    public void update() {
        theta += vtheta;
        x += vel*Math.cos(Math.toRadians(theta));
        y += vel * Math.sin(Math.toRadians(theta));
        
        if ((x + 2*robotSize > AnimMap.XDim)) {
            x = AnimMap.XDim - 2*robotSize;
        }
        if (x < 0) {
            x = 0;
        }
        if (y + 2*robotSize > AnimMap.YDim) {
            y = AnimMap.YDim - 2*robotSize;
        }
        if (y < 0) {
            y = 0;
        }
        
    }

    /**
     * Draws the ball
     *
     * @param g2d
     */
    public void draw(Graphics2D g2d) {
        //determine angle in radians
        //include offset to make sure the robot image faces the correct way
        double angle = Math.toRadians(theta+90);
        
        g2d.rotate(angle, x+robotSize, y+robotSize);
        g2d.drawImage(robotImage, (int) x, (int) y, 2*robotSize, 2*robotSize, null);
        g2d.rotate(-angle, x+robotSize, y+robotSize);
        
        g2d.translate(x, y-20);
        scoreTracker.draw(g2d);
        g2d.translate(-x, -(y-20));
    }

    public void setSpeed(int speed) {
        vel = speed;  
    }

    public void setSpeedTheta(int speed) {
        vtheta = speed;
    }

    public double getTheta() {
        return theta;
    }

}
