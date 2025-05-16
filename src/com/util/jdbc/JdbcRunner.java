package com.util.jdbc;

import java.util.List;
import java.util.Scanner;

import com.util.customexception.TaskException;
import com.util.regex.RegexCore;
import com.util.regex.RegexPattern;

public class JdbcRunner {

    private static final Scanner scanner = new Scanner(System.in);
    RegexCore regex =  new RegexCore();
   
    private static final JdbcRunner runner = new JdbcRunner();
    
    public static void main(String[] args) {
        JdbcCore jdbcCore = new JdbcCore();
        

        try {
            // Initialize tables
            jdbcCore.createEmployeeTable();
            jdbcCore.createDependentTable();

            while (true) {
                // Display menu
                System.out.println("\n--- MENU ---");
                System.out.println("1. Add Employee");
                System.out.println("2. Search Employee by Name");
                System.out.println("3. Update Employee Details");
                System.out.println("4. Print First N Employees");
                System.out.println("5. Print First N Employees Sorted by Name");
                System.out.println("6. Delete an Employee");
                System.out.println("7. Add Dependent");
                System.out.println("8. View Dependents for an Employee (by ID)");
                System.out.println("9. View Dependents for First N Employees.");
                System.out.println("10. Exit");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                    	runner.addEmployee(jdbcCore);
                        break;
                    case 2:
                    	runner.searchEmployeeByName(jdbcCore);
                        break;
                    case 3:
                    	runner.updateEmployeeDetails(jdbcCore);
                        break;
                    case 4:
                    	runner.printFirstNEmployees(jdbcCore);
                        break;
                    case 5:
                    	runner.printFirstNEmployeesSorted(jdbcCore);
                        break;
                    case 6:
                    	runner.deleteEmployee(jdbcCore);
                        break;
                    case 7:
                    	runner.addDependent(jdbcCore);
                        break;
                    case 8:
                    	runner.viewDependentsForEmployeeById(jdbcCore);
                        break;
                    case 9:
                    	runner.viewDependentsForFirstNEmployeesSorted(jdbcCore);
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        main(args);
                }
            }

        } catch (TaskException e) {
            System.err.println(e.getMessage());
            main(args);
        }
       
    }

    private void addEmployee(JdbcCore jdbcCore) throws TaskException {
        System.out.println("Enter employee details:");
        Employee employee = getEmployeeFromInput();
        jdbcCore.addEmployee(employee);
        System.out.println("Employee added successfully!");
    }

    private void searchEmployeeByName(JdbcCore jdbcCore) throws TaskException {
        System.out.print("Enter employee name to search: ");
        String name = scanner.nextLine();
        List<Employee> employees = jdbcCore.getEmployeeByName(name);
        if (employees.isEmpty()) {
            System.out.println("No employees found with the given name.");
        } else {
            employees.forEach(System.out::println);
        }
    }

    private void updateEmployeeDetails(JdbcCore jdbcCore) throws TaskException {
        System.out.print("Enter employee ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Employee employee = getEmployeeFromInput();
        jdbcCore.updateEmployee(id, employee);
        System.out.println("Employee details updated successfully!");
    }

    private void printFirstNEmployees(JdbcCore jdbcCore) throws TaskException {
        System.out.print("Enter N to print first N employees: ");
        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = jdbcCore.getFirstNEmployees(n);
        employees.forEach(System.out::println);
    }

    private void printFirstNEmployeesSorted(JdbcCore jdbcCore) throws TaskException {
        System.out.print("Enter N to print first N employees sorted by name (ascending/descending): ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("Ascending? (true/false): ");
        boolean ascending = Boolean.parseBoolean(scanner.nextLine());
        List<Employee> employees = jdbcCore.getFirstNEmployeesSorted(n, ascending);
        employees.forEach(System.out::println);
    }

    private void deleteEmployee(JdbcCore jdbcCore) throws TaskException {
        System.out.print("Enter employee ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        jdbcCore.deleteEmployee(id);
        System.out.println("Employee deleted successfully!");
    }

    private void addDependent(JdbcCore jdbcCore) throws TaskException {
        System.out.println("Enter dependent details:");
        Dependent dependent = getDependentFromInput();
        if(jdbcCore.addDependent(dependent)>0) {
        System.out.println("Dependent added successfully!");
        }
        else {
            System.out.println("Dependent not available!");

        }
    }

    private void viewDependentsForEmployeeById(JdbcCore jdbcCore) throws TaskException {
        System.out.print("Enter employee ID to view dependents: ");
        int id = Integer.parseInt(scanner.nextLine());
        List<Dependent> dependents = jdbcCore.getDependentsByEmployee(id);
        if (dependents.isEmpty()) {
            System.out.println("No dependents found for the given employee ID.");
        } else {
            dependents.forEach(System.out::println);
        }
    }

    private void viewDependentsForFirstNEmployeesSorted(JdbcCore jdbcCore) throws TaskException {
        System.out.print("Enter N to view dependents for the first N employees sorted by employee name: ");
        int n = Integer.parseInt(scanner.nextLine());
        List<Dependent> dependents = jdbcCore.getDependentsForFirstNEmployeesSorted(n);
        if (dependents.isEmpty()) {
            System.out.println("No dependents found for the first " + n + " employees.");
        } else {
            dependents.forEach(System.out::println);
        }
    }

    private Employee getEmployeeFromInput() throws TaskException {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        regex.isMatchingRegex(name, RegexPattern.ALPHA_NUMERIC_REGEX);
        System.out.print("Mobile: ");
        String mobile = scanner.nextLine();
        regex.isMatchingRegex(mobile, RegexPattern.MOBILE_10_DIGITS);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        regex.isMatchingRegex(email, RegexPattern.EMAIL_REGEX);
        System.out.print("Department: ");
        String department = scanner.nextLine();
        return new Employee(0, name, mobile, email, department); // ID is auto-generated
    }

    private Dependent getDependentFromInput() {
        System.out.print("Employee ID: ");
        int employeeId = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Location: ");
        String relationship = scanner.nextLine();
        return new Dependent(employeeId, "", 0, age, relationship); // Dependent ID is auto-generated
    }
}