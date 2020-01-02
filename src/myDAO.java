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
