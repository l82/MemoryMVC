/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lotta
 */
public class MBlockButtonList {
    
    ArrayList<Integer> numberSeries;
    ArrayList<MBlockButton> buttonList;
     
    public MBlockButtonList() {
        numberSeries = new ArrayList<>();
        buttonList = new ArrayList<>();
    }
    
    public void initiateMBlockButtonList(int noBlocks) {
        
        for (int i = 0; i < noBlocks; i++) {
            MBlockButton block = new MBlockButton();
            block.setClosed(true);
            block.setSolved(false);
            buttonList.add(block);
        }
        addImages(noBlocks);
    }
    
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
    
    /*
    public Boolean checkValidToOpen(int blockNo) {
        
        Boolean possibleToOpen, moreThanOneOpened; 
        //Change only if needed
        possibleToOpen = true;
        int numberOfBlocks;
        Boolean ownClosed;
        ArrayList<Boolean> blocking;
        ownClosed = getClosedState();
        moreThanOneOpened = false;
        
        //First get total number of blocka
        numberOfBlocks = memoryViewer.getNumberOfBlocks();
        blocking = fillBlockingList(numberOfBlocks);
        
        //Set possibleToOpen to true first and check if anything blocks that
        if (ownClosed == true) {
            moreThanOneOpened = evaluateMoreThanOneOpened(blocking);
        }
        
        if ((ownClosed == false) || (moreThanOneOpened)) {
            possibleToOpen = false;
        }
        
        return possibleToOpen;
    }
    
    private Boolean evaluateMoreThanOneOpened(ArrayList<Boolean> blocking) {
        Boolean more;
        int numberOfBlocksOpened;
        numberOfBlocksOpened = 0;
        System.out.println("L8 should evaluate");
        
        for (int i = 0; i < blocking.size(); i++) {
            if ((blocking.get(i)) == true) {
                System.out.println("L8 blocking is true");
                numberOfBlocksOpened++;
            }
        }
        //Initiate to false
        more = false;
        if (numberOfBlocksOpened > 1) {
            more = true;
        }
        return more;
    }
    
    private ArrayList<Boolean> fillBlockingList(int numberOfBlocks) {
        Boolean blockMayBlock; 
        ArrayList<Boolean> blocking = new ArrayList<>();
        for (int i = 0; i < numberOfBlocks; i++) {
            blockMayBlock = evaluateBlockState(i);
            blocking.add(blockMayBlock);
        }
        return blocking;
    }
    
    private Boolean evaluateBlockState(int blockNo) {
        
        Boolean possibleBlocking;
        
        //Initialize to blocking and change if needed
        possibleBlocking = true;
        if (closed || solved) {
            possibleBlocking = false;
        }
        return possibleBlocking;
    }
    */
    
    
}
