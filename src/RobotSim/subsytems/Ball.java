package RobotSim.subsytems;

import RobotSim.AnimMap;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball extends Ellipse2D.Double {

    //Initial Properties of the ball
    int radius = AnimMap.BALL_RADIUS;
    double vx = 0;
    double vy = 0;
    boolean carrying = true;
    boolean scored = false;
    

    public Ball() {
        x = AnimMap.X0;
        y = AnimMap.Y0;
        height = 2 * radius;
        width = 2 * radius;
    }

    /**
     * Updates the balls position and speed between animation frames
     *
     * @param a
     * @param b
     */
    public void update(double a, double b) {
        if (carrying) {
            x = a;
            y = b;
        } else if (scored) {
            x = 0;
            y = 0;
        } else {
            vx*=AnimMap.BALL_DECEL;//Slow the ball down
            vy*=AnimMap.BALL_DECEL;//Slow the ball down
            x += vx;
            y += vy;
        }

        // Bounce the ball off the walls
        if ((x + 2 * radius > AnimMap.XDim) || (x < 0)) {
            vx = -vx;
        }
        if ((y + 2 * radius > AnimMap.YDim) || (y < 0)) {
            vy = -vy;
        }
    }

    /**
     * Draws the ball
     *
     * @param g2d
     */
    public void draw(Graphics2D g2d) {
        if (scored == false) {
            g2d.setColor(AnimMap.BALL_COLOR_START);
        }
        if (SimDrive.magic == 1 && scored == true) {
            g2d.setColor(AnimMap.BALL_COLOR_3);
        }
        if (SimDrive.magic == 2 && scored == true) {
            g2d.setColor(AnimMap.BALL_COLOR_1);
        }
        if (SimDrive.magic == 3 && scored == true) {
            g2d.setColor(AnimMap.BALL_COLOR_2);
        }
        g2d.fill(this);
    }

    public void setCarrying(boolean carry) {
        carrying = carry;
        scored = false;
    }

    public boolean getCarrying() {
        return carrying;
    }

    public void setVelocity(double ivx, double ivy) {
        vx = ivx;
        vy = ivy;
    }

    public void scored() {
        scored = true;
    }

}
