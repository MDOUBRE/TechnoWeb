import org.sql2o.*;

public class myDao {

    private Sql2o sql2o;

    public myDao() {
        this.sql2o = new Sql2o("jdbc:h2:~/bddtest", "nicolas", "nicolas");
    }

    public List<Liste> getListeListe(){
      String sql =
        "SELECT * from LISTE;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Task.class);
      }
    }

    public List<Liste> getListeElement(){
      String sql =
        "SELECT * from ELEMENT;";

      try(Connection con = sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Task.class);
      }
    }

}
