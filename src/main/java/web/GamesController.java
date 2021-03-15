/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import database.GameDAO;
import java.io.IOException;
import java.util.ArrayList;
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
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
	if(action != null){    
            switch(action){
		case "edit":
                    System.out.println("Editar");
		    break;
                case "delete":
                    System.out.println("Borrar");                    
		    break;
                case "view":
                    loadGameInfo(request, response);
                    System.out.println("View");
                    break;
                case "add":
                    System.out.println("Add game");
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
    private ArrayList<Game> getGames(){
       GameDAO gdao = new GameDAO();
       return gdao.getGames();
    }
    private Game getGameWithId(HttpServletRequest request, HttpServletResponse response){
        GameDAO gdao = new GameDAO();
        return gdao.getGameWithId(Integer.parseInt(request.getParameter("gameId")));
    }
    private void loadGameInfo(HttpServletRequest request, HttpServletResponse response){
        System.out.println(getGameWithId(request,response).getTitle());
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getParameter("action");
        System.out.println(action);
	if(action != null){    
            switch(action){
		case "edit":
                    System.out.println("Editar");
		    break;
                case "delete":
                    System.out.println("Borrar");                    
		    break;
                case "view":
                    loadGameInfo(request, response);
                    System.out.println("View");
                    break;
                case "add":
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



}
