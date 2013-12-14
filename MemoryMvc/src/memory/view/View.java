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
import javax.swing.JLabel;
import javax.swing.JButton;
import java.lang.Math.*;

/**
 * The main class for the view package
 * @author lotta
 */
public class View {
    
    ArrayList<String> pictures;
    JLabel textString;
    JButton startButton;
    
    private final VBlockButtonList buttonList; 
    private final int numRowsCols;
    private final int numItems;
    
    /**
     * Constructor that initiates some variables
     * @param noOfItems 
     */
    public View (int noOfItems) {
        double square, bSquare;
        buttonList = new VBlockButtonList(noOfItems);
        numItems = noOfItems;
        bSquare = (double)numItems;
        square = Math.sqrt(bSquare);
        numRowsCols = (int)square;
    }
    
    /**
     * Generates GUI for memory game
     */
    public void generateMemoryGUI() {
        
        JFrame myFrame;
        JPanel myPanelMemory;
        JPanel myPanelRest;
        textString = new JLabel("Welcome");
        startButton = new JButton("Restart");
        
        myFrame = generateFrame();
        myPanelMemory = generatePanel(numRowsCols);
        myPanelRest = generatePanel(2);
        buttonList.initiateButtonList(numRowsCols);
        for (int i = 0; i < (numRowsCols * numRowsCols); i++) {
            myPanelMemory.add(buttonList.getButton(i));
        }   
       
        myPanelRest.add(textString);
        myPanelRest.add(startButton);
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
    
    /**
     * Adds a listener for the blocks in the memory game
     * @param blockNo the number in the buttonList array
     * @param listener the listener to add
     */
    public void addListener(int blockNo, ActionListener listener) {
        buttonList.addListener(blockNo, listener);
    }
    
    /**
     * Adds a listener for the start button in the memory game
     * @param listener the listener to add
     */
    public void addStartListener (ActionListener listener) {
        startButton.addActionListener(listener);
    }
    
    /**
     * Opens a button
     * @param blockNo the number in the buttonList array
     * @param file the file name of the image
     */
    public void openButton(int blockNo, String file) {
        buttonList.openButton(blockNo, file);
    }
    
     /**
     * Closes a button
     * @param blockNo the number in the buttonList array
     * @param file the file name of the image
     */
    public void closeButton(int blockNo, String file) {
        buttonList.closeButton(blockNo, file);
    }
    
    /**
     * Set background color red for a button
     * @param blockNo the number in the buttonList array
     */
    public void setRedBackground(int blockNo) {
        buttonList.setRedBackgroundColor(blockNo);
    }
    
    /**
     * Set background color green for a button
     * @param blockNo the number in the buttonList array
     */
    public void setGreenBackground(int blockNo) {
        buttonList.setGreenBackgroundColor(blockNo);
    }
    
    /**
     * Set background color grey for a button
     * @param blockNo the number in the buttonList array
     */
    public void setNoBackground(int blockNo) {
        buttonList.setNoBackgroundColor(blockNo);
    }
    
    /**
     * Sets information about game in a label
     * @param failed number of failed trials
     * @param noOfTries number of total trials
     */
    public void setTextInfo(int failed, int noOfTries) {
        textString.setText("No of failed: " + failed + ", No of tries: " + noOfTries);
    }
    
    /**
     * Initialises GUI for a new game
     */
    public void initialize() {
        textString.setText("");
        buttonList.initialize();
    }
}
