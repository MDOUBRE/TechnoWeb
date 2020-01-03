//javac -d build -cp "lib/*" src/*.java
//java -cp "lib/*;build" Main

import java.io.*;
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
	public static MyDAO dao = new MyDAO();
	// adds one list with 10 elements
	public static void filldb(){

		Element elementtest = new Element();
		Liste listetest = new Liste();

		listetest.setDateCreation(new Date(System.currentTimeMillis()));
		listetest.setTitre("titredeliste");
		listetest.setDescription("description");
		dao.addListe(listetest);
		List<Liste> listeL = dao.getListeListe();
		Liste listUtil = listeL.get(listeL.size()-1);
		for(int i=1; i<11 ; i++){
			elementtest.setTitre("titre" +i);
			elementtest.setIdListe(listUtil.getId());
			elementtest.setDescription("une description" +i);
			elementtest.setDateCreation(new Date(System.currentTimeMillis()));
			System.out.println(elementtest.getId());
			dao.addElement(elementtest);
		}
	}

	public static void main(String[] args) throws Exception{
		System.out.println("debut");

		//filldb();

		oui.creerTableListe();
		//oui.creerTableElement();
		List<Element> listeE = oui.getListeElement();
		List<Liste> listeL = oui.getListeListe();
		System.out.println(listeE);
		System.out.println(listeL);

		Configuration cfg = new Configuration(new Version("2.3.23"));
		try{
			cfg.setDirectoryForTemplateLoading(new File("src"));
		}catch(Exception E){
			System.out.println(E);
		}
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);

		Template template = cfg.getTemplate("test.ftl");


		Map<String, Object> templateData = new HashMap<>();
		templateData.put("elements",listeE);
		Writer out = new OutputStreamWriter(new FileOutputStream(new File("test.html")));
		template.process(templateData, out);

	}
}


/*
create table Element (
id integer primary key AUTO_INCREMENT,
idListe integer,
titre varchar(255),
description varchar(255),
datecreation date,
datedernieremodif date,
foreign key (idListe) references Liste(ID));

create table Liste (
id integer primary key AUTO_INCREMENT,
titre varchar(255),
description varchar(255),
datecreation date);
*/
