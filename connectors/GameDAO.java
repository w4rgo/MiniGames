package connectors;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import minigames.DbConnect;
import minigames.MinigamesCommand;
import objects.Game;
import objects.GameField;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran
 */
public class GameDAO {
    
        public static int countGames() throws SQLException {
            PreparedStatement prep = DbConnect.getConn().prepareStatement("select id from game where max(id);");
            ResultSet rs = prep.executeQuery();
            int i=0;
            while (rs.next()) {
                i++;
            } 
            return i;
        }
    
        public static void saveGame(Game game) {
            try {
                //Save The Inventory(gameId,type,winner,duration)
                PreparedStatement prep = DbConnect.getConn().prepareStatement("insert into game values (null ,? , null);");
                prep.setObject(2, game.getType());
                prep.executeBatch();
                
            } catch (SQLException ex) {
                Logger.getLogger(MinigamesCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }

