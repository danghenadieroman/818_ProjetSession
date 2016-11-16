/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Annonce;
import modele.Chercher;
import modele.JDBCAnnonceDAO;

/**
 *
 * @author Administrateur
 */
public class ControleurChercherResultat extends HttpServlet {

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

        String destination;
        String requete = "";
        JDBCAnnonceDAO jdbcAnnonceDAO = new JDBCAnnonceDAO();
        jdbcAnnonceDAO.getConnection();

        if (request.getParameter("chercher").equals("button")) {
            
            Chercher chercher = new Chercher();
            chercher.setTypeAnnonce(request.getParameter("radioTypeAnnonce"));
            
            System.out.println("radioTypeAnnonce: " + request.getParameter("radioTypeAnnonce"));
            
            chercher.setTypeAnimal(request.getParameter("radioTypeAnimal"));
            chercher.setSex(request.getParameter("radioSex"));
            chercher.setAgeMin(Integer.parseInt(request.getParameter("ageMin")));
            chercher.setAgeMax(Integer.parseInt(request.getParameter("ageMax")));

            System.out.println("objet chercher: " + chercher);

            //il faut remplir resutlat recherche pour pouvoir afficher dans resutlat_recherche.jsp
            //sinon il va montrer liste vide
            List resultatChercher = jdbcAnnonceDAO.select(chercher);
            if (resultatChercher != null) {
                request.setAttribute("resultatChercher", resultatChercher);
            } else {
                request.setAttribute("resultatChercher", null);
            }
            
            destination = "chercher_resultat.jsp";

        } else {
            destination = "chercher.jsp";
        }

        jdbcAnnonceDAO.closeConnection();
        dispatch(destination, request, response);

    }

    protected void dispatch(String destination, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (destination != null) {
            RequestDispatcher rd = request.getRequestDispatcher(destination);
            rd.forward(request, response);
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
