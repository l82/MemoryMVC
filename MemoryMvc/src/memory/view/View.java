/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lotta
 */
public class View {
    
    ArrayList<String> pictures;
   
    private final VBlockButtonList buttonList; 
    private final int numRowsCols = 4;
    
    public View (int noOfItems) {
        buttonList = new VBlockButtonList(numRowsCols * numRowsCols);
    }
    
    public void generateMemoryGUI() {
        
        JFrame myFrame;
        JPanel myPanelMemory;
        JPanel myPanelRest;
        
        myFrame = generateFrame();
        myPanelMemory = generatePanel(numRowsCols);
        myPanelRest = generatePanel(2);
        buttonList.initiateButtonList(numRowsCols);
        for (int i = 0; i < (numRowsCols * numRowsCols); i++) {
            myPanelMemory.add(buttonList.getButton(i));
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
    
    public void addListener(int blockNo, ActionListener listener) {
        buttonList.addListener(blockNo, listener);
    }
    
    public void openButton(int blockNo, String file) {
        buttonList.openButton(blockNo, file);
    }
    
    public void closeButton(int blockNo, String file) {
        buttonList.closeButton(blockNo, file);
    }
    
    public void setRedBorder(int blockNo) {
        buttonList.setRedBorderColor(blockNo);
    }
    
    public void setGreenBorder(int blockNo) {
        buttonList.setGreenBorderColor(blockNo);
    }
    
    public void setNoBorder(int blockNo) {
        buttonList.setNoBorderColor(blockNo);
    }
}
