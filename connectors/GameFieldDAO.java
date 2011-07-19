package connectors;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import minigames.DbConnect;
import minigames.MinigamesCommand;
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
public class GameFieldDAO {
        public static void saveGameField(GameField gf) {
            try {
                //Save The Inventory
                PreparedStatement prep = DbConnect.getConn().prepareStatement("nsert into gamefield values (?, ?, ? , ?);");
                prep.setString(1, gf.getGameFieldName());
                prep.setObject(2, gf.getA());
                prep.setObject(3, gf.getB());
                prep.setString(4, gf.getType());

                prep.executeBatch();
            } catch (SQLException ex) {
                Logger.getLogger(MinigamesCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public static HashMap<String,GameField> loadGameFields() {
        try {
            //Save The Inventory
            HashMap<String,GameField> gamefields = new HashMap<String,GameField>();
            PreparedStatement prep = DbConnect.getConn().prepareStatement("select * from gamefield;");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                gamefields.put(rs.getString("name"), new GameField(rs.getString("name"),(Block) rs.getObject("blockA"),(Block)rs.getObject("blockB"),rs.getString("type")));
            }
            prep.executeBatch();
            return gamefields;
            
        } catch (SQLException ex) {
            Logger.getLogger(MinigamesCommand.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
