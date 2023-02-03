package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.ClassDetails;
import com.model.Teacher;

public class ClassDAO {

	private Connection con = null;
	private PreparedStatement stmt=null;
	
	String sqlQuery ="insert into class(Class,Section)values(?,?)";
	
	public void addClass(ClassDetails cdts) throws SQLException{
		
		try {
			con=DBConncetion.getConnection();
			stmt = con.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, cdts.getName());
			stmt.setString(2, cdts.getSection());
			
			stmt.execute();
			stmt.close();con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
	public List<ClassDetails> showClasses() throws SQLException{
		
		List<ClassDetails> clsList = new ArrayList<ClassDetails>();
		
		String sqlQuery = "select class,section from class order by class";
		
		try {
			con= DBConncetion.getConnection();
			stmt = con.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				ClassDetails cls = new ClassDetails();
				cls.setName(rs.getString(1));
				cls.setSection(rs.getString(2));
				
				clsList.add(cls);
			}
		} catch (Exception e) {
			// TODO: handle exception
			con.close();
			System.out.println(e.getMessage());
		}
		
		return clsList;
	}
}
