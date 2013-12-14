/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class that handle the view part of the button list
 * @author lotta
 */
public class VBlockButtonList {
    ArrayList<VBlockButton> buttonList;
    int numBlocks;
    
    /**
     * Constructor that initialises the arrayList
     * @param noOfItems 
     */
    public VBlockButtonList (int noOfItems) {
        numBlocks = noOfItems;
        buttonList = new ArrayList<>();
    }
     

    /**
     * Initiates the button list
     * @param numRowsCols number of buttons in a row or in a column
     */
    public void initiateButtonList(int numRowsCols) {
        for (int i = 0; i < (numRowsCols * numRowsCols); i++) {
            VBlockButton button = new VBlockButton(i);
            buttonList.add(button);
            button.setNoBackgroundColor();
        }  
    }
    
    /**
     * Set back buttons to default state
     */
    public void initialize() {
        for (int i = 0; i < (numBlocks); i++) {
            buttonList.get(i).setNoBackgroundColor();
            buttonList.get(i).closeButton("");
        }  
    }
    
    /**
     * Gets the button object
     * @param no the number of the button to get in arrayList
     * @return 
     */
    public VBlockButton getButton(int no) {
        VBlockButton button;
        button = buttonList.get(no);
        return button;
    }
    
    /**
     * Add a listener for the button
     * @param blockNo the number of the button to get in arrayList
     * @param listener listener to add
     */
    public void addListener(int blockNo, ActionListener listener) {
        buttonList.get(blockNo).addActionListener(listener);
    }
    
    /**
     * Opens a button
     * @param blockNo the number of the button to get in arrayList
     * @param file the file name of the image
     */
    public void openButton(int blockNo, String file) {
        buttonList.get(blockNo).openButton(file);
    }
    
      /**
     * Closes a button
     * @param blockNo the number of the button to get in arrayList
     * @param file the file name of the image
     */
    public void closeButton(int blockNo, String file) {
        buttonList.get(blockNo).closeButton(file);
    }
    
    /**
     * Sets red color of background
     * @param blockNo the number of the button to get in arrayList
     */
    public void setRedBackgroundColor(int blockNo) {
        buttonList.get(blockNo).setRedBackgroundColor();
    }
    
    /**
     * Sets green color of background
     * @param blockNo the number of the button to get in arrayList
     */
    public void setGreenBackgroundColor(int blockNo) {
        buttonList.get(blockNo).setGreenBackgroundColor();
    }
    
     /**
     * Sets grey color of background
     * @param blockNo the number of the button to get in arrayList
     */
    public void setNoBackgroundColor(int blockNo) {
        buttonList.get(blockNo).setNoBackgroundColor();
    }
}
