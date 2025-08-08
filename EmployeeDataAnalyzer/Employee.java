package AdvancedJava.Week3.EmployeeDataAnalyzer;

/*
    -> Employee.java:
        This class is used to represent an employee. Each employee has an ID,
        a name, a department, and a salary. The salary is wrapped in an Optional
        to handle cases where the salary might be missing.
*/

import java.util.Optional;

public class Employee {

    private final int id;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Optional<Double> getSalary() {
        // return Optional.ofNullable(salary); // this or below one, any can be used.
        return Optional.of(salary);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name +
                "', department:'" + department + "', salary:" + salary + '}';
    }
}

/*
    -> Explanation:
        * Contains private fields: id, name, department, salary.
        * Constructor is used to initializes the fields.
        * Getter methods return field values.
        * getSalary() uses Optional.ofNullable() [or Optional.of()] to safely handle null salary values.
        * toString() is overridden for clean object output (used in System.out.println())
*/
