/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectors;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import minigames.DbConnect;
import minigames.MinigamesCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

/**
 *
 * @author Fran
 */
public class PlayerDAO {
    
    public static void getPlayers() {
        
    }
    
    public static void addPlayer(Player player) {
        try {
            //Save The Inventory (name, lvl, exp, invSaved);"
            PlayerInventory inv = player.getInventory();
            PreparedStatement prep = DbConnect.getConn().prepareStatement("insert into player(name,invSaved) values (?, ? );");
                       prep.setString(1, player.getName());
                        prep.setBoolean(2, false);
                        prep.addBatch();

   
            DbConnect.getConn().setAutoCommit(false);
            prep.executeBatch();
            DbConnect.getConn().setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(MinigamesCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
        public static void saveInventory(Player player) {
        try {
            //Save The Inventory
            PlayerInventory inv = player.getInventory();
            PreparedStatement prep = DbConnect.getConn().prepareStatement("insert into item values (?, ?, ? , ? , ?);");
            for (ItemStack item : inv.getContents()) {

                try {
                    if (item != null) {
                        prep.setString(1, player.getName());
                        prep.setInt(2, item.getTypeId());
                        prep.setString(3, item.getType().toString());
                        prep.setInt(4, item.getAmount());
                        prep.setShort(5, item.getDurability());

                        prep.addBatch();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MinigamesCommand.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            DbConnect.getConn().setAutoCommit(false);
            prep.executeBatch();
            DbConnect.getConn().setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(MinigamesCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void restoreInventory(Player player) {
        try {
            //Save The Inventory
            PreparedStatement prep = DbConnect.getConn().prepareStatement("select * from item where owner = ? ;");
            prep.setString(1, player.getName());
            ResultSet rs = prep.executeQuery();
            
            cleanInventory(player);
            while (rs.next()) {

                ItemStack item = new ItemStack(rs.getInt("itemId"), rs.getInt("amount"), rs.getShort("durability"));
                player.getInventory().addItem(item);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MinigamesCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
   
    
    public static void cleanInventory(Player player) {
        player.getInventory().clear();
    }

}
