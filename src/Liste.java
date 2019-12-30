public class Liste{
    public String titre;
    public String description;
    private Element tabElement[];
    private int i;

    Liste(){
    }

    void ajouteElement(Element elem){
        this.tabElement[this.i]=elem;
        this.i=this.i+1;
    }

    void supprimeElement(Element elem){
        this.tabElement[this.i]=elem;
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

    String getDescription(){
        return this.description;
    }

}