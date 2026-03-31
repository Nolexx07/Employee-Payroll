abstract class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Polymorphism
    abstract double calculateSalary();

    void display() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

// Full-Time Employee
class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(String name, int id, double salary) {
        super(name, id);
        this.monthlySalary = salary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

// Part-Time Employee
class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    PartTimeEmployee(String name, int id, int hours, double rate) {
        super(name, id);
        this.hoursWorked = hours;
        this.hourlyRate = rate;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Intern
class Intern extends Employee {
    double stipend;

    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    @Override
    double calculateSalary() {
        return stipend;
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        Employee e1 = new FullTimeEmployee("Sathvik", 101, 50000);
        Employee e2 = new PartTimeEmployee("Rahul", 102, 5, 500);
        Employee e3 = new Intern("Priya", 103, 15000);

        Employee[] employees = {e1, e2, e3};

        for (Employee e : employees) {
            e.display();
            System.out.println("Salary: " + e.calculateSalary());
            System.out.println("---------------------");
        }
    }
}