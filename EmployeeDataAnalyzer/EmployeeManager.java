package AdvancedJava.Week3.EmployeeDataAnalyzer;

/*
    -> EmployeeManager.java:
        This class is used to handle employee data. It allows us to add
        employees, retrieve them by ID, filter employees based on salary,
        and sort employees by salary.
*/

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManager {

    private final Map<Integer, Employee> employeeData;

    public EmployeeManager() {
        this.employeeData = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        employeeData.put(employee.getId(), employee);
    }

    public Optional<Employee> getEmployeeById(int id) {
        return Optional.ofNullable(employeeData.get(id));
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeData.values());
    }

    public List<Employee> filterEmployeesBySalary(Double minSalary) {
        return employeeData.values().stream()
                .filter(employee -> employee.getSalary().orElse(0.0) >= minSalary)
                .collect(Collectors.toList());
    }

    public List<Employee> sortEmployeesBySalary() {
        return employeeData.values().stream()
                .sorted(Comparator.comparingDouble(e -> e.getSalary().orElse(0.0)))
                .collect(Collectors.toList());
    }
}

/*
    -> Explanation:
        * employeeData is a HashMap<Integer, Employee> to store employees by ID.
        * addEmployee() method adds a new employee to the map.
        * getEmployeeById(int id) method safely returns an employee using Optional.
        * getAllEmployees() method returns a list of all employees.
        * filterEmployeesBySalary(Double minSalary) method filters employees whose salary ≥ minSalary using Stream.
        * sortEmployeesBySalary() method sorts all employees by their salary using Comparator
*/
