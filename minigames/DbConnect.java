package minigames;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran
 */
public class DbConnect {

    private static Connection conn;

    public static Connection getConn() {
        return conn;
    }

    public static void connect() {
        try {

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:minigames.db");

            if (Config.isInitDB()) {
                initDb();
            }
//           stat.executeUpdate("create table people (name, occupation);");
//           PreparedStatement prep = conn.prepareStatement(
//           "insert into people values (?, ?);");
//
//           prep.setString(1, "Gandhi");
//           prep.setString(2, "politics");
//           prep.addBatch();
//           prep.setString(1, "Turing");
//           prep.setString(2, "computers");
//           prep.addBatch();
//           prep.setString(1, "Wittgenstein");
//           prep.setString(2, "smartypants");
//           prep.addBatch();
//
//           conn.setAutoCommit(false);
//           prep.executeBatch();
//           conn.setAutoCommit(true);
//
//           ResultSet rs = stat.executeQuery("select * from inventory;");
//           while (rs.next()) {
//               System.out.println("name = " + rs.getString("name"));
//           }
//           rs.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void initDb() {
        try {
            Statement stat = conn.createStatement();

            stat.executeUpdate("drop table if exists game;");
            stat.executeUpdate( "CREATE TABLE game (id INTEGER PRIMARY KEY,type TEXT NOT NULL, winner TEXT); ");
            

            stat.executeUpdate("drop table if exists gameplayer;");
            stat.executeUpdate("create table gameplayer (game_id,player_name,position,expGained);");

            stat.executeUpdate("drop table if exists player;");
            stat.executeUpdate("create table player (name, lvl, exp, invSaved);");

            stat.executeUpdate("drop table if exists item;");
            stat.executeUpdate("create table item (owner, itemId, name ,amount, durability);");
            
            stat.executeUpdate("drop table if exists gamefield;");
            stat.executeUpdate("create table gamefield (name, blockA, blockB ,type);");


        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String args[]) {
        connect();
    }
}
