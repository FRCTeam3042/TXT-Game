/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobotSim.subsytems;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author egunn_000
 */

//This class is meant to display points on the screen, showing how many times you got the ball
//into the goal.
public class ScoreTracker extends javax.swing.JPanel  {
    int score; //This is a number that starts at 0. We add to it to make it go up.
    String scoreLabel = "Score: ";//This is the word we use to label the score. 
    
    //This is what we use when we make a new score tracker, for instance ScoreTracker score = new ScoreTracker();
    public ScoreTracker(){
        this.score = 0;//When we create a new scoretracker, we set the starting score number at 0.
    }
    
    //This is what we use when we need to add a point to the score.
    public void addToScore(){
        this.score = this.score+1; //This adds 1 point to the score number.
    }
    
    //This is what we use to show the score on the playing field.
    public void draw(Graphics g2d) {
        g2d.setColor(Color.blue);
        g2d.drawString(scoreLabel+score, 0, 0);
    }
    
}
