package com.tanmay.demorest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
	Connection con=null;
	StudentRepository(){
		String url = "jdbc:mysql://localhost:3306/?user=root/test_project";
		String uname = "root";
		String pass = "TanmayDarshak1403";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		String sql = "select * from test_project.Student";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Student s = new Student(rs.getString("name"),rs.getString("city"),rs.getString("email"),rs.getString("sex"),rs.getInt("age"),rs.getInt("marks"));
				s.setId(rs.getInt("id"));
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}
	public List<Student> getStudentByName(String n) {
		List<Student> students = new ArrayList<>();
		String sql = "select * from test_project.Student where name='"+n+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Student s = new Student(rs.getString("name"),rs.getString("city"),rs.getString("email"),rs.getString("sex"),rs.getInt("age"),rs.getInt("marks"));
				s.setId(rs.getInt("id"));
				students.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	public Student getStudentById(int n) {
		String sql = "select * from test_project.Student where id="+n;
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				Student s = new Student(rs.getString("name"),rs.getString("city"),rs.getString("email"),rs.getString("sex"),rs.getInt("age"),rs.getInt("marks"));
				s.setId(rs.getInt("id"));
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void createStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "insert into test_project.Student (name,city,email,sex,age,marks) values (?,?,?,?,?,?)";
		PreparedStatement st;
		try {
			st = con.prepareStatement(sql);
			st.setString(1,s.getName());
			st.setString(2, s.getCity());
			st.setString(3, s.getEmail());
			st.setString(4, s.getSex());
			st.setInt(5,s.getAge());
			st.setInt(6, s.getMarks());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "update test_project.Student set name=?,city=?,email=?,sex=?,age=?,marks=? where id=?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(sql);
			st.setString(1,s.getName());
			st.setString(2, s.getCity());
			st.setString(3, s.getEmail());
			st.setString(4, s.getSex());
			st.setInt(5,s.getAge());
			st.setInt(6, s.getMarks());
			st.setInt(7, s.getId());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from test_project.Student where id=?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
