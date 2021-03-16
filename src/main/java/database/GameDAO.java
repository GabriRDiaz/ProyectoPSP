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
    private final String GAME_ID_QUERY="SELECT * FROM games WHERE id=?";
    private final String INSERT_GAME="INSERT INTO games(title,genre,release_date,img,id_pegi,multiplayer) VALUES(?,?,?,?,?,?)";
    private final String DELETE_GAME="DELETE FROM games WHERE id=?";
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
    public Game getGameWithId(int id){
        Game game = null;
        try (Connection connection = DriverManager.getConnection(ConnectionGet.URL, ConnectionGet.USER, ConnectionGet.PWD);
                        PreparedStatement ps = connection.prepareStatement(GAME_ID_QUERY)) {
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                game = new Game(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("genre"),
                rs.getInt("id_pegi"),
                rs.getDate("release_date"),
                rs.getInt("multiplayer"),
                rs.getString("img")
                );
            }
        }catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("SQL Error");}
        return game;
    }
    
    public void addGame(String title, String genre, java.sql.Date release, String img, int isMultiplayer, int id_pegi ){
        try (Connection connection = DriverManager.getConnection(ConnectionGet.URL, ConnectionGet.USER, ConnectionGet.PWD);
                        PreparedStatement ps = connection.prepareStatement(INSERT_GAME)) {
                                    ps.setString(1, title);
                                    ps.setString(2, genre);
                                    ps.setDate(3,release);
                                    ps.setString(4,img);
                                    ps.setInt(5, id_pegi);
                                    ps.setInt(6, isMultiplayer);
                                    ps.executeUpdate();
                                    System.out.println(title+" added succesfully");
		} catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("SQL Error");}
    }
    public void deleteGameId(Integer id){
         try (Connection connection = DriverManager.getConnection(ConnectionGet.URL, ConnectionGet.USER, ConnectionGet.PWD);
                        PreparedStatement ps = connection.prepareStatement(DELETE_GAME)) {
                                    ps.setInt(1, id);
                                    ps.executeUpdate();
		} catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("SQL Error");}
    }
}
