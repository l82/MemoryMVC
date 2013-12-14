/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.view;

import java.awt.Dimension;
import javax.swing.*;
import javax.swing.ImageIcon;

/**
 *
 * @author lotta
 */
public class VBlockButton extends JButton {
    private final int blockNo;
    ImageIcon image;
   
    memory.controler.CBlockButton buttonControler; 
    
    public VBlockButton(View viewer, int i) {
        blockNo = i;
        this.setPreferredSize(new Dimension(100, 100));
    }
    
    private void setImage(String fileName) {
        image = new ImageIcon(fileName);
    }
    
    public void openButton(String file) {
        setImage(file);
        setIcon(image);
    }
    
    public void closeButton() {
        setIcon(null);
    }

}