package RobotSim;

import RobotSim.AnimMap;
import RobotSim.subsytems.SimDrive;

public class AnimThread extends Thread {

    SimDrive canvas;

    /**
     * Constructor to tell the thread where to draw the animation.
     *
     * @param canvas
     */
  public  AnimThread(SimDrive canvas) {
        this.canvas = canvas;
    }

    /**
     * Override the run method for the thread to run the animation
     */
    @Override
    public void run() {
        while (!interrupted()) {

            // Tell the canvas to paint the next step in the animation
            canvas.animFrame();

            try {
                //Wait some appropriate amount of time between animation frames.
                sleep(AnimMap.FRAME_DELAY);
            } catch (InterruptedException ex) {
                //Stop the animation if it receives an interruption signal.
                break;
            }
        }
    }

}
