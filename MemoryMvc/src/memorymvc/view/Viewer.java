/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memorymvc.view;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author lotta
 */
public class Viewer {
    
    ArrayList<String> pictures;
    final int numRowsCols = 4;
    MemoryButton[] button;
    
    public Viewer() {
        pictures = new ArrayList();
    }
    
    private void addImages() {
        String fileName;
        int numImages = numRowsCols * numRowsCols / 2;
        
        for (int i = 0; i < numImages; i++) {
            fileName = "img" + i + ".png";
            pictures.add(fileName);
        }
        for (int i = numImages; i < (numImages * 2); i++) {
            fileName = "img" + (i-numImages) + ".png";
            pictures.add(fileName);
        }
    }
    
    public void generateMemoryGUI() {
        
        JFrame myFrame;
        JPanel myPanelMemory;
        JPanel myPanelRest;
        
        addImages();
        myFrame = generateFrame();
        myPanelMemory = generatePanel(numRowsCols);
        myPanelRest = generatePanel(2);
        button = new MemoryButton[numRowsCols * numRowsCols];
        
        for (int i = 0; i < (numRowsCols * numRowsCols); i++) {
            button[i] = new MemoryButton(i);
            button[i].addListener();
            myPanelMemory.add(button[i]);
        }   
        myFrame.getContentPane().setLayout(new FlowLayout());
        myFrame.getContentPane().add(myPanelMemory);
        myFrame.getContentPane().add(myPanelRest);
        myFrame.setVisible(true);
    }   
      
    private JFrame generateFrame() {
        JFrame myFrame = new JFrame("Memory");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(400, 500);
        return myFrame;
    }  
    
    private JPanel generatePanel(int numRowsCols) {
        GridLayout gridLayout = new GridLayout(numRowsCols, numRowsCols);
        JPanel myPanel = new JPanel();
        myPanel.setLayout(gridLayout);
        return myPanel;
    }

    public int getNumRowsCols() {
        return numRowsCols;
    }
    
    public void setImages(ArrayList<Integer> randomList) {
        int imageNo;
        String fileName;
        
        for (int i : randomList) {
            imageNo = randomList.get(i);
            fileName = pictures.get(imageNo);
            button[i].setImage(fileName);   
        }
    }
    
}
