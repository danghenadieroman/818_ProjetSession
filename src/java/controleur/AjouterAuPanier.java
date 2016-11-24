/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Annonce;
import modele.JDBCAnnonceDAO;

/**
 *
 * @author Olena Lopatyuk
 */
public class AjouterAuPanier extends HttpServlet {

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

        HttpSession session = request.getSession();
        ArrayList<Annonce> panierList = (ArrayList<Annonce>) session.getAttribute("panier");
        if (panierList == null) {
            panierList = new ArrayList<Annonce>();
            session.setAttribute("panier", panierList);
        }
        
         JDBCAnnonceDAO jdbcAnnonceDAO = new JDBCAnnonceDAO();
        jdbcAnnonceDAO.getConnection();
        String id =  request.getParameter("id");
        List<Annonce> annonces = jdbcAnnonceDAO.selectByID( id);
        jdbcAnnonceDAO.closeConnection();
        
        if(!panierList.contains(annonces.get(0))) panierList.add(annonces.get(0));
        redirect("ControleurIndex", response);
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

    private void redirect(
            String dest, HttpServletResponse response
    ) throws IOException {
        String urlWithSessionID = response.encodeRedirectURL(dest);
        response.sendRedirect(urlWithSessionID);
    }
}
