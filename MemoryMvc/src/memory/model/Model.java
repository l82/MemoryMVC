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
    
}
