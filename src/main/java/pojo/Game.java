/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;
import java.util.Date;
/**
 *
 * @author Gabriel
 */
public class Game {
    private int id;
    private String title;
    private String genre;
    private int id_pegi;
    private Date release_date;
    private int multiplayer;
    private String img;

    public Game(int id, String title, String genre, int id_pegi, Date release_date, int multiplayer, String img) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.id_pegi = id_pegi;
        this.release_date = release_date;
        this.multiplayer = multiplayer;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getId_pegi() {
        return id_pegi;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public int getMultiplayer() {
        return multiplayer;
    }

    public String getImg() {
        return img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setId_pegi(int id_pegi) {
        this.id_pegi = id_pegi;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public void setMultiplayer(int multiplayer) {
        this.multiplayer = multiplayer;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
