import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 * Classe permettant de selectionner tout les modeles 
 * qui composent la base de donnees
 */
public class SelectAll {

	/** 
	 * Constructeur vide de SelectAll
	 */
	public SelectAll(){
	}
	
	/**
	 * Constructeur de SelectAll permettant d'afficher tout le contenu de la table
	 * @param stmt
	 */
	public  SelectAll(Statement stmt){ //--all
		JFrame frame = new JFrame();
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		ResultSet rs;
		JList list = new JList();
		DefaultListModel<String> listModel = new DefaultListModel();
		frame.setTitle("Select All");
		try {
			String sql = "Select * FROM " + "VILLE" + ";";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				listModel.addElement("Nom : "+rs.getString("NAME"));
				listModel.addElement("Chemin : " + rs.getString("UNIVNAME"));
				listModel.addElement("Date : " + rs.getString("DESCRIPTION"));
				listModel.addElement("Mots clefs : " + rs.getString("DEPARTMENT"));
				listModel.addElement("~");
				//System.out.println(rs.getString("Name"));
			}
			
			
			list = new JList(listModel);
			JScrollPane jscp =new JScrollPane(list);
			frame.add(jscp);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		frame.setPreferredSize(new Dimension(300, 800));
		frame.setMinimumSize(new Dimension(250, 200));
		frame.setLocation(400, 50);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}