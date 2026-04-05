# 💼 Employee Payroll Management System

## 📌 Overview
The **Employee Payroll Management System** is a comprehensive Java-based application designed to calculate and manage salaries for different types of employees using core **Object-Oriented Programming (OOP)** concepts such as **Inheritance, Polymorphism, and Abstraction**.

This project demonstrates how real-world payroll systems can be structured in a scalable, maintainable, and professional way. It supports complex salary calculations including allowances, leaves, encashments, and bonuses.

---

## 🚀 Features

### ✅ Multiple Employee Types
- Full-Time Employees
- Part-Time Employees
- Interns

### ✅ Advanced Salary Components
- **Base Salary** - Employee's regular salary
- **Leave Encashment** - Monetary value of unused sick leaves
- **Sick Leave Management** - Track sick leave days taken
- **Night Shift Allowance** - Additional pay for night shifts
- **Shift Allowance** - Extra compensation for working specific shifts
- **Other Allowances** - Miscellaneous allowances
- **Bonus** - Performance or incentive-based bonuses

### ✅ Interactive Features
- **Scanner Input** - Enter employee details dynamically
- **Days Worked Tracking** - Pro-rata salary calculation based on actual attendance
- **Detailed Salary Breakdown** - View each component separately
- **Monthly Payroll Summary** - Total payroll across all employees
- **Professional Report Format** - Formatted output for easy reading

---

## 🧠 OOP Concepts Used

### 🔹 **Inheritance**
- Base class `Employee` defines common properties and methods
- Child classes extend it:
  - `FullTimeEmployee` - Inherits Employee class
  - `PartTimeEmployee` - Inherits Employee class
  - `Intern` - Inherits Employee class

### 🔹 **Polymorphism**
- Method `calculateBaseSalary()` is overridden in each child class
- Different implementation for each employee type
- Same interface for different behaviors

### 🔹 **Abstraction**
- `Employee` class is declared as abstract
- Defines contract that all employee types must follow
- Hides complex implementation details

---

## 🏗️ Project Structure

```
employeepayroll/
│
├── Main.java                    # Main program file
│   ├── Employee (Abstract)      # Base employee class
│   ├── FullTimeEmployee         # Full-time employee type
│   ├── PartTimeEmployee         # Part-time employee type
│   ├── Intern                   # Intern employee type
│   └── Main                     # Entry point with Scanner input
│
├── Main.class                   # Compiled class files
├── Employee.class
├── FullTimeEmployee.class
├── PartTimeEmployee.class
├── Intern.class
│
└── README.md                    # Documentation

```

---

## 📚 Class Details

### **Employee (Abstract Class)**
The base class that defines the structure for all employees.

**Properties:**
- `name` - Employee name
- `id` - Employee ID
- `daysWorked` - Days worked in a month (default: 30)
- `sickLeaveDays` - Number of sick leaves taken
- `nightShiftAllowance` - Night shift bonus
- `shiftAllowance` - Shift-based allowance
- `bonus` - Performance bonus
- `otherAllowances` - Other miscellaneous allowances

**Methods:**
- `calculateBaseSalary()` - Abstract method (overridden by child classes)
- `calculateLeaveEncashment()` - Calculates leave encashment (5 days protected, rest encashable)
- `calculateSalary()` - Calculates total salary with all components
- `displaySalaryBreakdown()` - Shows detailed salary breakdown
- `display()` - Shows basic employee info

---

### **FullTimeEmployee**
Extends `Employee` for permanent staff.

**Constructor:** `FullTimeEmployee(String name, int id, double salary)`

**calculateBaseSalary():**
- Formula: `(monthlySalary / 30) * daysWorked`
- Pro-rata adjustment based on days worked

---

### **PartTimeEmployee**
Extends `Employee` for hourly workers.

**Constructor:** `PartTimeEmployee(String name, int id, int hours, double rate)`

**calculateBaseSalary():**
- Formula: `hoursWorked * hourlyRate`

---

### **Intern**
Extends `Employee` for internship positions.

**Constructor:** `Intern(String name, int id, double stipend)`

**calculateBaseSalary():**
- Returns the stipend amount

---

## 💻 Installation & Setup

### Prerequisites
- Java JDK 8 or higher
- Git (optional, for version control)

### Steps

1. **Clone/Download the Repository**
```bash
git clone https://github.com/Nolexx07/Employee-Payroll.git
cd employeepayroll
```

