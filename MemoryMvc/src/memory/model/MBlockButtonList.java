/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to handle the model objects of the memory blocks
 * @author lotta
 */
public class MBlockButtonList {
    
    ArrayList<Integer> numberSeries;
    ArrayList<MBlockButton> buttonList;
    int noOfBlocks;
     
    /**
     * Constructor that initiates two arrays
     */
    public MBlockButtonList() {
        numberSeries = new ArrayList<>();
        buttonList = new ArrayList<>();
    }
    
    /**
     * Initiates the model objects of the buttons
     * @param noBlocks total number of blocks in list
     */
    public void initiateMBlockButtonList(int noBlocks) {
        
        for (int i = 0; i < noBlocks; i++) {
            MBlockButton block = new MBlockButton();
            block.setClosed(true);
            block.setSolved(false);
            buttonList.add(block);
        }
        addImages(noBlocks);
        noOfBlocks = noBlocks;
    }
    
    /**
     * Set all model objects to initial state
     */
    public void initialize() {
        
        for (int i = 0; i < noOfBlocks; i++) {
            buttonList.get(i).setClosed(true);
            buttonList.get(i).setSolved(false);
        }
    }
    
    /**
     * Get filename for an icon
     * @param blockNo number in button model arrayList
     * @return name of file
     */
    public String getImage(int blockNo) {
        String fileName;
        fileName = buttonList.get(blockNo).getImage();
        return fileName;
    }
    
    private void addImages(int noBlocks) {
        String fileName;
        MBlockButton button;
        int numImages = noBlocks / 2;
        
        for (int i = 0; i < numImages; i++) {
            fileName = "img" + i + ".png";
            button = buttonList.get(i);
            button.setImage(fileName);
        }
        for (int i = numImages; i < (numImages * 2); i++) {
            fileName = "img" + (i-numImages) + ".png";
            button = buttonList.get(i);
            button.setImage(fileName);
        }
    }
    
    /**
     * Get a randomized array
     * @param allAreas
     * @return 
     */
    public ArrayList<Integer> getRandomizedNumbers(int allAreas) {
        
       fillNumbers(allAreas);
       randomNumbers();     
       return numberSeries;
    }
    
    private void fillNumbers(int toNumber){
       for(int i = 0; i < toNumber; i++){
            numberSeries.add(i);
       }
    }
    
    private void randomNumbers() {
        
        Collections.shuffle(numberSeries);
        for (int i : numberSeries) {
            System.out.println("Randomized picture order: " + i);
        }
    }
    
    /**
     * Gets closed state of a button model object
     * @param no number in array of model button objects
     * @return true if button is closed else false
     */
    public Boolean getClosedState(int no) {
        Boolean closed;
        closed = buttonList.get(no).getClosedState();
        return closed;
    }
    
    /**
     * Gets solved state of a button model object 
     * @param no number in array of model button objects
     * @return true if button is solved else false
     */
    public Boolean getSolvedState(int no) {
        Boolean solved;
        solved = buttonList.get(no).getSolvedState();
        return solved;
    }
    
    /**
     * Sets a button model object to closed state
     * @param no number in array of model button objects
     * @param state State to set, true if closed else false
     */
    public void setClosedState(int no, Boolean state) {
        buttonList.get(no).setClosed(state);
    }
    
     /**
     * Sets a button model object to solved state
     * @param no number in array of model button objects
     * @param state State to set, true if solved else false
     */
    public void setSolvedState(int no, Boolean state) {
        buttonList.get(no).setSolved(state);
    }
    
    /**
     * Check if it is possible to open a button or not depending on status of 
     * the other buttons 
     * @param no number in array of model button objects
     * @return true if ok to open else false
     */
    public Boolean checkValidToOpen(int no) {
        Boolean result;
        result = true;
        int intResult;
        intResult = 0;
        for (int i = 0; i < buttonList.size(); i++) {
            if ((buttonList.get(i).getClosedState() == false) &&
                (buttonList.get(i).getSolvedState() == false)) {
                intResult++;
            }
        }
        if (intResult > 1) {
            result = false;
        }
        return result;
    }
    
    /**
     * Checks if another button already is opened or not
     * @param blockNo number in model object array
     * @return -1 if no opened button was found, else number of button that 
     * was found
     */
    public int findOtherOpened(int blockNo) {
        int result = -1;
        Boolean closed;
        Boolean solved;
        for (int i = 0; i < buttonList.size(); i++) {
            closed = buttonList.get(i).getClosedState();
            solved = buttonList.get(i).getSolvedState();
            if (i == blockNo) {
                continue;
            }
            if (closed) {
                continue;
            }
            if (solved) {
                continue;
            }
            result = i;
        }
        return result;
    }
    
    /**
     * Validates if two images are the same or not
     * @param blockNo the number in model object arrayList
     * @param otherOpened the number in array of the other opened image
     * @return true if the images are the same else false
    */
    public Boolean validateResult(int blockNo, int otherOpened) {
        String image1, image2;
        Boolean result;
        image1 = buttonList.get(blockNo).getImage();
        image2 = buttonList.get(otherOpened).getImage();
        if (image1.equals(image2)) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }
}
