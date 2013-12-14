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
 *
 * @author lotta
 */
public class VBlockButton extends JButton {
    ImageIcon image;
   
    memory.controler.CBlockButton buttonControler; 
    
    public VBlockButton(int i) {
        this.setPreferredSize(new Dimension(100, 100));
    }
    
    private void setImage(String fileName) {
        image = new ImageIcon(fileName);
    }
    
    public void openButton(String file) {
        setImage(file);
        setIcon(image);
    }
    
    public void closeButton(String file) {
        if (file.contentEquals("")) {
            setIcon(null);
        }
        else {
            setImage(file);
            setIcon(image);
        }
    }
    
    public void setRedBorderColor() {
        this.setBackground(Color.red);
    }
    
    public void setGreenBorderColor() {
        this.setBackground(Color.green);
    }
    
    public void setNoBorderColor() {
        this.setBackground(Color.LIGHT_GRAY);
    }

}