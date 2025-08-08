package AdvancedJava.Week3.EmployeeDataAnalyzer;

/*
     -> EmployeeProcessor.java:
        To handle multiple employees at the same time, we use multithreading.
        The EmployeeProcessor class extends Thread to process employee data in
        parallel. If an employee doesn't exist, it will print a helpful error message.
*/

import java.util.Optional;

public class EmployeeProcessor extends Thread {

    private final EmployeeManager employeeManager;
    private final int employeeId;

    public EmployeeProcessor(EmployeeManager employeeManager, int employeeId) {
        this.employeeManager = employeeManager;
        this.employeeId = employeeId;
    }

    @Override
    public void run() {
        try {
            Optional<Employee> employee = employeeManager.getEmployeeById(employeeId);
            employee.ifPresentOrElse(
                    emp -> System.out.println("Processing employee: " + emp),
                    () -> System.out.println("Employee with ID " + employeeId + " not found.")
            );
        } catch (Exception e) {
            System.out.println("Error processing employee data: " + e.getMessage());
        }
    }
}

/*
    -> Explanation:
        * EmployeeProcessor class takes an EmployeeManager and an employee ID as input.
        * Overrides run() to:
            Fetch the employee by ID.
        * Use if PresentOrElse() to either print the employee or log not found.
        * Catch any exception to avoid thread crashes.
*/