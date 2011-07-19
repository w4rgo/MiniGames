/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minigames;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.nijiko.permissions.PermissionHandler;
import java.io.File;
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
public class Config {

    public static PermissionHandler Permissions;
    private static String configPath = "plugins/MiniGames/config.properties";
    private static String configFile = "config.properties";
    private static boolean initDB = true;
    private
            static int getWandId = 290;
    private static Block selectedBlock1;
    private static Block selectedBlock2;
    public static boolean isInitDB() {
        return initDB;
    }

    public static void setInitDB(boolean initDB) {
        Config.initDB = initDB;
    }

    public static int getGetWandId() {
        return getWandId;
    }

    public static void setGetWandId(int getWandId) {
        Config.getWandId = getWandId;
    }


    private static Properties config;
    private static FileInputStream fi;


    private static boolean boolValue(String value) {
        if (value.equalsIgnoreCase("true")) {
            return true;
        } else if (value.equalsIgnoreCase("false")) {
            return false;
        } else {
            return false;
        }
    }

    public static void loadConfig(File filePath) throws IOException {
//        boolean changed = false;
//        configPath = filePath.toString() + File.separator + configFile;
//        config = new Properties();
//        try {
//            fi = new FileInputStream(Config.configPath);
//
//            config.load(fi);
//        } catch (FileNotFoundException e) {
//            File f = new File(configPath);
//            f.createNewFile();
//            fi = new FileInputStream(Config.configPath);
//        }
//
//
////        if (config.getProperty("fireReflectDuration") != null) {
////            fireReflectDuration = Integer.valueOf(config.getProperty("fireReflectDuration")) * 20;
////        } else {
////            config.setProperty("fireReflectDuration", String.valueOf(fireReflectDuration));
////            changed = true;
////        }
////        
//   
//
//        if (changed) {
//            FileOutputStream fo = new FileOutputStream(configPath);
//            config.store(fo, configPath);
//            fo.close();
//        }

    }



}
