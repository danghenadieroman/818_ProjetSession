package ressources_i18n;

import java.util.ListResourceBundle;

/**
 *
 * @author Dan-Ghenadie Roman
 */
public class Messages_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
        {"message.principale", "Home"},
        {"message.annonces", "Announcement"},
        {"message.publier", "Publish"},
        {"message.afficher", "Display"},
        {"message.compte", "Account"},
        {"message.creerCompte", "Create account"},
        {"message.connexion", "Connection"},
        {"message.monProfile", "My profile"},
        {"message.panier", "Cart"},
        {"message.ajouterPanier", "Add to cart"},
        {"message.chercher", "Search"},
        {"message.francais", "French"},
        {"message.anglais", "English"},
        {"message.rechercheDetaile", "Advanced search"},
        {"message.resultatChercher", "Search results"},
        {"message.publierVotreAnnonce", "Publishing your announce"},
        {"message.mesAnnonces", "My announces"},
        {"message.typeAnnonce", "Type of annonce"},
        {"message.adopter", "Adopte"},
        {"message.donner", "Donate"},
        {"message.typeAnimal", "Type of animal"},
        {"message.chien", "Dog"},
        {"message.chat", "Cat"},
        {"message.poisson", "Fish"},
        {"message.peroquet", "Peroquet"},
        {"message.hammster", "Hammster"},
        {"message.serpent", "Snake"},
        {"message.autre", "Other"},
        {"message.sex", "Sex"},
        {"message.masculin", "Male"},
        {"message.feminin", "Female"},
        {"message.a", "to"},
        {"message.age", "Age"},
        {"message.photo", "Photo"},
        {"message.image", "Picture"},
        {"message.choisissezUnePhoto", "Choose the picture"},
        {"message.detailAnnonce", "Announce details"},
        {"message.catalogueVide", "The catalogue is empty"},
        {"message.adresse", "Addresse"},
        {"message.contacts", "Contacts"},
        {"message.clavardage", "Chat"},
        {"message.sauvegarder", "Save"},
        {"message.creer", "Create"},
        {"message.modifier", "Modify"},
        {"message.supprimer", "Delete"},
        {"message.confirmation", "Confirm"},
        {"message.nomUtilisateur", "User name"},
        {"message.motDePasse", "Password"},
        {"message.nom", "Name"},
        {"message.prenom", "Surname"},
        {"message.couriel", "E-mail"},
        {"message.codePostale", "Postal code"},
        {"message.telephone", "Phone"},
        {"message.motDePasseChanger", "Change password"},
        {"message.telechargerPhoto", "Upload the photo"}
    };

}
