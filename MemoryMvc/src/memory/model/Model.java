/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.model;

/**
 *
 * @author lotta
 */
public class Model {

    int noOfBlocks;
    MBlockButtonList list;
    
    public Model (int inNoBlocks) {
        noOfBlocks = inNoBlocks;
    }
    
    public void randomizeBlocks() {
        list = new MBlockButtonList();
        list.initiateMBlockButtonList((noOfBlocks * 2));
    }
    
    public String getImage(int blockNo) {
        String file;
        file = list.getImage(blockNo);
        return file;
    }
    
    public Boolean getClosed(int blockNo) {
        Boolean result;
        result = list.getClosedState(blockNo);
        return result;
    }
    
    public Boolean getSolved(int blockNo) {
        Boolean result;
        result = list.getSolvedState(blockNo);
        return result;
    }
    
    public void setClosed(int blockNo, Boolean stateToSet) {
        list.setClosedState(blockNo, stateToSet);
    }
    
    public void setSolved(int blockNo, Boolean stateToSet) {
        list.setSolvedState(blockNo, stateToSet);
    }
    
    public Boolean checkValidToOpen(int no) {
        Boolean result;
        result = list.checkValidToOpen(no);
        return result;
    }
    
    public int getOtherOpened(int blockNo) {
        int result;
        result = list.getOtherOpened(blockNo);
        return result;
    }
    
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
