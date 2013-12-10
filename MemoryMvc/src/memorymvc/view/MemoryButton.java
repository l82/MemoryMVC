/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memorymvc.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author lotta
 */
public class MemoryButton extends JButton {
    private final int row;
    ImageIcon image;
    Boolean closed;
    
    public MemoryButton(int i) {
        row = i;
        closed = true;
    }
    
    public void addListener() {
    
        super.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (closed == true) {
                setIcon(image);
                closed = false;
            }
            else {
                setIcon(null);
                closed = true;
            }
            System.out.println("i: " + row);
        }
        });
    }    
    
    public void setImage(String fileName) {
        image = new ImageIcon(fileName);
        System.out.println("Filename: " + fileName);
    }
}
