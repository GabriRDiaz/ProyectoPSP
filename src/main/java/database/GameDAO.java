/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.Game;

/**
 *
 * @author Gabriel
 */
public class GameDAO {
    private final String GAME_QUERY="SELECT * FROM games";

    public GameDAO(){}
    
    public ArrayList<Game> getGames(){
        ArrayList<Game> gameList = new ArrayList<Game>();
		try (Connection connection = DriverManager.getConnection(ConnectionGet.URL, ConnectionGet.USER, ConnectionGet.PWD);
                        PreparedStatement ps = connection.prepareStatement(GAME_QUERY)) {
			ResultSet rs = ps.executeQuery();
                        while(rs.next()){
                            gameList.add(new Game(
                                    rs.getInt("id"),
                                    rs.getString("title"),
                                    rs.getString("genre"),
                                    rs.getInt("id_pegi"),
                                    rs.getDate("release_date"),
                                    rs.getInt("multiplayer"),
                                    rs.getString("img")
                            ));
                        }
		} catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("SQL Error");}
        return gameList;
    }
}
