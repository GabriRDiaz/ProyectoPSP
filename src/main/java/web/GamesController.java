/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import database.GameDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
        String accion = request.getParameter("action");
	if(accion != null){    
            switch(accion){
		case "edit":
                    System.out.println("Editar");
//                    this.editarCliente(request, response);
		    break;
                case "delete":
                    System.out.println("Borrar");
//                    this.eliminarCliente(request, response);
		    break;    
                default: 
                    loadMainScreen(request, response);
                    System.out.println("Working");
//                    this.accionDefault(request,response);
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
        loadMainScreen(request, response);
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
