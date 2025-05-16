package com.util.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.customexception.ExceptionMessages;
import com.util.customexception.TaskException;

public class DependentDAO {

    private ConnectionManager connectionManager = new ConnectionManager();

    // Create Dependent table
    public void createDependentTable() throws TaskException {
        String sql = "CREATE TABLE IF NOT EXISTS Dependent (\n" +
                "    DEPENDENT_ID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    EMPLOYEE_ID INT,\n" +
                "    AGE INT,\n" +
                "    LOCATION VARCHAR(50),\n" +
                "    FOREIGN KEY (EMPLOYEE_ID) REFERENCES Employee(EMPLOYEE_ID)\n" +
                "        ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ")";

        executeUpdate(sql, ExceptionMessages.TABLE_CREATION_FAILED);
    }

    // Add dependent record
    public int addDependent(Dependent dependent) throws TaskException {
        String sql = "INSERT INTO Dependent (EMPLOYEE_ID, AGE, LOCATION) VALUES (?, ?, ?)";
        
        try (PreparedStatement pstmt = prepareStatement(sql)) {
            pstmt.setInt(1, dependent.getEmployeeId());
            pstmt.setInt(2, dependent.getAge());
            pstmt.setString(3, dependent.getRelationship());
            return pstmt.executeUpdate();
        } 
        catch (SQLException e) {
            throw new TaskException(ExceptionMessages.DEPENDENT_ADD_FAILED, e);
        }
    }

    // Get dependents for an employee (by employee ID)
    public List<Dependent> getDependentsByEmployee(int employeeId) throws TaskException {
        List<Dependent> dependents = new ArrayList<>();
        String sql = "SELECT d.*, e.NAME AS EMPLOYEE_NAME FROM Dependent d " +
                     "JOIN Employee e ON d.EMPLOYEE_ID = e.EMPLOYEE_ID " +
                     "WHERE d.EMPLOYEE_ID = ?";
        try (PreparedStatement pstmt = prepareStatement(sql)) {
            pstmt.setInt(1, employeeId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    dependents.add(mapDependentResultSet(rs));
                }
            }
        } 
        catch (SQLException e) {
            throw new TaskException(ExceptionMessages.DEPENDENT_RETRIEVAL_FAILED, e);
        }
        return dependents;
    }

    // Get dependents for an employee (by exact employee name)
    public List<Dependent> getDependentsByEmployeeName(String employeeName) throws TaskException {
        List<Dependent> dependents = new ArrayList<>();
        String sql = "SELECT d.*, e.NAME AS EMPLOYEE_NAME FROM Dependent d " +
                     "JOIN Employee e ON d.EMPLOYEE_ID = e.EMPLOYEE_ID " +
                     "WHERE e.NAME = ?";
        
        try (PreparedStatement pstmt = prepareStatement(sql)) {
            pstmt.setString(1, employeeName);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    dependents.add(mapDependentResultSet(rs));
                }
            }
        } 
        
        catch (SQLException e) {
            throw new TaskException(ExceptionMessages.DEPENDENT_RETRIEVAL_FAILED, e);
        }
        return dependents;
    }

    // Get dependents for the first N employees sorted by employee name
    public List<Dependent> getDependentsForFirstNEmployeesSorted(int reqTotal) throws TaskException {
        List<Dependent> dependents = new ArrayList<>();
        
        String sql = "SELECT d.*, e.NAME AS EMPLOYEE_NAME FROM Dependent d " +
                     "JOIN Employee e ON d.EMPLOYEE_ID = e.EMPLOYEE_ID " +
                     "ORDER BY e.NAME ASC LIMIT ?";
        
        try (PreparedStatement pstmt = prepareStatement(sql)) {
            pstmt.setInt(1, reqTotal);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    dependents.add(mapDependentResultSet(rs));
                }
            }
        }
        catch (SQLException e) {
            throw new TaskException(ExceptionMessages.DEPENDENT_RETRIEVAL_FAILED, e);
        }
        return dependents;
    }

    // Map ResultSet to Dependent object
    private Dependent mapDependentResultSet(ResultSet rs) throws SQLException {
        int employeeId = rs.getInt("EMPLOYEE_ID");
        String employeeName = rs.getString("EMPLOYEE_NAME");
        int dependentId = rs.getInt("DEPENDENT_ID");
        int age = rs.getInt("AGE");
        String relationship = rs.getString("LOCATION");
       
        return new Dependent(employeeId, employeeName, dependentId, age, relationship);
    }

    // Execute an SQL update query
    private void executeUpdate(String sql, String errorMessage) throws TaskException {
        connectionManager.init_connection();
        try (var stmt = connectionManager.getConnection().createStatement()) {
            stmt.execute(sql);
        }
        catch (SQLException e) {
            throw new TaskException(errorMessage, e);
        } 
        finally {
            connectionManager.stop_connection();
        }
    }

    // Prepare a statement
    private PreparedStatement prepareStatement(String sql) throws SQLException, TaskException {
        connectionManager.init_connection();
        return connectionManager.getConnection().prepareStatement(sql);
    }
}