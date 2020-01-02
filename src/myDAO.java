import org.sql2o.*;
import java.util.List;

public class myDAO {

    private Sql2o sql2o;

    public myDAO() {
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

    public List<Liste> addListe(Liste liste){
      String insertSql =
        "insert into LISTE(ID, TITRE, DESCRIPTION, DATECREATION)" + "values (:ID, :TITRE, :DESCRIPTION, :DATECREATION)";

      try(Connection con = sql2o.open()) {
        con.createQuery(insertSql).addParameter("ID",liste.getId()).addParameter("TITRE",liste.getTitre()).addParameter("DESCRIPTION",liste.getDescription()).addParameter("DATECREATION",liste.getDateCreation()).executeUpdate();
      }
    }





    public List<Liste> getListeElement(){
      String sql =
        "SELECT * from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Element.class);
      }
    }

    public List<Liste> getTitreElement(){
      String sql =
        "SELECT TITRE from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Task.class);
      }
    }

    public List<Liste> getDescriptionElement(){
      String sql =
        "SELECT DESCRIPTION from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Task.class);
      }
    }

    public List<Liste> getIdElement(){
      String sql =
        "SELECT ID from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Task.class);
      }
    }

    public List<Liste> getIdListeElement(){
      String sql =
        "SELECT IDLISTE from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Task.class);
      }
    }

    public List<Liste> getDateCreationElement(){
      String sql =
        "SELECT DATECREATION from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Task.class);
      }
    }



}
