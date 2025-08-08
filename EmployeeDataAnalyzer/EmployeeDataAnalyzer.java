package AdvancedJava.Week3.EmployeeDataAnalyzer;

/*
    -> EmployeeDataAnalyzer.java:
        This is the entry point of our system. It demonstrates how to add
        employees, process their data using threads, filter and sort employees,
        and handle errors. The main class uses EmployeeManager to manage
        employees and EmployeeProcessor to process them concurrently.
*/

import java.util.List;

public class EmployeeDataAnalyzer {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();

        // Adding employees to the system
        employeeManager.addEmployee(new Employee(1, "Aryan", "Engineering", 175000.0));
        employeeManager.addEmployee(new Employee(2, "Varun", "Marketing", 68000.0));
        employeeManager.addEmployee(new Employee(3, "Nitesh", "Engineering", 80000.0));
        employeeManager.addEmployee(new Employee(4, "Nikhil", "HR", 55000.0));

        // Simulate multithreading: Processing employee by ID
        Thread processor1 = new EmployeeProcessor(employeeManager, 1);
        Thread processor2 = new EmployeeProcessor(employeeManager, 2);
        Thread processor3 = new EmployeeProcessor(employeeManager, 5);  // Non-existing employee

        processor1.start();
        processor2.start();
        processor3.start();

        // Wait for threads to complete
        try {
            processor1.join();
            processor2.join();
            processor3.join();
        } catch (InterruptedException e) {
            System.out.println("Error waiting for thread completion: " + e.getMessage());
        }

        // Filtering employees based on salary
        System.out.println("\nEmployees with salary >= 70000:");
        List<Employee> highEarners = employeeManager.filterEmployeesBySalary(70000.0);
        highEarners.forEach(System.out::println);

        // Sorting employees by salary
        System.out.println("\nEmployees sorted by salary:");
        List<Employee> sortedEmployees = employeeManager.sortEmployeesBySalary();
        sortedEmployees.forEach(System.out::println);
    }
}

/*
    -> Explanation:
        * This class is an entry point that drives the full application.
        * Creates an instance of EmployeeManager.
        * Adds four sample employees.
        * Creates and starts three threads (EmployeeProcessor) to simulate concurrent access.
        * Uses join() to ensure the main thread waits for all processors to finish.
        * Filters and prints employees with salary ≥ 70000.
        * Sorts and prints all employees by salary.
*/