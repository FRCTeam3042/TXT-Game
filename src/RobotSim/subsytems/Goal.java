package RobotSim.subsytems;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Goal extends Rectangle {
    
    Image goalImage;
    
    public Goal (){
        super(2, 2,85, 85);
        try {
            File robotFile = new File("Soccer.jpg");
            goalImage = ImageIO.read(robotFile);
        } catch (IOException e) {
            System.out.println("Can't find file");
        }
        
    }
    
    public void draw(Graphics2D g2d) {
        g2d.drawImage(goalImage, 1, 1, 85, 85, null);
    }

}
