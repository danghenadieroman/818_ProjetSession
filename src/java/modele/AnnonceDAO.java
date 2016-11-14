package modele;

import java.util.List;

/**
 *
 * @author Dan-Ghenadie Roman
 */
public interface AnnonceDAO {

    public void insert(Annonce anonce);
    public List<Annonce> select();

}
