
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main{

	public static void main(String[] args) {
		System.out.println("debut");
		Element truc = new Element();
		truc.setId(12);
		System.out.println(truc.getId());
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
