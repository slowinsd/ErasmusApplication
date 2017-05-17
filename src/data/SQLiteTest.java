package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteDataSource;

public class SQLiteTest {
	 public static void main(String[] args) {
	        SQLiteDataSource ds = new SQLiteDataSource();
	        ds.setUrl("jdbc:sqlite:src/data/database.db");
	        try (Connection conn = ds.getConnection()) {
	            System.out.println("Connected to the database\n");
	            String sql = 
	                    "SELECT * FROM VILLE;";
	            try (
	                    Statement s = conn.createStatement();
	                    ResultSet rs = s.executeQuery(sql)) {
	            	while(rs.next()){
		                System.out.println("City : "+rs.getString("NAME"));
		                System.out.println("University : "+rs.getString("UNIVNAME"));
		                System.out.println("Description : "+rs.getString("DESCRIPTION"));
		                System.out.println("Department : "+rs.getString("DEPARTMENT")+"\n");
	            	}
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(System.err);
	        }
	    }

}
