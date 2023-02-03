package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class StudentDAO {

public void addStudent(Student std) throws ClassNotFoundException, SQLException {
		
		
		String sql = "insert into student(studentName,Class,rollNo)values(?,?,?)";
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Nikhil");
		PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
		stmt.setString(1, std.getStdName());
		stmt.setString(2, std.getClassname());
		stmt.setString(3, std.getRollNo());
		
		stmt.execute();
		stmt.close();con.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


public List<Student> showStudents() throws SQLException{
	
	List<Student>stdList = new ArrayList<Student>();
	
		String sqlQuery ="select StudentName,class,rollNo from student order by rollNo";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBConncetion.getConnection();
			stmt= con.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Student std = new Student();
				std.setStdName(rs.getString(1));
				std.setClassname(rs.getString(2));
				std.setRollNo(rs.getString(3));
				
				stdList.add(std);
			}
		} catch (Exception e) {
			// TODO: handle exception
			con.close();
			System.out.println(e.getMessage());
		}
	return stdList;
}
}
