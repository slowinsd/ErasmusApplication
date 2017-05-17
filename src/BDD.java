import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe principale de la base de donnees
 * C'est cette classe qui prend en compte les parametres afin de savoir quelle option doit etre geree
 * 
 */
public class BDD {


	static Statement stmt;
	static Connection connection = null;

	/**
	 * Methode pour se connecter a la base de donnees
	 * 
	 * @param para
	 * 				L'adresse a laquel on désire se connecter
	 * @return
	 * true si l'on y arrive,false en cas d'erreur
	 */
	public  boolean Connect(String para) {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(para);
			stmt = connection.createStatement();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Constructeur vide de la base de donnees
	 */
	/**
	 * Constructeur de la base de donnees ou sont effectuees les differentes commandes
	 * @param args
	 */
	public BDD(){
		String argument = "";
		try {
			Connect("jdbc:sqlite:src/data/database.db");
				//Cr�e une table  new Create(stmt);
							
			
		} 
		catch (Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	public Connection getC() {
		return connection;
	}
	public void setC(Connection c) {
		this.connection = c;
	}
	public static void main(String[] args) throws SQLException {
		BDD bdd = new BDD();
		//Create c = new Create(stmt);
		Insert i = new Insert(stmt,connection);
		SelectAll select = new SelectAll(stmt);
		
	}


}