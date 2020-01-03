import java.util.*;

public class Liste{
    private int id;
    private String titre;
    private String description;
    private Date datecreation;

    public Liste(){
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

    @Override
    public String toString(){
      return "Element : " + this.getId() + " desc : " + this.getDescription();
    }
}