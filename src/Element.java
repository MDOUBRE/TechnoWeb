import java.util.*;

public class Element{
    private int idListe;
    private int id;
    private String statut;
    private String titre;
    private String description;
    private Date datecreation;
    private Date datedernieremodif;

    public Element(){
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

    public void setStatut(String statut){
        this.statut=statut;
    }

    public String getStatut(){
        return this.statut;
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

    public String getName(){
      return "element";
    }

    @Override
    public String toString(){
      return "Element : " + this.getId() + " desc : " + this.getDescription();
    }

}
