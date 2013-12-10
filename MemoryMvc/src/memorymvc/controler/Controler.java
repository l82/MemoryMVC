/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memorymvc.controler;

import java.util.*;

/**
 *
 * @author lotta
 */
public class Controler {
    
     public static void main(String[] args) {
        Controler memoryControler = new Controler();
        memoryControler.runMemory();
    }
     
    private void runMemory() {

        memorymvc.view.Viewer memoryViewer = new memorymvc.view.Viewer();
        memorymvc.model.Model memoryModel = new memorymvc.model.Model();
        memoryViewer.generateMemoryGUI();
        randomizePlaces(memoryViewer, memoryModel);
    }
    
    private void randomizePlaces(memorymvc.view.Viewer viewer,
                                 memorymvc.model.Model model) {
        int oneRow;
        int allAreas;
        ArrayList<Integer> allPlaces;
        oneRow = viewer.getNumRowsCols();
        allAreas = oneRow * oneRow;
        allPlaces = model.getRandomizedNumbers(allAreas);
        viewer.setImages(allPlaces);
    }
}