2. **Compile the Program**
```bash
javac Main.java
```

3. **Run the Program**
```bash
java Main
```

---

## 📖 Usage Instructions

Once you run the program, follow these steps:

### **For Each of 3 Employees:**

1. **Enter Employee Name** (e.g., `Sunny`, `Rahul`, `Priya`)
2. **Enter Employee ID** (e.g., `101`, `102`, `103`)
3. **Enter Employee Type**
   - `1` = Full-Time Employee
   - `2` = Part-Time Employee
   - `3` = Intern

4. **Enter Specific Details Based on Type:**
   - **Full-Time:** Monthly Salary (e.g., `25000`)
   - **Part-Time:** Hours Worked + Hourly Rate
   - **Intern:** Stipend Amount

5. **Enter Additional Components:**
   - Days Worked (e.g., `28`)
   - Sick Leave Days (e.g., `2`)
   - Night Shift Allowance (e.g., `2000`)
   - Shift Allowance (e.g., `1500`)
   - Other Allowances (e.g., `500`)
   - Bonus (e.g., `5000`)

6. **View Results:**
   - Detailed salary breakdown for each employee
   - Monthly payroll summary
   - Total payroll amount

---

## 📊 Salary Calculation Formula

### **Total Salary = Base Salary + Leave Encashment + Allowances + Bonus**

Where:
- **Base Salary** = Adjusted for days worked
- **Leave Encashment** = `(Base Salary / 30) × (Sick Leave Days - 5)`
  - 5 days are protected (not encashed)
- **Allowances** = Night Shift + Shift + Other Allowances
- **Bonus** = Fixed or performance-based amount

---

## 📋 Example Run

```
===============================================
     EMPLOYEE PAYROLL MANAGEMENT SYSTEM
===============================================

--- EMPLOYEE 1 ---
Enter Employee Name: Sunny
Enter Employee ID: 101
Enter Employee Type (1=Full-Time, 2=Part-Time, 3=Intern): 1
Enter Monthly Salary: 50000
Enter Days Worked: 28
Enter Sick Leave Days: 3
Enter Night Shift Allowance: 2000
Enter Shift Allowance: 1500
Enter Other Allowances: 500
Enter Bonus: 5000

[Similar input for Employees 2 and 3...]

===============================================
       SALARY BREAKDOWNS FOR ALL EMPLOYEES
===============================================

========== SALARY BREAKDOWN ==========
Name: Sunny | ID: 101
Days Worked: 28
Sick Leave Days: 3
Base Salary: Rs. 46666.67
Leave Encashment: Rs. 333.33
Night Shift Allowance: Rs. 2000.00
Shift Allowance: Rs. 1500.00
Other Allowances: Rs. 500.00
Bonus: Rs. 5000.00
================================
TOTAL SALARY: Rs. 56000.00
=====================================

===============================================
               MONTHLY PAYROLL SUMMARY
===============================================
Sunny                : Rs. 56000.00
Rahul                : Rs. 38500.00
Priya                : Rs. 16000.00
-----------------------------------------------
TOTAL PAYROLL        : Rs. 110500.00
===============================================
```

---

## 🔧 Technologies & Concepts

- **Language:** Java
- **OOP Concepts:** Inheritance, Polymorphism, Abstraction, Encapsulation
- **Input/Output:** Scanner class, System.out.printf()
- **Data Structures:** Arrays

---

## 📝 Code Highlights

### Abstract Class with Interface
```java
abstract class Employee {
    abstract double calculateBaseSalary();
    double calculateSalary() {
        // Complex calculation with multiple components
    }
}
```

### Method Overriding
```java
class FullTimeEmployee extends Employee {
    @Override
    double calculateBaseSalary() {
        return (monthlySalary / 30) * daysWorked;
    }
}
```

---

## 🎯 Future Enhancements

- [ ] Tax calculations
- [ ] Deductions management
- [ ] File I/O for employee records
- [ ] Database integration
- [ ] GUI interface
- [ ] Report generation (PDF/Excel)
- [ ] Employee attendance tracking
- [ ] Multi-month payroll history

---

## 📄 License
This project is open-source and available under the MIT License.

---

## 👨‍💻 Author
**Nolexx07** - GitHub

## 📞 Support
For issues or queries, please open an issue on GitHub.

---

**Last Updated:** April 5, 2026
