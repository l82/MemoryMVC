/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.model;

import java.util.*;

/**
 *
 * @author lotta
 */
public class MBlockButton {
    private Boolean closed;
    private Boolean solved;
    private String image;
    
    public void MBlockButton() {
        closed = true;
        solved = false;
        image = "";
    }
   
    public void setClosed(Boolean state) {
        closed = state;
    }
    
    public void setSolved(Boolean state) {
        solved = state;
    }
    
    public void setImage(String file) {
        image = file;
    }
    
    public String getImage() {
        return image;
    }
    
    public Boolean getClosedState() {
        return closed;
    }
    
    public Boolean getSolvedState() {
        return solved;
    }
    
    public void setClosedState(Boolean state) {
        closed = state;
    }
    
    public void setSolvedState(Boolean state) {
        solved = state;
    }
}
