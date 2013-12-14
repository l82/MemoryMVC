/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.controler;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;

/**
 *
 * @author lotta
 */
public class CBlockButton implements ActionListener {
    private ActionListener actionListener;
    private int blockNo;
    
    public CBlockButton(int no) {
        blockNo = no;
    }
    
    public void cBlockButtonControl(final memory.model.Model mModel,
            final memory.view.View vView, final int blockNo){        
        
        actionListener = new ActionListener() {
               @Override
                public void actionPerformed(ActionEvent e)
                {
                Boolean shouldOpen;
                String file;
                file = mModel.getImage(blockNo);
                System.out.println("L8 " + file);
                //shouldOpen = checkValidToOpen(blockNo);
                //if (shouldOpen && (closed == true)) {
                    vView.openButton(blockNo, file);
                //    closed = false;
                //}
                //else {
                //    memoryButton.closeButton();
                //    closed = true;
                    System.out.println("You are not allowed to open any more block.");
                //}
            }
        };                
        vView.addListener(blockNo, actionListener);   
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
    //    Boolean shouldOpen;
    //    shouldOpen = checkValidToOpen(blockNo);
    //    if (shouldOpen && (closed == true)) {
    //        memoryButton.openButton();
    //        closed = false;
    //    }
    //    else {
    //        memoryButton.closeButton();
    //        closed = true;
    //        System.out.println("You are not allowed to open any more block.");
    //    }
    }      
}
