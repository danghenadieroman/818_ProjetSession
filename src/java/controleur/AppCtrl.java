
package controleur;

import java.util.Date;
import java.util.List;
import modele.Annonce;
import modele.JDBCAnnonceDAO;

/**
 *
 * @author Administrateur
 */
public class AppCtrl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List catalogue = null;

        Annonce annonce = new Annonce();
        annonce.setDate(new Date());
        annonce.setDetails("Test insert details annonce");
        annonce.setImage("images/gallery/cats/cat04.jpg");

        JDBCAnnonceDAO jdbcAnnonceDAO = new JDBCAnnonceDAO();
        jdbcAnnonceDAO.getConnection();
        jdbcAnnonceDAO.insert(annonce);


        jdbcAnnonceDAO.insert(annonce);

        System.out.println("jdbcAnnonceDAO.select()" + jdbcAnnonceDAO.select());
        
        jdbcAnnonceDAO.closeConnection();
    }
    
}
