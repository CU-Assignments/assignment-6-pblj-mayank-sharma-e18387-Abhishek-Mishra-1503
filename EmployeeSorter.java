import java.util.*;

// Employee class
class Employee {
    private String name;
    private int age;
    private double salary;

    // Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    // toString for display
    @Override
    public String toString() {
        return String.format("Name: %-10s | Age: %-2d | Salary: ₹%.2f", name, age, salary);
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {
        // Sample Employee list
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Sakshi", 25, 70000));
        employees.add(new Employee("Rahul", 30, 60000));
        employees.add(new Employee("Aman", 22, 80000));
        employees.add(new Employee("Neha", 28, 75000));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Sort Employees Menu ===");
            System.out.println("1. Sort by Name");
            System.out.println("2. Sort by Age");
            System.out.println("3. Sort by Salary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
                    System.out.println("\nSorted by Name:");
                    employees.forEach(System.out::println);
                    break;

                case 2:
                    employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
                    System.out.println("\nSorted by Age:");
                    employees.forEach(System.out::println);
                    break;

                case 3:
                    employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
                    System.out.println("\nSorted by Salary:");
                    employees.forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("🚪 Exiting...");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
