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

    void setDateDerniereModif(Date date){
        this.datedernieremodif=date;
    }

    void setTitre(String titre){
        this.titre=titre;
    }

    void setDescription(String description){
        this.description=description;
    }

    void setId(int id){
        this.id=id;
    }

    void setIdListe(int idListe){
        this.idListe=idListe;
    }

    int getId(){
        return this.id;
    }

    int getIdListe(){
        return this.idListe;
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

    Date getDateDerniereModif(){
        return this.datedernieremodif;
    }

}
