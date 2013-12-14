/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.controler;

import java.util.*;
import memory.model.MBlockButton;
import memory.view.View;
/**
 *
 * @author lotta
 */
public class Controler {
    
    memory.view.View  vView;
    memory.model.Model  mModel;
    
    public Controler(memory.model.Model inModel,
            memory.view.View inViewer) {
        vView = inViewer;
        mModel = inModel;
        
    }
    
    public void initiateCButtons(memory.model.Model mModel, int noOfButtons) {
        for (int i = 0; i < noOfButtons; i++) {
            CBlockButton block = new CBlockButton(i);
            block.cBlockButtonControl(mModel, vView, i);
        }
    }
    
    public String getImage(int blockNo) {
        return mModel.getImage(blockNo);
    }
    
    public static void main(String[] args) {
        int noOfImages = 8;
        
        memory.model.Model mModel = new memory.model.Model(noOfImages);
        memory.view.View vView = new memory.view.View(noOfImages * 2);
        memory.controler.Controler cControler = new Controler(mModel, vView);
        vView.generateMemoryGUI();
        cControler.initiateCButtons(mModel, noOfImages * 2);
        mModel.randomizeBlocks();
    }
}
