import java.util.*;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import freemarker.template.*;

public class Main{

	public static void main(String[] args){
		System.out.println("debut");
		/*Element elementtest = new Element();
		Liste listetest = new Liste();
		listetest.setId(1);
		listetest.setDateCreation(new Date(12));
		listetest.setTitre("titreliste");
		listetest.setDescription("description");*/
		myDAO oui = new myDAO();
		/*oui.addListe(listetest);
		elementtest.setId(12);
		elementtest.setTitre("titre");
		elementtest.setIdListe(1);
		elementtest.setDescription("une description");
		elementtest.setDateCreation(new Date(1000));
		System.out.println(elementtest.getId());
		oui.addElement(elementtest);*/
		List<Element> listeE = oui.getListeElement();
		List<Liste> listeL = oui.getListeListe();
		System.out.println(listeE);
		System.out.println(listeL);

		Configuration cfg = new Configuration(new Version("2.3.23"));
		cfg.setClassForTemplateLoading(Main.class, "/");
    cfg.setDefaultEncoding("UTF-8");
		try{
			Template template = cfg.getTemplate("test.ftl");
		}catch(Exception E){
			System.out.println(E);
		}
		Map<String, Object> templateData = new HashMap<>();

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
