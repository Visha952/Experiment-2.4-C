package dao;

import model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection con;

    public StudentDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
    }

    public void addStudent(Student s) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO student(name, age) VALUES(?, ?)");
        ps.setString(1, s.getName());
        ps.setInt(2, s.getAge());
        ps.executeUpdate();
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");

        while (rs.next()) {
            list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
        }
        return list;
    }

    public void updateStudent(Student s) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE student SET name=?, age=? WHERE id=?");
        ps.setString(1, s.getName());
        ps.setInt(2, s.getAge());
        ps.setInt(3, s.getId());
        ps.executeUpdate();
    }

    public void deleteStudent(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
