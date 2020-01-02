import java.util.*;

public class Liste{
    public int id;
    public String titre;
    public String description;
    private Date datecreation;
    Liste(){
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return this.id;
    }

    public void setTitre(String titre){
        this.titre=titre;
    }

    public String getTitre(){
        return this.titre;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDateCreation(Date date){
        this.datecreation=date;
    }

    public Date getDateCreation(){
        return this.datecreation;
    }

}
