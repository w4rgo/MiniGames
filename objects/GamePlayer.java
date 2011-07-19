/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objects;

/**
 *
 * @author Fran
 */
public class GamePlayer {

    private String pname;
    private int gameId;
    private int expGained;
    private int position;

    GamePlayer (String pname, int gameId, int expGained, int position) {
        this.pname = pname;
        this.gameId = gameId;
        this.expGained = expGained;
        this.position = position;
    }

    public int getExpGained() {
        return expGained;
    }

    public void setExpGained(int expGained) {
        this.expGained = expGained;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }



    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
}
