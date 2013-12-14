/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author lotta
 */
public class VBlockButtonList {
    ArrayList<VBlockButton> buttonList;
    int numBlocks;
    
    public VBlockButtonList (int noOfItems) {
        numBlocks = noOfItems;
        buttonList = new ArrayList<>();
    }
     

    public void initiateButtonList(int numRowsCols) {
        for (int i = 0; i < (numRowsCols * numRowsCols); i++) {
            VBlockButton button = new VBlockButton(i);
            buttonList.add(button);
            button.setNoBorderColor();
        }  
    }
    
    public VBlockButton getButton(int no) {
        VBlockButton button;
        button = buttonList.get(no);
        return button;
    }
    
    public void addListener(int blockNo, ActionListener listener) {
        buttonList.get(blockNo).addActionListener(listener);
    }
    
    public void openButton(int blockNo, String file) {
        buttonList.get(blockNo).openButton(file);
    }
    
    public void closeButton(int blockNo, String file) {
        buttonList.get(blockNo).closeButton(file);
    }
    
    public void setRedBorderColor(int blockNo) {
        buttonList.get(blockNo).setRedBorderColor();
    }
    
    public void setGreenBorderColor(int blockNo) {
        buttonList.get(blockNo).setGreenBorderColor();
    }
    
    public void setNoBorderColor(int blockNo) {
        buttonList.get(blockNo).setNoBorderColor();
    }
}
