package com.util.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.util.customexception.ExceptionMessages;
import com.util.customexception.TaskException;

public class EmployeeDAO {

    private ConnectionManager connectionManager = new ConnectionManager();

    // Create Employee table
    public void createEmployeeTable() throws TaskException {
        String sql = "CREATE TABLE IF NOT EXISTS Employee (" +
                "EMPLOYEE_ID INT AUTO_INCREMENT PRIMARY KEY, " +
                "NAME VARCHAR(100) NOT NULL, " +
                "MOBILE VARCHAR(15), " +
                "EMAIL VARCHAR(100), " +
                "DEPARTMENT VARCHAR(100)" +
                ")";

        executeUpdate(sql, ExceptionMessages.TABLE_CREATION_FAILED);
    }

    // Add employee record
    public void addEmployee(Employee employee) throws TaskException {
        String sql = "INSERT INTO Employee (NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getMobile());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getDepartment());
            pstmt.executeUpdate();
        } 
        catch (SQLException e) {
            throw new TaskException(ExceptionMessages.EMPLOYEE_ADD_FAILED, e);
        }
    }

   
    // Retrieve employee details by exact name
    public List<Employee> getEmployeeByName(String name) throws TaskException {
       
    	List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee WHERE NAME = ?";
        
        try (PreparedStatement pstmt = prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    employees.add(mapEmployeeResultSet(rs));
                }
            }
        } catch (SQLException e) {
            throw new TaskException(ExceptionMessages.EMPLOYEE_RETRIEVAL_FAILED, e);
        }
        return employees;
    }

    // Update employee details
    public void updateEmployee(int employeeId, Employee employee) throws TaskException {
        String sql = "UPDATE Employee SET MOBILE = ?, EMAIL = ?, DEPARTMENT = ? WHERE EMPLOYEE_ID = ?";
        
        try (PreparedStatement pstmt = prepareStatement(sql)) {
            pstmt.setString(1, employee.getMobile());
            pstmt.setString(2, employee.getEmail());
            pstmt.setString(3, employee.getDepartment());
            pstmt.setInt(4, employeeId);
            pstmt.executeUpdate();
        } 
        catch (SQLException e) {
            throw new TaskException(ExceptionMessages.EMPLOYEE_UPDATE_FAILED, e);
        }
    }

    // Get first N employees
    public List<Employee> getFirstNEmployees(int reqTotal) throws TaskException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee LIMIT ?";
        
        try (PreparedStatement pstmt = prepareStatement(sql)) {
            pstmt.setInt(1, reqTotal);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    employees.add(mapEmployeeResultSet(rs));
                }
            }
        } catch (SQLException e) {
            throw new TaskException(ExceptionMessages.EMPLOYEE_RETRIEVAL_FAILED, e);
        }
        return employees;
    }

    // Get first N employees sorted by name
    public List<Employee> getFirstNEmployeesSorted(int reqTotal, boolean ascending) throws TaskException {
        List<Employee> employees = new ArrayList<>();
        
        String order = ascending ? "ASC" : "DESC";
        String sql = "SELECT * FROM Employee ORDER BY NAME " + order + " LIMIT ?";
        
        try (PreparedStatement pstmt = prepareStatement(sql)) {
            pstmt.setInt(1, reqTotal);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    employees.add(mapEmployeeResultSet(rs));
                }
            }
        } catch (SQLException e) {
            throw new TaskException(ExceptionMessages.EMPLOYEE_RETRIEVAL_FAILED, e);
        }
        return employees;
    }

    // Delete an employee by ID
    public void deleteEmployee(int employeeId) throws TaskException {
        String sql = "DELETE FROM Employee WHERE EMPLOYEE_ID = ?";
        
        try (PreparedStatement pstmt = prepareStatement(sql)) {
            pstmt.setInt(1, employeeId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new TaskException(ExceptionMessages.EMPLOYEE_DELETE_FAILED, e);
        }
    }

    // Map ResultSet to Employee object
    private Employee mapEmployeeResultSet(ResultSet rs) throws SQLException {
        int employeeId = rs.getInt("EMPLOYEE_ID");
        String name = rs.getString("NAME");
        String mobile = rs.getString("MOBILE");
        String email = rs.getString("EMAIL");
        String department = rs.getString("DEPARTMENT");
        return new Employee(employeeId, name, mobile, email, department);
    }

    // Execute an SQL update query
    private void executeUpdate(String sql, String errorMessage) throws TaskException {
        connectionManager.init_connection();
        
        try (Statement stmt = connectionManager.getConnection().createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new TaskException(errorMessage, e);
        } finally {
            connectionManager.stop_connection();
        }
    }

    // Prepare a statement
    private PreparedStatement prepareStatement(String sql) throws SQLException, TaskException {
        connectionManager.init_connection();
        return connectionManager.getConnection().prepareStatement(sql);
    }
}