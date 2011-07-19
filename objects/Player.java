/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objects;

/**
 *
 * @author Fran
 */
public class Player{
    private String name;
    private int lvl;
    private int exp;
    private boolean invSaved;
    
    Player(String name) {

        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public boolean isInvSaved() {
        return invSaved;
    }

    public void setInvSaved(boolean invSaved) {
        this.invSaved = invSaved;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
