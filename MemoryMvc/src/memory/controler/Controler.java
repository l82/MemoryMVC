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
    
    private memory.view.View  vView;
    private memory.model.Model  mModel;
    private final CBlockButtonList cButtonList;
    
    public Controler(memory.model.Model inModel,
            memory.view.View inViewer) {
        vView = inViewer;
        mModel = inModel;
        cButtonList = new CBlockButtonList();
    }
    
    public String getImage(int blockNo) {
        return mModel.getImage(blockNo);
    }
    
    private void generateCButtons(int noOfImages) {
         cButtonList.initiateCButtons(mModel, vView, noOfImages * 2);
    }
    
    public static void main(String[] args) {
        int noOfImages = 8;
        
        memory.model.Model mModel = new memory.model.Model(noOfImages);
        memory.view.View vView = new memory.view.View(noOfImages * 2);
        memory.controler.Controler cControler = new Controler(mModel, vView);
        vView.generateMemoryGUI();
        cControler.generateCButtons(noOfImages);
        mModel.randomizeBlocks();
    }
}
