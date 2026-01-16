package week01.lab.studentcompare;
import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(3, "Mathematics", "Alice"));
        students.add(new Student(2, "Computer Science", "Bob"));
        students.add(new Student(4, "Physics", "Charlie"));
        students.add(new Student(1, "Chemistry", "David"));

        Collections.sort(students); 
        // Collections.sort is a method that sorts a list by calling the compareTo method
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
