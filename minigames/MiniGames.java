/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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


package minigames;


import listeners.AdminListener;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author franrv
 *

 */
public class MiniGames extends JavaPlugin{
    public static PermissionHandler Permissions;
    private AdminListener adminListener = new AdminListener(this);
    private String name = "MiniGames";
    private String version = "0.1";
    public static final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onDisable() {
            log.log(Level.INFO, "{0} version {1} disabled", new Object[]{name, version});
            DbConnect.disconnect();
    }
    private void setupPermissions() {
      Plugin test = this.getServer().getPluginManager().getPlugin("Permissions");

      if (Permissions == null) {
          if (test != null) {
              Permissions = ((Permissions)test).getHandler();
              PlayerChecks.setPermissions(true);
              log.log(Level.INFO, "{0} {1} using Permissions system", new Object[]{name, version});
          } else {
              PlayerChecks.setPermissions(false);
              log.info("Permission system not detected, default to everybody! and admin commands for OP");
          }
      }
  }
    @Override
    public void onEnable() {
            //Config.loadConfig(this.getDataFolder());
            //setupPermissions();
            DbConnect.connect();
            log.log(Level.INFO, "{0} version {1} enabled!", new Object[]{name, version});
            getCommand("inventory").setExecutor(new MinigamesCommand(this));
            //this.getServer().broadcastMessage("MiniGames Loaded"); 
            getServer().getPluginManager().registerEvent(Event.Type.PLAYER_INTERACT, adminListener, Priority.Normal, this);
//            getServer().getPluginManager().registerEvent(Event.Type.ENTITY_DEATH, dmgListener, Priority.Normal, this);
//            getServer().getPluginManager().registerEvent(Event.Type.PLAYER_MOVE, moveListener, Priority.Normal, this);
//            getServer().getPluginManager().registerEvent(Event.Type.BLOCK_BREAK, blockListener,Priority.Normal, this);

    	    //getServer().getPluginManager().registerEvent(Event.Type.PLAYER_EGG_THROW, eggListener,Priority.Normal, this);
           // setupPermissions();
            
            
    }

}
