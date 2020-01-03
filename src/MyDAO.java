import org.sql2o.*;
import java.util.List;

public class MyDAO {

    private Sql2o sql2o;

    public MyDAO() {
        this.sql2o = new Sql2o("jdbc:h2:~/bddtest", "nicolas", "nicolas");
    }

    public List<Liste> getListeListe(){
      String sql =
        "SELECT * from LISTE;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Liste.class);
      }
    }

    public List<Liste> getTitreListe(){
      String sql =
        "SELECT TITRE from LISTE;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Liste.class);
      }
    }

    public List<Liste> getDescriptionListe(){
      String sql =
        "SELECT DESCRIPTION from LISTE;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Liste.class);
      }
    }

    public List<Liste> getIdListe(){
      String sql =
        "SELECT ID from LISTE;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Liste.class);
      }
    }

    public void addListe(Liste liste){
      String insertSql =
        "insert into LISTE(ID, TITRE, DESCRIPTION, DATECREATION)" + "values (:ID, :TITRE, :DESCRIPTION, :DATECREATION)";

      try(Connection con = sql2o.open()) {
        con.createQuery(insertSql)
          .addParameter("ID",liste.getId())
          .addParameter("TITRE",liste.getTitre())
          .addParameter("DESCRIPTION",liste.getDescription())
          .addParameter("DATECREATION",liste.getDateCreation())
          .executeUpdate();
      }
    }


    public List<Element> getListeElement(){
      String sql =
        "SELECT * from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Element.class);
      }
    }

    public List<Element> getTitreElement(){
      String sql =
        "SELECT TITRE from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Element.class);
      }
    }

    public List<Element> getDescriptionElement(){
      String sql =
        "SELECT DESCRIPTION from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Element.class);
      }
    }

    public List<Element> getIdElement(){
      String sql =
        "SELECT ID from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Element.class);
      }
    }

    public List<Element> getIdListeElement(){
      String sql =
        "SELECT IDLISTE from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Element.class);
      }
    }

    public List<Element> getDateCreationElement(){
      String sql =
        "SELECT DATECREATION from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Element.class);
      }
    }

    public void addElement(Element element){
      String insertSql =
        "insert into ELEMENT(ID, IDLISTE, TITRE, DESCRIPTION, DATECREATION)" + "values (:ID, :IDLISTE, :TITRE, :DESCRIPTION, :DATECREATION)";

      try(Connection con = sql2o.open()) {
        con.createQuery(insertSql)
          .addParameter("ID",element.getId())
          .addParameter("IDLISTE",element.getIdListe())
          .addParameter("TITRE",element.getTitre())
          .addParameter("DESCRIPTION",element.getDescription())
          .addParameter("DATECREATION",element.getDateCreation())
          .executeUpdate();
      }
    }


}
