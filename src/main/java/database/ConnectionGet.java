/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Gabriel
 */
public class ConnectionGet {
    public final static String URL="jdbc:mysql://localhost:3306/psp_games?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Madrid";
    public final static String USER="root";
    public final static String PWD="abc123.";

    public static String getURL() {
        return URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPWD() {
        return PWD;
    }
    
}
