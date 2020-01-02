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

    public void setIdListe(int idListe){
        this.idListe=idListe;
    }

    public int getIdListe(){
        return this.idListe;
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

    public void setDateDerniereModif(Date date){
        this.datedernieremodif=date;
    }

    public Date getDateDerniereModif(){
        return this.datedernieremodif;
    }

}
