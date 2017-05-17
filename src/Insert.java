import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

/**
 * Classe permettant d'ajouter un modele dans la base de donnees
 */
public class Insert {

	JTextField  testField1 = new JTextField ("");//name
	JTextField  testField2 = new JTextField ("");//path
	JTextField  testField3 = new JTextField ("");//ensemble 
	boolean retour = true;

	/**
	 * Constructeur vide de Insert
	 */
	public Insert(){
	}
	/**
	 * Constructeur de Insert permettant d'ajouter un 
	 * nouvel element dans la base de donnees
	 * @param stmt
	 * @param c 
	 * 			
	 */
	
	public  Insert(Statement stmt,Connection c){//--add
		try {
			String sql = "INSERT INTO " + "VILLE " + "VALUES (" + 
			"' ATHENS  '," + 
			"' TEIA '," + 
			"' JAVA,C'," + 
			"' INFORMATIC '" + ");";
			stmt.executeUpdate(sql);
			c.commit();
		
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());	
			retour = false;
		}		
	}
	
	
	
}