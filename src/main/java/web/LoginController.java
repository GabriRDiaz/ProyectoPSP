/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import database.LoginDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import pojo.Login;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
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
       String mail = request.getParameter("mail");
       String pwd = request.getParameter("pwd");
//       if(!sanitizeFields(mail,pwd)){
//           request.getRequestDispatcher("./index.jsp").forward(request, response);
//            HttpSession session = request.getSession();
//                request.setAttribute("isIncorrect", true);
//                request.getRequestDispatcher("./index.jsp").forward(request, response);
//       }
       LoginDAO login = new LoginDAO(new Login(mail,pwd));
       try {
        if (login.validate()) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
//                response.sendRedirect("loginsuccess.jsp");
                System.out.println("Entra 5");
                request.setAttribute("isIncorrect", false);
//                request.getRequestDispatcher("./games.jsp").forward(request, response);
                response.sendRedirect(request.getContextPath() + "/GamesController");
        } else {
                HttpSession session = request.getSession();
                request.setAttribute("isIncorrect", true);
                request.getRequestDispatcher("./index.jsp").forward(request, response);
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
        }
    } catch (ClassNotFoundException e) {
            e.printStackTrace();
    }
    }

        private boolean sanitizeFields(String mail, String pwd) {
        if(!mail.equals("") || !pwd.equals("")){
            if(mail.contains("@") && mail.contains(".")){
                mail = Jsoup.clean(mail, Whitelist.basic());
                pwd = Jsoup.clean(pwd, Whitelist.basic());
                return true;
            }
        }
        return false;
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
