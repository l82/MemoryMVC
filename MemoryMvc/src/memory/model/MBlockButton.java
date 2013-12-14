/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memory.model;

/**
 * The model object for a certain button
 * @author lotta
 */
public class MBlockButton {
    private Boolean closed;
    private Boolean solved;
    private String image;
    
    /**
     * Constructor that initiates model object to closed and not solved.
     */
    public void MBlockButton() {
        closed = true;
        solved = false;
        image = "";
    }
   
    /**
     * Set close state of a button
     * @param state state to set, true if closed else false
     */
    public void setClosed(Boolean state) {
        closed = state;
    }
    
    /**
     * Set solved state of a button
     * @param state state to set, true if solved else false
     */
    public void setSolved(Boolean state) {
        solved = state;
    }
    
    /**
     * Set the icon to a certain file name
     * @param file Name to set
     */
    public void setImage(String file) {
        image = file;
    }
    
    /**
     * Get file name of an icon
     * @return name of file
     */
    public String getImage() {
        return image;
    }
    
    /**
     * Get the state of the closed attribute
     * @return true if closed else false
     */
    public Boolean getClosedState() {
        return closed;
    }
    
    /**
     * Get the state of the solved attribute
     * @return true if solved else false
     */
    public Boolean getSolvedState() {
        return solved;
    }
}
