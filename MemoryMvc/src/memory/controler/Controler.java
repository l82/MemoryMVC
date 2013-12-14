/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main controler class for memory game.
 * @author lotta
 */
public class Controler {
    
    private final memory.view.View  vView;
    private final memory.model.Model  mModel;
    private final CBlockButtonList cButtonList;
    
    /**
     * Constructor for Controler object that initiates handle to main view and
     * main model object.
     * @param inModel main model object
     * @param inViewer main view object
     */
    public Controler(memory.model.Model inModel,
            memory.view.View inViewer) {
        vView = inViewer;
        mModel = inModel;
        cButtonList = new CBlockButtonList();
    }
    
    /**
     * Get file name for the icon on a certain block
     * @param blockNo number in CBlockButtonList
     * @return name of file
     */
    public String getImage(int blockNo) {
        return mModel.getImage(blockNo);
    }
    
    private void generateCButtons(int noOfImages) {
         cButtonList.initiateCButtons(mModel, vView, noOfImages * 2);
    }
    
    private void generateStartButton(final memory.view.View vView,
            final memory.model.Model mModel)  {        
        
          ActionListener actionListener;
          actionListener = new ActionListener() {
                
          @Override
          public void actionPerformed(ActionEvent e)
          {
              mModel.initialize();
              vView.initialize();
               
          }
        };                
        vView.addStartListener(actionListener);   
    }
    
    /**
     * The main method for the memory game
     * @param args 
     */
    public static void main(String[] args) {
        int noOfImages = 8;
        
        memory.model.Model mModel = new memory.model.Model(noOfImages);
        memory.view.View vView = new memory.view.View(noOfImages * 2);
        memory.controler.Controler cControler = new Controler(mModel, vView);
        vView.generateMemoryGUI();
        cControler.generateCButtons(noOfImages);
        cControler.generateStartButton(vView, mModel);
        mModel.randomizeBlocks();
    }
}
