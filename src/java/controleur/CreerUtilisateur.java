/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.JDBCUtilisateurDAO;
import modele.UserLogin;

/**
 *
 * @author Olena  Lopatyuk
 */
public class CreerUtilisateur extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
  
    }

       protected void erreurMessage(String text,HttpServletResponse response)
            throws ServletException, IOException {
                       response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Attention!</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>"+text+"</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
        }
    
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
        processRequest(request, response);
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
        processRequest(request, response);
        String url = "";
        String login = request.getParameter("usr");
        String pwd1 = request.getParameter("pwd1");
        String pwd2 = request.getParameter("pwd2");
        modele.JDBCUtilisateurDAO users = null ;
        if(pwd1.equals(pwd2)){
           users = new JDBCUtilisateurDAO();
           if(users.getUserId(login) > 0){
               this.erreurMessage("Il y existe l'utilisateur "+login+" .", response);
            } else {
               users.createUser(new UserLogin(-1, login, pwd1));
              
               url = "/compte_profile.jsp";
               ServletContext sc = getServletContext();
               RequestDispatcher rd = sc.getRequestDispatcher(url);
               rd.forward(request, response);
            }  
        }else {
            this.erreurMessage("Les mots de passe ne sont pas égals.", response);
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
