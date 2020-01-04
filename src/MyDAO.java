import org.sql2o.*;
import java.util.List;
import java.util.Date;

public class MyDAO {

    private Sql2o sql2o;

    public MyDAO() {
        this.sql2o = new Sql2o("jdbc:h2:~/bddtest2", "maxime", "maxime");
    }

    public void supprimerTable(){
      String sql =
              "DROP TABLE LISTE;";
      try(Connection con = sql2o.open()) {
        con.createQuery(sql).executeUpdate();
      }
      sql =
              "DROP TABLE ELEMENT;";
      try(Connection con = sql2o.open()) {
        con.createQuery(sql).executeUpdate();
      }
    }

    public void creerTable(){
      String sql =
              "DROP TABLE LISTE IF EXISTS;";
      try(Connection con = sql2o.open()) {
        con.createQuery(sql).executeUpdate();
      }

      sql =
              "DROP TABLE ELEMENT IF EXISTS;";
      try(Connection con = sql2o.open()) {
        con.createQuery(sql).executeUpdate();
      }

      sql =
              "CREATE TABLE LISTE(id integer primary key AUTO_INCREMENT,titre varchar(50),description varchar(50),datecreation date);";
      try(Connection con = sql2o.open()) {
        con.createQuery(sql, "creerTable").executeUpdate();
      }

      sql = "create table Element (id integer primary key AUTO_INCREMENT,idListe integer,statut integer,titre varchar(255),description varchar(255),datecreation date,datedernieremodif date,foreign key (idListe) references Liste(ID));";
      try(Connection con = sql2o.open()) {
        con.createQuery(sql, "creerTable").executeUpdate();
      }

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
        "insert into LISTE(TITRE, DESCRIPTION, DATECREATION)" + "values (:TITRE, :DESCRIPTION, :DATECREATION)";

      try(Connection con = sql2o.open()) {
        con.createQuery(insertSql, true)
          .addParameter("TITRE",liste.getTitre())
          .addParameter("DESCRIPTION",liste.getDescription())
          .addParameter("DATECREATION",new Date(System.currentTimeMillis()))
          .executeUpdate()
          .getKey();
      }
    }

    public void deleteListe(int id){
      String deleteListeSql =
        "DELETE FROM LISTE WHERE ID=:id;";
      String deleteElementListeSql =
        "DELETE FROM ELEMENT WHERE IDLISTE=:id;";

      try(Connection con = sql2o.open()) {
        con.createQuery(deleteElementListeSql, true).addParameter("id",id).executeUpdate();
        con.createQuery(deleteListeSql, true).addParameter("id",id).executeUpdate();
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
        "insert into ELEMENT(IDLISTE, STATUT, TITRE, DESCRIPTION, DATECREATION)" + "values (:IDLISTE, :STATUT, :TITRE, :DESCRIPTION, :DATECREATION)";

      try(Connection con = sql2o.open()) {
        con.createQuery(insertSql, true)
          .addParameter("IDLISTE",element.getIdListe())
          .addParameter("STATUT",0)
          .addParameter("TITRE",element.getTitre())
          .addParameter("DESCRIPTION",element.getDescription())
          .addParameter("DATECREATION",new Date(System.currentTimeMillis()))
          .executeUpdate()
          .getKey();
      }
    }

    public void faitElement(int id){
      String updateSql =
        "UPDATE ELEMENT SET STATUT = 1 WHERE ID=:id;";

      try(Connection con = sql2o.open()) {
        con.createQuery(updateSql, true).addParameter("id",id).executeUpdate();
      }
    }

    public void deleteElement(int id){
      String deleteSql =
        "DELETE FROM ELEMENT WHERE ID=:id;";

      try(Connection con = sql2o.open()) {
        con.createQuery(deleteSql, true).addParameter("id",id).executeUpdate();
      }
    }


}
