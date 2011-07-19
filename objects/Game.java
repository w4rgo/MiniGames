/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objects;

import java.util.HashMap;

/**
 *
 * @author Fran
 */
public class Game {
    private int id;
    private String type;
    //private int nplayers;
    private String winner;
    private String gameField;
    private HashMap<String,Player> players = new HashMap<String,Player>();
    
    
    public Game (int id, String type, String gameField) {
        this.id = id;
        this.type = type;
        this.gameField = gameField;
        
    }

    public int getId() {
        return id;
    }

    public String getGameField() {
        return gameField;
    }

    public void setGameField(String gameField) {
        this.gameField = gameField;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<String, Player> getPlayers() {
        return players;
    }

    public void setPlayers(HashMap<String, Player> players) {
        this.players = players;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    
}
