/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.ImageIcon;

/**
 * Class for handling the view object of a button
 * @author lotta
 */
public class VBlockButton extends JButton {
    ImageIcon image;
   
    memory.controler.CBlockButton buttonControler; 
    
    /**
     * Constructor for button
     * @param i Number in VBlockButtonList array
     */
    public VBlockButton(int i) {
        this.setPreferredSize(new Dimension(100, 100));
    }
    
    /**
     * Sets an image icon
     * @param fileName name of file to set
     */
    private void setImage(String fileName) {
        image = new ImageIcon(fileName);
    }
    
    /**
     * Opens a button by setting the mage icon
     * @param file name of file for image 
     */
    public void openButton(String file) {
        setImage(file);
        setIcon(image);
    }
    
    /**
     * Closes a button by setting a default image
     * @param file Image file name to set 
     */
    public void closeButton(String file) {
        if (file.contentEquals("")) {
            setIcon(null);
        }
        else {
            setImage(file);
            setIcon(image);
        }
    }
    
    /**
     * Sets red background color on image
     */
    public void setRedBackgroundColor() {
        this.setBackground(Color.red);
    }
    
    /**
     * Sets green background color on image
     */
    public void setGreenBackgroundColor() {
        this.setBackground(Color.green);
    }
    
    /**
     * Sets grey background color on image
     */
    public void setNoBackgroundColor() {
        this.setBackground(Color.LIGHT_GRAY);
    }

}