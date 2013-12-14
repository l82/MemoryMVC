/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.controler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * HAndle control of a button. Mainly having the actionListener
 * @author lotta
 */
public class CBlockButton implements ActionListener {
    private ActionListener actionListener;
    private final int blockNo;
    
    /**
     * Constructor to create a control button
     * @param no button number in array
     */
    public CBlockButton(int no) {
        blockNo = no;
    }
    
    /**
     * Button control that handles what should happen when clicking on the button.
     * @param mModel main model object
     * @param vView main view object
     * @param blockNo button number in array
     */
    public void cBlockButtonControl(final memory.model.Model mModel,
            final memory.view.View vView, final int blockNo){        
        
        actionListener = new ActionListener() {
                
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Boolean possibleOpen;
                Boolean ownClosedState;
                int otherButton = -1;
                possibleOpen = mModel.checkValidToOpen(blockNo);
                ownClosedState = mModel.getClosed(blockNo);
                otherButton = mModel.findOtherOpened(blockNo);
                if (possibleOpen && otherButton >= 0) {
                    Boolean result;
                    result = mModel.validateResult(blockNo, otherButton);
                    setButtonAttributes(mModel, vView, blockNo, otherButton, result);
                    setModelAttributes(mModel, blockNo, otherButton, result);
                    setLabelAttributes(mModel, vView);
                }
                else if ((ownClosedState == true) && possibleOpen && otherButton < 0) {
                    setOneButtonAttributes(mModel, vView, blockNo);
                    setOneModelAttributes(mModel, blockNo);
                }
                else if (ownClosedState == false) {
                    setOneButtonClosedAttributes(vView, blockNo);
                    setOneModelClosedAttributes(mModel, blockNo);
                }
                else if (possibleOpen == false ) {
                    System.out.println("It is not possible to open more than two buttons at a time");
                }
            }
        };                
        vView.addListener(blockNo, actionListener);   
    }
    
    private void setLabelAttributes(final memory.model.Model mModel,
            final memory.view.View vView) {
        int failed;
        int executed;
        
        failed = mModel.getFailed();
        executed = mModel.getNoOfTries();
        vView.setTextInfo(failed, executed);
        
    }
    
    private void setButtonAttributes(final memory.model.Model mModel,
            final memory.view.View vView, int blockNo,
            int otherButton, Boolean result) {
        String file1, file2;
        file1 = mModel.getImage(blockNo);
        file2 = mModel.getImage(otherButton);
        
        vView.openButton(blockNo, file1);
        vView.openButton(otherButton, file2);
        if (result == true) {
            vView.setGreenBackground(blockNo);
            vView.setGreenBackground(otherButton);
        }
        else {
            vView.setRedBackground(blockNo);
            vView.setRedBackground(otherButton);
        }
    }
    
    private void setOneButtonAttributes(final memory.model.Model mModel,
            final memory.view.View vView, int blockNo) {
        String file1;
        file1 = mModel.getImage(blockNo);
        vView.openButton(blockNo, file1);
    }
    
    private void setOneButtonClosedAttributes(final memory.view.View vView, int blockNo) {
        vView.closeButton(blockNo, "");
        vView.setNoBackground(blockNo);
    }
    
    private void setModelAttributes(final memory.model.Model mModel, int blockNo,
            int otherButton, Boolean result) {
        
        mModel.setClosed(blockNo, false);
        mModel.setClosed(otherButton, false);
        mModel.increaseTries();
        if (result == true) {
             mModel.setSolved(blockNo, true);
             mModel.setSolved(otherButton, true);
        }
        else {
            mModel.increaseFailed();
        }
    }  
    
    private void setOneModelAttributes(final memory.model.Model mModel, 
            int blockNo) {
        
        mModel.setClosed(blockNo, false);
    } 
    
    private void setOneModelClosedAttributes(final memory.model.Model mModel, 
            int blockNo) {
        
        mModel.setClosed(blockNo, true);
    } 
    
    @Override
    /**
     * Not used
     */
    public void actionPerformed(ActionEvent e)
    {
    
    }      
}
