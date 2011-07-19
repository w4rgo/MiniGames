/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minigames;

import java.util.HashMap;
import objects.Game;
import objects.GameField;
import org.bukkit.block.Block;

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
public class Status {
    private static Block selectedBlock1;
    private static Block selectedBlock2;
    private static HashMap<String, GameField> gameFields= new HashMap<String,GameField>();
    private static HashMap<Integer, Game> games= new HashMap<Integer,Game>();

    public static HashMap<String, GameField> getGameFields() {
        return gameFields;
    }

    public static void setGameFields(HashMap<String, GameField> gameFields) {
        Status.gameFields = gameFields;
    }
              
    
    public static int calculateCuboid(Block A , Block B) {
        
        int xsize = Math.abs(A.getX() - B.getX());
        int ysize = Math.abs(A.getY() - B.getY());
        int zsize = Math.abs(A.getZ() - B.getZ());
        
        
        return (xsize+1) * (1+ysize) * (1+zsize);
    }

    public static HashMap<Integer, Game> getGames() {
        return games;
    }

    public static void setGames(HashMap<Integer, Game> games) {
        Status.games = games;
    }
    
        public static Block getSelectedBlock1() {
        return selectedBlock1; 
    }

    public static Block getSelectedBlock2() {
        return selectedBlock2;
    }

    public static void setSelectedBlock2(Block selectedBlock2) {
        Status.selectedBlock2 = selectedBlock2;
    }

    public static void setSelectedBlock1(Block selectedBlock1) {
        Status.selectedBlock1 = selectedBlock1;
    }
}
