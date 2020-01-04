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
import spark.Spark;

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
			dao.addElement(elementtest);
		}
	}

	public static void main(String[] args) throws Exception{
		System.out.println("debut");
		//dao.creerTable();
		//filldb();

		List<Element> listeE = dao.getListeElement();
		List<Liste> listeL = dao.getListeListe();
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


		Spark.get("/", (request, response) -> {

      StringWriter writer = new StringWriter();

      try {
          Template formTemplate = cfg.getTemplate("test.ftl");
					Map<String, Object> templateData = new HashMap<>();
					templateData.put("elements",dao.getListeElement());
					templateData.put("listes",dao.getListeListe());
          formTemplate.process(templateData, writer);
      } catch (Exception e) {
				System.out.println("erreur 1");
				System.out.println(e);
        Spark.halt(500);
      }

      return writer;
	  });

		Spark.post("/rliste", (request, response) -> {
      StringWriter writer = new StringWriter();

      try {
        String titre = request.queryParams("ltitre") != null ? request.queryParams("ltitre") : "Titre";
        String desc = request.queryParams("ldescription") != null ? request.queryParams("ldescription") : "description de la liste";

				Liste listeARajouter = new Liste();
				listeARajouter.setTitre(titre);
				listeARajouter.setDescription(desc);
				dao.addListe(listeARajouter);

				Template formTemplate = cfg.getTemplate("test.ftl");
				Map<String, Object> templateData = new HashMap<>();
				templateData.put("elements",dao.getListeElement());
				templateData.put("listes",dao.getListeListe());
				formTemplate.process(templateData, writer);
				response.redirect("/");
      } catch (Exception e) {
				System.out.println("erreur 2");
				System.out.println(e);
        Spark.halt(500);
    	}

      return writer;
    });

		Spark.post("/relement", (request, response) -> {
      StringWriter writer = new StringWriter();

      try {
        String titre = request.queryParams("etitre") != null ? request.queryParams("etitre") : "Titre";
        String desc = request.queryParams("edescription") != null ? request.queryParams("edescription") : "description de la liste";
				String listeString = request.queryParams("eliste") != null ? request.queryParams("eliste") : "1";
				System.out.println("Ici l'id de la liste : " + listeString);
				System.out.println("Ici l'id de la liste 2 : " + request.queryParams("eliste"));

				int liste = Integer.parseInt(listeString);

				Element elementARajouter = new Element();
				elementARajouter.setTitre(titre);
				elementARajouter.setDescription(desc);
				elementARajouter.setIdListe(liste);
				dao.addElement(elementARajouter);

				Template formTemplate = cfg.getTemplate("test.ftl");
				Map<String, Object> templateData = new HashMap<>();
				templateData.put("elements",dao.getListeElement());
				templateData.put("listes",dao.getListeListe());
				formTemplate.process(templateData, writer);
				response.redirect("/");
      } catch (Exception e) {
				System.out.println("erreur 3");
				System.out.println(e);
        Spark.halt(500);
    	}

      return writer;
    });

		/*
		Template template = cfg.getTemplate("test.ftl");


		Map<String, Object> templateData = new HashMap<>();
		templateData.put("elements",listeE);
		templateData.put("listes",listeL);
		Writer out = new OutputStreamWriter(new FileOutputStream(new File("test.html")));
		template.process(templateData, out);
		*/
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
