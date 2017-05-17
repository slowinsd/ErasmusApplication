import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe permettant de creer une table pour la base de donnees
 */
public class Create {

	/**
	 * Constructeur vide de Create
	 */
	public Create(){

	}
	/**
	 * Constructeur de Create permettant de creer une table
	 * @param stmt
	 */
	public  Create(Statement stmt) throws SQLException{
		String sql =
				"DROP TABLE IF EXISTS VILLE;";
		// A effacer pour plus tard 
		stmt.execute(sql);
		sql=	"CREATE TABLE VILLE " +
				"(NAME    TEXT  PRIMARY KEY , " +
				"UNIVNAME     TEXT   , " + 
				"DESCRIPTION     TEXT   , " + 
				"DEPARTMENT TEXT    "	+ 
				");"; 
		System.out.println(sql);
		stmt.execute(sql);
	}
	
}