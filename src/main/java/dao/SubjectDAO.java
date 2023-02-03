package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Subject;

public class SubjectDAO {

	
	private Connection con = null;
	private PreparedStatement stmt = null;
	
	public void addSubject(Subject sbj) throws SQLException{
		
		String sqlQuery = "insert into subject(SubjectName,TeacherName,Class)values(?,?,?)";
		
		try {
			con = DBConncetion.getConnection();
			stmt = con.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, sbj.getSbjName());
			stmt.setString(2, sbj.getTchName());
			stmt.setString(3, sbj.getClsName());
			
			
			stmt.execute();
			stmt.close();con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public List<Subject> showSubjects() throws SQLException {
		List<Subject> sbjList = new ArrayList<Subject>();
		
		String sqlQuery = "select SubjectName,TeacherName,class from subject order by class";
		
		try {
			con = DBConncetion.getConnection();
			stmt = con.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Subject sbj = new Subject();
				sbj.setSbjName(rs.getString(1));
				sbj.setTchName(rs.getString(2));
				sbj.setClsName(rs.getString(3));
				
				sbjList.add(sbj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			con.close();
			System.out.println(e.getMessage());
		}
		
		
		return sbjList;
	}
}
