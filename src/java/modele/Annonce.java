package modele;

import java.util.Date;

/**
 *
 * @author Dan-Ghenadie Roman
 */
public class Annonce {

    private int id;
    private String typeAnnonce;
    private String typeAnimal;
    private String sex;
    private int age;
    private Date date;
    private String details;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        return "Annonce{" + "id=" + id + ", typeAnnonce=" + typeAnnonce + ", typeAnimal=" + typeAnimal + ", sex=" + sex + ", age=" + age + ", date=" + date + ", details=" + details + ", image=" + image + '}';
    }
    
    
}
