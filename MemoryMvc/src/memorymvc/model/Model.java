/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memorymvc.model;

import java.util.*;

/**
 *
 * @author lotta
 */
public class Model {
    
    ArrayList<Integer> numberSeries;
    
    public Model() {
        numberSeries = new ArrayList<>();
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
    
}
