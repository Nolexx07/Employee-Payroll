import java.util.*;

abstract class Employee {
    String name;
    int id;
    int daysWorked;
    int sickLeaveDays;
    double nightShiftAllowance;
    double shiftAllowance;
    double bonus;
    double otherAllowances;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
        this.daysWorked = 30; // Default days in a month
        this.sickLeaveDays = 0;
        this.nightShiftAllowance = 0;
        this.shiftAllowance = 0;
        this.bonus = 0;
        this.otherAllowances = 0;
    }

    // Polymorphism
    abstract double calculateBaseSalary();

    // Calculate leave encashment (per day rate * remaining sick leaves can be encashed)
    double calculateLeaveEncashment() {
        double perDayRate = calculateBaseSalary() / 30;
        return perDayRate * Math.max(0, sickLeaveDays - 5); // Assuming 5 days not encashable
    }

    // Calculate total salary with all components
    double calculateSalary() {
        double baseSalary = calculateBaseSalary();
        double leaveEncashment = calculateLeaveEncashment();
        double totalAllowances = nightShiftAllowance + shiftAllowance + otherAllowances;
        return baseSalary + leaveEncashment + totalAllowances + bonus;
    }

    // Display salary breakdown
    void displaySalaryBreakdown() {
        System.out.println("\n========== SALARY BREAKDOWN ==========");
        System.out.println("Name: " + name + " | ID: " + id);
        System.out.println("Days Worked: " + daysWorked);
        System.out.println("Sick Leave Days: " + sickLeaveDays);
        System.out.printf("Base Salary: Rs. %.2f\n", calculateBaseSalary());
        System.out.printf("Leave Encashment: Rs. %.2f\n", calculateLeaveEncashment());
        System.out.printf("Night Shift Allowance: Rs. %.2f\n", nightShiftAllowance);
        System.out.printf("Shift Allowance: Rs. %.2f\n", shiftAllowance);
        System.out.printf("Other Allowances: Rs. %.2f\n", otherAllowances);
        System.out.printf("Bonus: Rs. %.2f\n", bonus);
        System.out.printf("================================\n");
        System.out.printf("TOTAL SALARY: Rs. %.2f\n", calculateSalary());
        System.out.println("=====================================\n");
    }

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
    double calculateBaseSalary() {
        // Adjust salary based on days worked (deduct for leaves taken)
        return (monthlySalary / 30) * daysWorked;
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
    double calculateBaseSalary() {
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
    double calculateBaseSalary() {
        return stipend;
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[3];

        System.out.println("===============================================");
        System.out.println("     EMPLOYEE PAYROLL MANAGEMENT SYSTEM");
        System.out.println("===============================================\n");

        // Input for three employees
        for (int i = 0; i < 3; i++) {
            System.out.println("\n--- EMPLOYEE " + (i + 1) + " ---");
            
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            
            System.out.print("Enter Employee Type (1=Full-Time, 2=Part-Time, 3=Intern): ");
            int empType = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            Employee emp = null;
            
            if (empType == 1) {
                // Full-Time Employee
                System.out.print("Enter Monthly Salary: ");
                double salary = sc.nextDouble();
                emp = new FullTimeEmployee(name, id, salary);
            } else if (empType == 2) {
                // Part-Time Employee
                System.out.print("Enter Hours Worked: ");
                int hours = sc.nextInt();
                System.out.print("Enter Hourly Rate: ");
                double rate = sc.nextDouble();
                emp = new PartTimeEmployee(name, id, hours, rate);
            } else if (empType == 3) {
                // Intern
                System.out.print("Enter Stipend: ");
                double stipend = sc.nextDouble();
                emp = new Intern(name, id, stipend);
            }
            
            // Input additional salary components
            System.out.print("Enter Days Worked: ");
            emp.daysWorked = sc.nextInt();
            
            System.out.print("Enter Sick Leave Days: ");
            emp.sickLeaveDays = sc.nextInt();
            
            System.out.print("Enter Night Shift Allowance: ");
            emp.nightShiftAllowance = sc.nextDouble();
            
            System.out.print("Enter Shift Allowance: ");
            emp.shiftAllowance = sc.nextDouble();
            
            System.out.print("Enter Other Allowances: ");
            emp.otherAllowances = sc.nextDouble();
            
            System.out.print("Enter Bonus: ");
            emp.bonus = sc.nextDouble();
            
            sc.nextLine(); // Consume newline
            
            employees[i] = emp;
        }

        // Display salary breakdowns
        System.out.println("\n\n===============================================");
        System.out.println("     SALARY BREAKDOWNS FOR ALL EMPLOYEES");
        System.out.println("===============================================");

        for (Employee e : employees) {
            e.displaySalaryBreakdown();
        }

        // Summary
        System.out.println("\n===============================================");
        System.out.println("               MONTHLY PAYROLL SUMMARY");
        System.out.println("===============================================");
        double totalPayroll = 0;
        for (Employee e : employees) {
            System.out.printf("%-20s: Rs. %.2f\n", e.name, e.calculateSalary());
            totalPayroll += e.calculateSalary();
        }
        System.out.println("-----------------------------------------------");
        System.out.printf("%-20s: Rs. %.2f\n", "TOTAL PAYROLL", totalPayroll);
        System.out.println("===============================================\n");

        sc.close();
    }
}