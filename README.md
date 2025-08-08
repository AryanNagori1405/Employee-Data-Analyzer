# Employee Data Analyzer System
This Java application demonstrates concurrent employee data processing using multithreading, Optional for null safety, custom exception handling, and stream-based filtering/sorting.<br>

## Key Features :

### Employee Management
-> Stores employee data (ID, name, department, salary) in a thread-safe manner.<br>
-> Uses Optional<Double> to handle potential missing salary values safely.<br>

### Concurrent Processing
-> EmployeeProcessor extends Thread to process employees in parallel.<br>
-> Gracefully handles missing employees with clear error messages.<br>

### Data Analysis
-> Filters employees by minimum salary using Java Streams.<br>
-> Sorts employees by salary in ascending order.<br>

### Error Handling
-> Custom EmployeeNotFoundException for robust error management.<br>

## How It Works :

### Employee.java
-> Immutable class representing an employee with Optional salary handling.<br>

### EmployeeManager.java
-> Manages employee data in a HashMap.<br>
-> Provides methods for adding, retrieving, filtering, and sorting employees.<br>

### EmployeeProcessor.java
-> Processes employees concurrently using threads.<br>
-> Uses ifPresentOrElse() to handle missing employees elegantly.<br>

### EmployeeDataAnalyzer.java
-> Entry point that:<br>
  * Adds sample employees.<br>
  * Runs multiple threads for concurrent processing.<br>
  * Filters high-earning employees (salary ≥ 70,000).<br>
  * Sorts employees by salary.<br>

## Why This Matters :
-> Demonstrates real-world Java concepts like multithreading, Optional, and Streams.<br>
-> Shows clean error handling with custom exceptions.<br>
-> Provides a scalable way to manage and analyze employee data.<br>

## Technologies Used :
-> Java (Collections, Concurrency, Streams, Optional)<br>
-> Object-Oriented Programming (OOP)<br>
-> Exception Handling<br>

This project is ideal for learning intermediate-to-advanced Java concepts in a practical, structured way. 🚀

