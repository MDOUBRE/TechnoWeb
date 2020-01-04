import org.sql2o.*;
import java.util.List;

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

      sql = "create table Element (id integer primary key AUTO_INCREMENT,idListe integer,titre varchar(255),description varchar(255),datecreation date,datedernieremodif date,foreign key (idListe) references Liste(ID));";
      try(Connection con = sql2o.open()) {
        con.createQuery(sql, "creerTable").executeUpdate();
      }

    }

    /*
    create table Element (
    id integer primary key,
    idListe integer,
    titre varchar(255),
    description varchar(255),
    datecreation date,
    datedernieremodif date,
    foreign key (idListe) references Liste(ID));

    create table Liste (
    id integer primary key,
    titre varchar(255),
    datecreation date);
    */

    /*
    public void creerTableElement(){
      try(Connection con = sql2o.open()) {
        con.createQuery("create table ELEMENT " + "(idListe integer identity, id integer identity, titre varchar(50), description varchar(50), datecreation datetime, datedernieremodif datetime)").executeAndFetch(Element.class);
      }
    }
    */

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
          .addParameter("DATECREATION",liste.getDateCreation())
          .executeUpdate()
          .getKey();
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
        "insert into ELEMENT(IDLISTE, TITRE, DESCRIPTION, DATECREATION)" + "values (:IDLISTE, :TITRE, :DESCRIPTION, :DATECREATION)";

      try(Connection con = sql2o.open()) {
        con.createQuery(insertSql, true)
          .addParameter("IDLISTE",element.getIdListe())
          .addParameter("TITRE",element.getTitre())
          .addParameter("DESCRIPTION",element.getDescription())
          .addParameter("DATECREATION",element.getDateCreation())
          .executeUpdate()
          .getKey();
      }
    }


}
