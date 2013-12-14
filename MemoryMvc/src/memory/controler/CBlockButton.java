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
                Boolean shouldOpen, closed, correct;
                String file;
                int otherOpened;
                
                correct = false;
                otherOpened = -1;
                file = mModel.getImage(blockNo);
                closed = mModel.getClosed(blockNo);
                shouldOpen = mModel.checkValidToOpen(blockNo);
                otherOpened = mModel.getOtherOpened(blockNo);
                System.out.println("L8 shouldOpen " + shouldOpen + " closed " + closed);
                if (shouldOpen && (closed == true)) {
                    vView.openButton(blockNo, file);
                    mModel.setClosed(blockNo, false);
                }
                else {
                    vView.closeButton(blockNo, "");
                    mModel.setClosed(blockNo, true);
                    vView.setNoBorder(blockNo);
                    System.out.println("You are not allowed to open any more block.");
                    otherOpened = -1;
                }
                
                correct = mModel.validateResult(blockNo, otherOpened);
                
                System.out.println("L8 blockNo: " + blockNo + " otherOpened: " + 
                        otherOpened + " correct: " + correct);
                
                if (correct == true) {
                    vView.setGreenBorder(blockNo);
                    vView.setGreenBorder(otherOpened);
                    mModel.setSolved(blockNo, true);
                    mModel.setSolved(otherOpened, true);
                }
                else if (correct == false && otherOpened >= 0) {
                    vView.setRedBorder(blockNo);
                    vView.setRedBorder(otherOpened);
                }
                else {
                    vView.setNoBorder(blockNo);
                }
            }
        };                
        vView.addListener(blockNo, actionListener);   
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
    
    }      
}
