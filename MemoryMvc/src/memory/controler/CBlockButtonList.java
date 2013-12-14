/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.controler;
import java.util.ArrayList;

/**
 *
 * @author lotta
 */
public class CBlockButtonList {
 
    ArrayList<CBlockButton> buttonList;
    int noOfButtons;
    
    public CBlockButtonList() {
        buttonList = new ArrayList<>();
        noOfButtons = 0; 
    }
    
    public void initiateCButtons(memory.model.Model mModel, 
            memory.view.View vView, int inNoOfButtons) {
        noOfButtons = inNoOfButtons;
        for (int i = 0; i < noOfButtons; i++) {
            CBlockButton block = new CBlockButton(i);
            buttonList.add(block);
            block.cBlockButtonControl(mModel, vView, i);
        }
    }
}
