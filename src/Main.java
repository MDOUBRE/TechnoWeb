import org.h2.jdbc.JdbcSQLException;
import org.h2.message.DbException;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


// Chargement du driver JDBC pour MySQL
// Là vous verrez vite si vous avez bien fait le boulot d'importation de la librairie
		String nomDriver = "org.h2.Driver";
		try
        {
		    Class.forName(nomDriver); 
		}
        catch(ClassNotFoundException cnfe)
        {
			JOptionPane.showMessageDialog(null, "Erreur de chargement de driver de base de données", "La classe "+nomDriver+" n'a pas été trouvée", JOptionPane.ERROR_MESSAGE);			
		    dispose ();
		}
		System.out.println ("Driver H2 Database chargé...");


public class Main{
    public static void main(String[] args){
         
        Liste DVD=new Liste();
        DVD.setDescription("Cette liste est une liste de DVD que l'on a.\n");
        Element DVD1=new Element();
        DVD.ajouteElement(DVD1);
        
    }
}