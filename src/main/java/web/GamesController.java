/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import database.GameDAO;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.Game;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "GamesController", urlPatterns = {"/GamesController"})
public class GamesController extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        String action = request.getParameter("action");
        System.out.println(action);
	if(action != null){    
            switch(action){
		case "edit":
                    System.out.println("Edit: "+request.getParameter("gameId"));
                    try{
                    editGameWithId(request, response);
                    loadMainScreen(request, response);
                    }catch(Exception e){e.printStackTrace();}
		    break;
                case "delete":
                    System.out.println("Delete: "+request.getParameter("gameId"));
                    deleteGameWithId(request,response);
                    loadMainScreen(request, response);
		    break;
                case "view":
                    loadGameInfo(request, response,"/WEB-INF/snippets/viewGame.jsp");
                    System.out.println("View");
                    break;
                case "add":
                    System.out.println("Add game");
                    break; 
                case "main":
                    loadMainScreen(request, response);
                    break;
                case "gotoEdit":
                    loadGameInfo(request, response,"/WEB-INF/snippets/editDelete.jsp");
                    break;
               default: 
                    loadMainScreen(request, response);
                    System.out.println("Working");
	    }			
        }else{
            loadMainScreen(request,response);
            System.out.println("Working");
//          this.accionDefault(request,response);
        }
    }
    private void editGameWithId(HttpServletRequest request, HttpServletResponse response)throws ParseException{
        GameDAO gdao = new GameDAO();
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String releaseStr = request.getParameter("release");
        String img = request.getParameter("img");
        String multiplayer = request.getParameter("multiplayer");
        String pegi = request.getParameter("pegi");
        System.out.println("Title: "+title);
        System.out.println("PEGI: "+pegi);
        int isMultiplayer = parseMultiplayer(multiplayer); //Gets "on" OR null
        int id_pegi = parsePegi(pegi); //Gets PEGI-X
        java.sql.Date release = parseDateCustom(releaseStr); //Gets yyyy-mm-dd
        
        gdao.editGameId(Integer.parseInt(request.getParameter("gameId")),title,genre,release,img,isMultiplayer,id_pegi);
    }
    private void deleteGameWithId(HttpServletRequest request, HttpServletResponse response){
        GameDAO gdao = new GameDAO();
        gdao.deleteGameId(Integer.parseInt(request.getParameter("gameId")));
    }
    private ArrayList<Game> getGames(){
       GameDAO gdao = new GameDAO();
       return gdao.getGames();
    }
    private Game getGameWithId(HttpServletRequest request, HttpServletResponse response){
        GameDAO gdao = new GameDAO();
        return gdao.getGameWithId(Integer.parseInt(request.getParameter("gameId")));
    }
    private void loadGameInfo(HttpServletRequest request, HttpServletResponse response,String path) throws IOException, ServletException{
        System.out.println(getGameWithId(request,response).getTitle());
        Game info = getGameWithId(request,response);
        HttpSession session = request.getSession();
        request.setAttribute("id",info.getId());
        request.setAttribute("title",info.getTitle());
        request.setAttribute("genre",info.getGenre());
        request.setAttribute("pegi",parsePegiView(info.getId_pegi()));
        request.setAttribute("release",info.getRelease_date());
        request.setAttribute("multiplayer",parseMultiplayerView(info.getMultiplayer()));
        request.setAttribute("img",info.getImg());
        request.getRequestDispatcher(path).forward(request, response);
    }
    
    private String parseMultiplayerView(int multiplayer){
        if(multiplayer==1){
            return "Yes";
        }else{
            return "No";
        }
    }
     private String parsePegiView(int pegi){
      String value="PEGI-3";
         switch(pegi){
            case 1:
                value="PEGI-3";
                break;
            case 2:
               value="PEGI-7";
                break;
            case 3:
               value="PEGI-12";
                break;
            case 4:
                value="PEGI-16";
                break;
            case 5:
                value="PEGI-18";
                break;
        }
         return value;
     }
     
    private void loadMainScreen(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        getGames().forEach(g->{
            System.out.println(g.getTitle());
        });
        session.setAttribute("games", getGames());
        response.sendRedirect("games.jsp");

   }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         String action = request.getParameter("action");
        System.out.println("Action: "+action);
	if(action != null){    
            switch(action){
		case "edit":
                    System.out.println("Editar");
                    try{
                        editGameWithId(request, response);
                        loadMainScreen(request, response);
                    }catch(Exception e){e.printStackTrace();}
		    break;
                case "delete":
                    System.out.println("Delete: "+request.getParameter("gameId"));
                    deleteGameWithId(request,response);
                    loadMainScreen(request, response);
		    break;
                case "view":
                    loadGameInfo(request, response,"/WEB-INF/snippets/viewGame.jsp");
                    System.out.println("View");
                    break;
                case "add":
                    try {
                        addGame(request, response);
                    } catch (ParseException ex) {
                        Logger.getLogger(GamesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Add game");
                    loadMainScreen(request, response);
                    break; 
 
               default: 
                    loadMainScreen(request, response);
                    System.out.println("Working");
	    }			
        }else{
            loadMainScreen(request,response);
            System.out.println("Working");
//          this.accionDefault(request,response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void addGame(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String releaseStr = request.getParameter("release");
        String img = request.getParameter("img");
        String multiplayer = request.getParameter("multiplayer");
        String pegi = request.getParameter("pegi");
        int isMultiplayer = parseMultiplayer(multiplayer); //Gets "on" OR null
        int id_pegi = parsePegi(pegi); //Gets PEGI-X
        java.sql.Date release = parseDateCustom(releaseStr); //Gets yyyy-mm-dd
        
        GameDAO gDAO = new GameDAO();
        gDAO.addGame(title, genre, release, img, isMultiplayer, id_pegi);
        
        System.err.println("Game info:");
        System.out.println(title);
        System.out.println(genre);
        System.out.println(release);
        System.out.println(img);
        System.out.println(isMultiplayer); //on OR null
        System.out.println(id_pegi);  //PEGI-X
        
        
    }

    private int parseMultiplayer(String multiplayer) {
        System.out.println(multiplayer);
        if(multiplayer == null || multiplayer.isEmpty()){
            return 0;
        }else if(multiplayer.equals("on")){
            return 1;
        }else{
            return 0;
        }
//        if(multiplayer.equals("on")){
//            return 1;
//        }else if(multiplayer.isEmpty() || multiplayer == null){
//            return 0;
//        }else{
//            return 0;
//        }
    }
    private java.sql.Date parseDateCustom(String releaseStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date releaseDate = sdf.parse(releaseStr);
        java.sql.Date sqlRelease = new java.sql.Date(releaseDate.getTime());
        return sqlRelease;
    }

    private int parsePegi(String pegi) {
        int value = 1;
        switch(pegi){
            case "PEGI-3":
                value= 1;
                break;
            case "PEGI-7":
                value= 2;
                break;
            case "PEGI-12":
                value= 3;
                break;
            case "PEGI-16":
                value= 4;
                break;
            case "PEGI-18":
                value= 5;
                break;
        }
        return value;
    }





}
