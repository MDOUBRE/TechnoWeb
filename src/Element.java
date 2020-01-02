import java.util.*;

public class Element{
    public int idListe;
    public int id;
    public String titre;
    public String description;
    private Date datecreation;
    private Date datedernieremodif;

    Element(){
    }

    void setIdListe(int idListe){
        this.idListe=idListe;
    }

    int getIdListe(){
        return this.idListe;
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

    void setDateDerniereModif(Date date){
        this.datedernieremodif=date;
    }

    Date getDateDerniereModif(){
        return this.datedernieremodif;
    }

}
