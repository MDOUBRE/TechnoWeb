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

		try{
			dao.getListeListe();
		}catch(Exception E){
			dao.creerTable();
			//filldb();
		}

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
				System.out.println("erreur rliste");
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
				System.out.println("erreur relement");
				System.out.println(e);
        Spark.halt(500);
    	}

      return writer;
      });

		Spark.post("/dliste", (request, response) -> {
      StringWriter writer = new StringWriter();

      try {
				String listeString = request.queryParams("didliste") != null ? request.queryParams("didliste") : "1";
				int liste = Integer.parseInt(listeString);
				dao.deleteListe(liste);

				Template formTemplate = cfg.getTemplate("test.ftl");
				Map<String, Object> templateData = new HashMap<>();
				templateData.put("elements",dao.getListeElement());
				templateData.put("listes",dao.getListeListe());
				formTemplate.process(templateData, writer);
				response.redirect("/");
      } catch (Exception e) {
				System.out.println("erreur dlist");
				System.out.println(e);
        Spark.halt(500);
    	}

      return writer;
		});

		Spark.post("/delement", (request, response) -> {
      StringWriter writer = new StringWriter();

      try {
				String elementString = request.queryParams("didelement") != null ? request.queryParams("didelement") : "1";
				int element = Integer.parseInt(elementString);
				dao.deleteElement(element);

				Template formTemplate = cfg.getTemplate("test.ftl");
				Map<String, Object> templateData = new HashMap<>();
				templateData.put("elements",dao.getListeElement());
				templateData.put("listes",dao.getListeListe());
				formTemplate.process(templateData, writer);
				response.redirect("/");
      } catch (Exception e) {
				System.out.println("erreur delement");
				System.out.println(e);
        Spark.halt(500);
    	}

      return writer;
		});

		Spark.post("/faitelement", (request, response) -> {
			StringWriter writer = new StringWriter();

			try {
					String elementString = request.queryParams("fidelement") != null ? request.queryParams("fidelement") : "1";
					int element = Integer.parseInt(elementString);
					dao.faitElement(element);

					Template formTemplate = cfg.getTemplate("test.ftl");
					Map<String, Object> templateData = new HashMap<>();
					templateData.put("elements",dao.getListeElement());
					templateData.put("listes",dao.getListeListe());
					formTemplate.process(templateData, writer);
					response.redirect("/");
			} catch (Exception e) {
					System.out.println("erreur faitelement");
					System.out.println(e);
			Spark.halt(500);
			}

			return writer;
		});

		Spark.post("/form", (request, response) -> {
			StringWriter writer = new StringWriter();

			try {
					String elementString = request.queryParams("midelement") != null ? request.queryParams("midelement") : "1";
					String elementName = request.queryParams("name") != null ? request.queryParams("name") : "1";
					int element = Integer.parseInt(elementString);
					Template formTemplate = cfg.getTemplate("form.ftl");
					Map<String, Object> templateData = new HashMap<>();
					if(elementName.equals("element")){
						templateData.put("element",dao.getElementById(element));
					}else{
						templateData.put("element",dao.getListeById(element));
					}
					formTemplate.process(templateData, writer);
			} catch (Exception e) {
					System.out.println("erreur form");
					System.out.println(e);
			Spark.halt(500);
			}

			return writer;
		});

		Spark.post("/modifelement", (request, response) -> {
			StringWriter writer = new StringWriter();

			try {
					String elementTitre = request.queryParams("telement") != null ? request.queryParams("telement") : "titre";
					String name = request.queryParams("name") != null ? request.queryParams("name") : "titre";
					String elementDesc = request.queryParams("delement") != null ? request.queryParams("delement") : "description";
					String elementString = request.queryParams("idelement") != null ? request.queryParams("idelement") : "1";
					int element = Integer.parseInt(elementString);
					dao.setTitreElement(elementTitre,element);
					dao.setDescriptionElement(elementDesc,element);

					Template formTemplate = cfg.getTemplate("test.ftl");
					Map<String, Object> templateData = new HashMap<>();
					templateData.put("elements",dao.getListeElement());
					templateData.put("listes",dao.getListeListe());
					formTemplate.process(templateData, writer);
					response.redirect("/");
			} catch (Exception e) {
					System.out.println("erreur modif element");
					System.out.println(e);
					Spark.halt(500);
			}

			return writer;
		});

		Spark.post("/modifliste", (request, response) -> {
			StringWriter writer = new StringWriter();

			try {
					String elementTitre = request.queryParams("telement") != null ? request.queryParams("telement") : "titre";
					String elementDesc = request.queryParams("delement") != null ? request.queryParams("delement") : "description";
					String elementString = request.queryParams("idelement") != null ? request.queryParams("idelement") : "1";
					int element = Integer.parseInt(elementString);
					dao.setTitreListe(elementTitre,element);
					dao.setDescriptionListe(elementDesc,element);

					Template formTemplate = cfg.getTemplate("test.ftl");
					Map<String, Object> templateData = new HashMap<>();
					templateData.put("elements",dao.getListeElement());
					templateData.put("listes",dao.getListeListe());
					formTemplate.process(templateData, writer);
					response.redirect("/");
			} catch (Exception e) {
					System.out.println("erreur modifliste");
					System.out.println(e);
					Spark.halt(500);
			}

			return writer;
		});

	}
}
