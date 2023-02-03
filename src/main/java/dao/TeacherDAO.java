package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Teacher;

public class TeacherDAO {

	private Connection con = null;
	private PreparedStatement stmt=null;
	
	public void addTeacher(Teacher tch) throws SQLException {
		
		String sqlQuery ="insert into teacher(TeacherName,Subject,Class)values(?,?,?)";
		
		try {
			con = DBConncetion.getConnection();
			stmt = con.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, tch.getTchName());
			stmt.setString(2, tch.getSubject());
			stmt.setString(3, tch.getClassname());
			
			stmt.execute();
			stmt.close();con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Teacher> showTeachers() throws SQLException{
		List<Teacher> tchList = new ArrayList<Teacher>();
		
		Connection con = null;
		PreparedStatement stm = null;
		
		String sqlQuery="select TeacherName,Subject,Class from Teacher order by class";
		
		try {
			con=DBConncetion.getConnection();
			stmt = con.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Teacher tch = new Teacher();
				tch.setTchName(rs.getString(1));
				tch.setSubject(rs.getString(2));
				tch.setClassname(rs.getString(3));
				
				tchList.add(tch);
			}
		} catch (Exception e) {
			// TODO: handle exception
			con.close();
			System.out.println(e.getMessage());
		}
		
		return tchList;
	}
}
