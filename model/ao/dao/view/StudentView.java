package view;

import model.Student;
import java.util.*;

public class StudentView {
    Scanner sc = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n=== Student Management ===");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
        return sc.nextInt();
    }

    public Student getStudentDetails() {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        return new Student(0, name, age);
    }

    public Student getUpdatedDetails() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        System.out.print("Enter new name: ");
        String name = sc.next();
        System.out.print("Enter new age: ");
        int age = sc.nextInt();
        return new Student(id, name, age);
    }

    public int getIdForDelete() {
        System.out.print("Enter student ID to delete: ");
        return sc.nextInt();
    }

    public void displayStudents(List<Student> list) {
        System.out.println("\nID\tName\tAge");
        System.out.println("-------------------");
        for (Student s : list) {
            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getAge());
        }
    }
}
