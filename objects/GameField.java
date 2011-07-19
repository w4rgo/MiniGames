package objects;


import org.bukkit.block.Block;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran
 */
public class GameField {
    private String gameFieldName;
    private Block A;
    private Block B;
    private Game currentGame;
    private boolean gameInCourse;
    
    public GameField(String gameFieldName, Block A, Block B, String type) {
        this.gameFieldName = gameFieldName;
        this.A = A;
        this.B = B;
        this.type = type;
    }

    public boolean isGameInCourse() {
        return gameInCourse;
    }

    public void setGameInCourse(boolean gameInCourse) {
        this.gameInCourse = gameInCourse;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    private String type;

    public Block getA() {
        return A;
    }

    public void setA(Block A) {
        this.A = A;
    }

    public Block getB() {
        return B;
    }

    public void setB(Block B) {
        this.B = B;
    }

    public String getGameFieldName() {
        return gameFieldName;
    }

    public void setGameFieldName(String gameFieldName) {
        this.gameFieldName = gameFieldName;
    }
    
    
}
