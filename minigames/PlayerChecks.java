/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minigames;

import objects.GameField;
import org.bukkit.block.Block;
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
public class PlayerChecks {

    private static final String adminPerm = "minigames.admins";
    private static boolean permissionsOn = false;

    public static boolean isAdmin(Player player) {

        if (permissionsOn) {
            if (MiniGames.Permissions.has(player, adminPerm)) {
                return true;
            } else {
                return false;
            }
        } else if (player.isOp()) {
            return true;
        } else {
            return false;
        }
    }


    public static void setPermissions(boolean value) {
        permissionsOn = value;
    }
    
    public static int calculateCuboid(Block A , Block B) {
        
        int xsize = Math.abs(A.getX() - B.getX());
        int ysize = Math.abs(A.getY() - B.getY());
        int zsize = Math.abs(A.getZ() - B.getZ());
        
        
        return (xsize+1) * (1+ysize) * (1+zsize);
    }
    
    public static boolean isInGameField(Player player, GameField gf) {
            int x = player.getLocation().getBlockX();
            int y = player.getLocation().getBlockY();
            int z = player.getLocation().getBlockZ();
            int maxX = Math.max(gf.getA().getX(), gf.getB().getX());
            int maxY = Math.max(gf.getA().getY(), gf.getB().getY());
            int maxZ = Math.max(gf.getA().getZ(), gf.getB().getZ());
            int minX = Math.min(gf.getA().getX(), gf.getB().getX());
            int minY = Math.min(gf.getA().getY(), gf.getB().getY());
            int minZ = Math.min(gf.getA().getZ(), gf.getB().getZ());
            
            if(x < maxX && x < minX && y < maxY && y > minY && z < maxZ && z > minZ) {
               return true;
            } else return false;
        
    }
    
}
