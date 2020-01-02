import java.util.*;

public class Liste{
    public int id;
    public String titre;
    public String description;
    private Date datecreation;
    Liste(){
    }

    void setId(int id){
        this.id=id;
    }

    int getId(){
        return this.id;
    }

    void setTitre(String titre){
        this.titre=titre;
    }

    String getTitre(){
        return this.titre;
    }

    void setDescription(String description){
        this.description=description;
    }

    String getDescription(){
        return this.description;
    }

    void setDateCreation(Date date){
        this.datecreation=date;
    }

    Date getDateCreation(){
        return this.datecreation;
    }

}
