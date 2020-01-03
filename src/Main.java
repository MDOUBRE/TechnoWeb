//javac -d build -cp "lib/*" src/*.java
//java -cp "lib/*;build" Main

import java.io.*;
import java.util.*;
import java.sql.*;
import freemarker.template.*;

public class Main{

	public static void main(String[] args) throws Exception{
		System.out.println("debut");
		/*Element elementtest = new Element();
		Liste listetest = new Liste();
		listetest.setId(1);
		listetest.setDateCreation(new Date(12));
		listetest.setTitre("titreliste");
		listetest.setDescription("description");*/

		MyDAO oui = new MyDAO();

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
		try{
			cfg.setDirectoryForTemplateLoading(new File("src"));
		}catch(Exception E){
			System.out.println(E);
		}
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);
		//try{
			Template template = cfg.getTemplate("test.ftl");
	////////	}

		Map<String, Object> templateData = new HashMap<>();
		//createNewFile("../test.html");
		templateData.put("elements",listeE);
		Writer out = new OutputStreamWriter(new FileOutputStream(new File("../test.html")));
		template.process(templateData, out);

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
