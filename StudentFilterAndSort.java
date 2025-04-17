import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return name + " - " + marks + "%";
    }
}

public class StudentFilterAndSort {
    public static void main(String[] args) {
        // Sample student list
        List<Student> students = Arrays.asList(
            new Student("Sakshi", 92.5),
            new Student("Rahul", 67.0),
            new Student("Neha", 88.3),
            new Student("Aman", 73.9),
            new Student("Tina", 79.6)
        );

        System.out.println("🎓 Students scoring above 75% (sorted by marks):");

        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks())) // Descending
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
