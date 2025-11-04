package controller;

import dao.StudentDAO;
import model.Student;
import view.StudentView;
import java.util.*;

public class StudentController {
    public static void main(String[] args) throws Exception {
        StudentDAO dao = new StudentDAO();
        StudentView view = new StudentView();

        while (true) {
            int choice = view.showMenu();
            switch (choice) {
                case 1:
                    Student s = view.getStudentDetails();
                    dao.addStudent(s);
                    System.out.println("✅ Student Added!");
                    break;
                case 2:
                    List<Student> list = dao.getAllStudents();
                    view.displayStudents(list);
                    break;
                case 3:
                    Student updated = view.getUpdatedDetails();
                    dao.updateStudent(updated);
                    System.out.println("✅ Student Updated!");
                    break;
                case 4:
                    int id = view.getIdForDelete();
                    dao.deleteStudent(id);
                    System.out.println("✅ Student Deleted!");
                    break;
                case 5:
                    System.out.println("👋 Exiting...");
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid Choice!");
            }
        }
    }
}
