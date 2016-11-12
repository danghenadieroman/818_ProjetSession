package ressources_i18n;

import java.util.ListResourceBundle;

/**
 *
 * @author 1395945
 */
public class Messages extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
        {"message.principale", "Principale1"},
        {"message.annonces", "Annonces"},
        {"message.publier", "Publier"},
        {"message.afficher", "Afficher"},
        {"message.compte", "Compte"},
        {"message.creerCompte", "Creer compte"},
        {"message.conexion", "Connexion"},
        {"message.nomProfile", "Mon profile"},
        {"message.chercher", "Chercher"},
        {"message.francais", "Français"},
        {"message.anglais", "Anglais"},
        {"message.typeAnnonce", "Type annonce"},
        {"message.adopter", "Adopter1"},
        {"message.donner", "Donner"},
        {"message.typeAnimal", "Type animal"},
        {"message.chien", "Chien"},
        {"message.chat", "Chat"},
        {"message.poisson", "poisson"},
        {"message.peroquet", "Peroquet"},
        {"message.hammster", "hammster"},
        {"message.serpent", "Serpent"},
        {"message.sex", "Sex"},
        {"message.age", "Age"},
        {"message.photo", "Photo"},
        {"message.choisissezUnePhoto", "Choisissez une photo"},
        {"message.adresse", "Adresse"},
        {"message.contacts", "Contacts"},
        {"message.clavardage", "Clavardage"},
        {"message.sauvegarder", "Sauvegarder"},
        {"message.creer", "Créer"},
        {"message.modifier", "Modifier"},
        {"message.supprimer", "Supprimer"},
        {"message.confirmation", "Confirmation"},
        {"message.nomUtilisateur", "Nom utilisateur"},
        {"message.motDePasse", "Mot de passe"},
        {"message.nom", "Nom"},
        {"message.prenom", "Prenom"},
        {"message.couriel", "Couriel"},
        {"message.codePostale", "Code postale"},
        {"message.telephone", "Téléphone"}
    };
}
