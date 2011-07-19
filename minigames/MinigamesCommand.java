package minigames;

import connectors.GameDAO;
import connectors.GameFieldDAO;
import connectors.PlayerDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.server.EntityPlayer;
import objects.Game;
import objects.GameField;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * FireLord 0.4
 * Copyright (C) 2011 W4rGo , Francisco Ruiz Valdes <franrv@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
public class MinigamesCommand implements CommandExecutor {

    public static final Logger log = Logger.getLogger("Minecraft");
    public static MiniGames plugin = null;

    MinigamesCommand(MiniGames mg) {
        plugin = mg;
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        String[] split = strings;
        //objects.Player player = new objects.Player(plugin.getServer(), (EntityPlayer) cs, string);
        Player player = (Player) cs;
        if (!PlayerChecks.isAdmin((Player) cs)) {
            return false;
        }


        if (split.length > 0) {

            if (split[0].equalsIgnoreCase("gamefield")) {
                if (split.length > 4) {
                    if (split[1].equalsIgnoreCase("new")) {

                        if (PlayerChecks.isAdmin(player)) {
                            if (Status.getSelectedBlock1() != null && Status.getSelectedBlock2() != null) {
                                String name = split[2];
                                String type = split[3];
                                //create new gamefield with that name.
                                GameField gf = new GameField(name, Status.getSelectedBlock1(), Status.getSelectedBlock2(), type);
                                Status.getGameFields().put(name, gf);
                                GameFieldDAO.saveGameField(gf);
                            } else {

                                player.sendMessage("MiniGames: You must select a region first with the wand (/minigames wand");
                            }
                        } else {
                            player.sendMessage("MiniGames: You are not allowed to perform that command");
                        }
                    }
                } else {
                    player.sendMessage("MiniGames: /minigames gamefield new [name] [type]");
                }

                player.sendMessage(ChatColor.RED + "Inventory Saved");
            }
            if (split[0].equalsIgnoreCase("save")) {

                PlayerDAO.saveInventory(player);
                player.sendMessage(ChatColor.RED + "Inventory Saved");


            }
            if (split[0].equalsIgnoreCase("game")) {
                if (split.length > 4) {
                    if (split[1].equalsIgnoreCase("new")) {
                        try {
                            
                            String type = split[2];
                            String gamefield = split[3];
                            //if(PlayerChecks.isAdmin(player)) {
                            int id = GameDAO.countGames() + 1;                            
                            Game game = new Game(id, type, gamefield);
                            GameField gf = Status.getGameFields().get(gamefield);
                            
                            if(gf.isGameInCourse()) {
                                player.sendMessage("MiniGames: A game is already in course in that gamefield");
                            } else if(!gf.getType().equalsIgnoreCase(type)) {
                                player.sendMessage("MiniGames: The gamefield support the type : "+ gf.getType() +" not " + type );
                            } else {
                                gf.setCurrentGame(game);
                                Status.getGames().put(id, game);
                                GameDAO.saveGame(game);
                                player.sendMessage("MiniGames: Game of " + type + " created in " + gamefield);
                            }
                            
                            //} else player.sendMessage("MiniGames: You are not allowed to perform that command");
                        } catch (SQLException ex) {
                            Logger.getLogger(MinigamesCommand.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    player.sendMessage("MiniGames: /minigames game new [type] [gamefield]");
                }
            }



//PLAYER JOIN GAME            
            if (split[0].equalsIgnoreCase("join")) {
                if (split.length > 2) {
                    //int id = Integer.valueOf(split[1]);
                    String gamefield = split[1];
                    GameField gf =Status.getGameFields().get(gamefield); 
                    gf.getCurrentGame().getPlayers().put(player.getName(), player );
                    
                    
                } else {
                    player.sendMessage("Minigames: /minigames join [gameId]|[gameType]");
                }
            } else if (split[0].equalsIgnoreCase("restore")) {

                //Restore The Inventory

                PlayerDAO.restoreInventory(player);

                player.sendMessage(ChatColor.RED + "Inventory Restored");
            } else if (split[0].equalsIgnoreCase("clean")) {
                //delete the inventory

                PlayerDAO.cleanInventory(player);

            } else if (split[0].equalsIgnoreCase("status")) {
                player.sendMessage(ChatColor.RED + "############################");
                player.sendMessage(ChatColor.RED + "# MINIGAMES FEATURES STATUS #");
                player.sendMessage(ChatColor.RED + "############################");
                player.sendMessage(ChatColor.RED + "");
//                    player.sendMessage( ChatColor.RED +  "  Fire shovel = " + Config.isFireShovel());
                player.sendMessage(ChatColor.RED + "");
                player.sendMessage(ChatColor.RED + "############################");
                //player.sendMessage( ChatColor.RED + "Write on / off");
            }
        } else {
            //Commands explanation
            player.sendMessage(ChatColor.RED + "############################");
            player.sendMessage(ChatColor.RED + "# MINIGAMES COMMANDS BRIEF  #");
            player.sendMessage(ChatColor.RED + "############################");
            player.sendMessage(ChatColor.RED + "");
            player.sendMessage(ChatColor.RED + "  /inventory save");
            player.sendMessage(ChatColor.RED + "  /inventory restore");
            player.sendMessage(ChatColor.RED + "  /inventory delete");
            player.sendMessage(ChatColor.RED + "");
            player.sendMessage(ChatColor.RED + "############################");
        }

        return true;
    }
}
