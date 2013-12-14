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
    int noOfBlocks;
     
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
        noOfBlocks = noBlocks;
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
    
    public Boolean getClosedState(int no) {
        Boolean closed;
        closed = buttonList.get(no).getClosedState();
        return closed;
    }
    
    public Boolean getSolvedState(int no) {
        Boolean solved;
        solved = buttonList.get(no).getSolvedState();
        return solved;
    }
    
    public void setClosedState(int no, Boolean state) {
        buttonList.get(no).setClosedState(state);
    }
    
    public void setSolvedState(int no, Boolean state) {
        buttonList.get(no).setSolvedState(state);
    }
    
    public Boolean checkValidToOpen(int no) {
        Boolean result;
        result = true;
        int intResult;
        intResult = 0;
        for (int i = 0; i < buttonList.size(); i++) {
            if (i == no) {
                continue;
            }
            if (buttonList.get(i).getClosedState() == false &&
                    buttonList.get(i).getSolvedState() == false) {
                intResult++;
            }
        }
        if (intResult > 1) {
            result = false;
        }
        return result;
    }
    
    public int getOtherOpened(int blockNo) {
        int result = -1;
        Boolean closed;
        Boolean solved;
        for (int i = 0; i < buttonList.size(); i++) {
            closed = buttonList.get(i).getClosedState();
            solved = buttonList.get(i).getSolvedState();
            if (i == blockNo) {
                System.out.println("L8 in blockNo: " + i);
                continue;
            }
            if (closed) {
                System.out.println("L8 in closed: " + i);
                continue;
            }
            if (solved) {
                System.out.println("L8 in solved: " + i);
                continue;
            }
            System.out.println("L8 in end: " + i);
            result = i;
        }
        return result;
    }
    
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
