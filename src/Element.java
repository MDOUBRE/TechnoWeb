import java.util.*;

public class Element{
    public String titre;
    public String description;
    private Date datecreation;
    private Date datedernieremodif;

    Element(){
    }

    void setDateDerniereModif(Date date){
        this.datedernieremodif=date;
    }

    void setTitre(String titre){
        this.titre=titre;
    }

    void setDescription(String description){
        this.description=description;
    }

    String getTitre(){
        return this.titre;
    }

    Date getDateCreation(){
        return this.datecreation;
    }
    
    String getDescription(){
        return this.description;
    }

}
