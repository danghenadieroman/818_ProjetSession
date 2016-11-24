/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.JDBCUtilisateurDAO;
import modele.UserLogin;

/**
 *
 * @author Olena Lopatyuk
 */
public class ConnectUtilisateur extends HttpServlet {

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
        //
        String dest = "";
        
        HttpSession session = request.getSession();
        String source= "";
        
         String login = request.getParameter("usr");
         String pwd = request.getParameter("pwd");
         JDBCUtilisateurDAO users = new JDBCUtilisateurDAO();
         int id = users.checkPassword(login, pwd);
         if(id > -1){
            //
            UserLogin utilisateur = new UserLogin(id, login, pwd);
            session.setAttribute("info", utilisateur);
            if(session.getAttribute("forward_url")!=null){
                dest = (String) session.getAttribute("forward_url");
            } else {
                dest = "default.jsp";
            }
            
//             RequestDispatcher rd = getServletContext().getRequestDispatcher(dest);
//             rd.forward(request, response);
             
              String urlWithSessionID = response.encodeRedirectURL(dest);
              response.sendRedirect( urlWithSessionID );
         } else {
             response.setContentType("text/html;charset=UTF-8");
             try (PrintWriter out = response.getWriter()) {
                 out.println("<!DOCTYPE html>");
                 out.println("<html>");
                 out.println("<head>");
                 out.println("<title>Attention!</title>");            
                 out.println("</head>");
                 out.println("<body>");
                 out.println("<h1>Le nom d'utilisateur ou le mot de passe n'est pas correct!</h1>");
                 out.println("<p><a href='compte_connexion.jsp' />Retour</p>");
                 out.println("</body>");
                 out.println("</html>");
             }
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
