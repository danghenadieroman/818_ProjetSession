
package modele;

import java.util.Date;

/**
 *
 * @author Dan-Ghenadie Roman
 */
public class Annonce {
    
    private String nom;
    private Date date;
    private String details;
    private String image;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Annonce{" + "nom=" + nom + ", date=" + date + ", details=" + details + ", image=" + image + '}';
    }
    
}
