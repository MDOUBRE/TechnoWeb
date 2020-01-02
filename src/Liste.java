import java.util.List;

public class Liste{
    public int id;
    public String titre;
    private Date datecreation;
    Liste(){
    }

    void setTitre(String titre){
        this.titre=titre;
    }

    String getTitre(){
        return this.titre;
    }

    void setId(int id){
        this.id=id;
    }

    int getId(){
        return this.id;
    }

    Date getDateCreation(){
        return this.datecreation;
    }

    void setDateCreation(Date date){
        this.datecreation=date;
    }
}
