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
    ArrayList<VBlockButton> buttonList;
    private memory.controler.Controler memoryControler;
    private memory.model.MBlockButtonList memoryModel;
    private final int numBlocks; 
    private final int numRowsCols = 4;
    
    public View (int noOfItems) {
        numBlocks = noOfItems;
        buttonList = new ArrayList<>();
    }
    
    public void generateMemoryGUI() {
        
        JFrame myFrame;
        JPanel myPanelMemory;
        JPanel myPanelRest;
        
        myFrame = generateFrame();
        myPanelMemory = generatePanel(numRowsCols);
        myPanelRest = generatePanel(2);
        
        for (int i = 0; i < (numRowsCols * numRowsCols); i++) {
            VBlockButton button = new VBlockButton(this, i);
            myPanelMemory.add(button);
            buttonList.add(button);
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
        buttonList.get(blockNo).addActionListener(listener);
    }
    
    public void openButton(int blockNo, String file) {
        buttonList.get(blockNo).openButton(file);
    }
    
    public void closeButton(int blockNo, String file) {
        buttonList.get(blockNo).closeButton();
    }
}
