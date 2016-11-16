package modele;

/**
 *
 * @author Dan-Ghenadie Roman
 */
public class Chercher {

    private String typeAnnonce;
    private String typeAnimal;
    private String sex;
    private int ageMin;
    private int ageMax;

    public String getTypeAnnonce() {
        return typeAnnonce;
    }

    public void setTypeAnnonce(String typeAnnonce) {
        this.typeAnnonce = typeAnnonce;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    @Override
    public String toString() {
        return "Chercher{" + "typeAnnonce=" + typeAnnonce + ", typeAnimal=" + typeAnimal + ", sex=" + sex + ", ageMin=" + ageMin + ", ageMax=" + ageMax + '}';
    }

    
}
