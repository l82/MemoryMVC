/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.model;

/**
 * The main model object for the memory game
 * @author lotta
 */
public class Model {

    int noOfBlocks;
    MBlockButtonList list;
    int failed;
    int noOfTries;
    
    /**
     * Constructor that sets initial values for failed and trials
     * @param inNoBlocks the number in model object arrayList
     */
    public Model (int inNoBlocks) {
        noOfBlocks = inNoBlocks;
        failed = 0;
        noOfTries = 0;
    }
    
    /**
     * Randomises and initiates the button list
     */
    public void randomizeBlocks() {
        list = new MBlockButtonList();
        list.initiateMBlockButtonList((noOfBlocks * 2));
    }
    
    /**
     * Get the filename of the image used on button
     * @param blockNo the number in model object arrayList
     * @return the file name
     */
    public String getImage(int blockNo) {
        String file;
        file = list.getImage(blockNo);
        return file;
    }
    
    /**
     * Get the closed state for a certain block
     * @param blockNo the number in model object arrayList
     * @return the state for closed, true if closed else false
     */
    public Boolean getClosed(int blockNo) {
        Boolean result;
        result = list.getClosedState(blockNo);
        return result;
    }
    
    /**
     * Get the solved state for a certain block
     * @param blockNo the number in model object arrayList
     * @return the state for solved, true if closed else false
     */
    public Boolean getSolved(int blockNo) {
        Boolean result;
        result = list.getSolvedState(blockNo);
        return result;
    }
    
    /**
     * Set closed state for a block
     * @param blockNo the number in model object arrayList
     * @param stateToSet the state to set, true if closed else false
     */
    public void setClosed(int blockNo, Boolean stateToSet) {
        list.setClosedState(blockNo, stateToSet);
    }
    
     /**
     * Set solved state for a block
     * @param blockNo the number in model object arrayList
     * @param stateToSet the state to set, true if solved else false
     */
    public void setSolved(int blockNo, Boolean stateToSet) {
        list.setSolvedState(blockNo, stateToSet);
    }
    
    /**
     * Checks if a button is valid to open or not
     * @param no the number in model object arrayList
     * @return true if button is possible to open, else false
     */
    public Boolean checkValidToOpen(int no) {
        Boolean result;
        result = list.checkValidToOpen(no);
        return result;
    }
    
    /**
     * Finds any other opened button
     * @param blockNo the number in model object arrayList
     * @return -1 if not found else number in array
     */
    public int findOtherOpened(int blockNo) {
        int result;
        result = list.findOtherOpened(blockNo);
        return result;
    }
     
    /**
     * Increase number of failed trials with one
     */
    public void increaseFailed() {
        failed++;
    }
    
    /**
     * Increases number of tests with one
     */
    public void increaseTries() {
        noOfTries++;
    }
    
    /**
     * Get number of failed trials
     * @return the number of failed trials
     */
    public int getFailed() {
        return failed;
    }
    
    /**
     * Gets number of trials within a game
     * @return Number of trials
     */
    public int getNoOfTries() {
        return noOfTries;
    }
    
    /**
     * Initialises the model object to default values 
     */
    public void initialize() {
        failed = 0;
        noOfTries = 0;
        list.initialize();
        randomizeBlocks();
    }
    
    /**
     * Validates if two images are the same or not
     * @param blockNo the number in model object arrayList
     * @param otherOpened the number in array of the other opened image
     * @return true if the images are the same else false
     */
    public Boolean validateResult(int blockNo, int otherOpened) {
        Boolean result, validate;
        validate = true;
        
        if (otherOpened == -1) {
            validate = false;
        }
        if (validate) {
            result = list.validateResult(blockNo, otherOpened);
        }
        else {
            result = false;
        }
        return result;
    }
}
