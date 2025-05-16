package com.util.jdbc;

import java.util.List;

import com.util.customexception.TaskException;

public class JdbcCore {

    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private DependentDAO dependentDAO = new DependentDAO();

    // Employee Table Operations
    public void createEmployeeTable() throws TaskException {
        employeeDAO.createEmployeeTable();
    }

    public void addEmployee(Employee employee) throws TaskException {
        employeeDAO.addEmployee(employee);
    }

    public List<Employee> getEmployeeByName(String name) throws TaskException {
        return employeeDAO.getEmployeeByName(name);
    }

    public void updateEmployee(int employeeId, Employee employee) throws TaskException {
        employeeDAO.updateEmployee(employeeId, employee);
    }

    public List<Employee> getFirstNEmployees(int id) throws TaskException {
        return employeeDAO.getFirstNEmployees(id);
    }

    public List<Employee> getFirstNEmployeesSorted(int reqTotal, boolean ascending) throws TaskException {
        return employeeDAO.getFirstNEmployeesSorted(reqTotal, ascending);
    }

    public void deleteEmployee(int employeeId) throws TaskException {
        employeeDAO.deleteEmployee(employeeId);
    }

    // Dependent Table Operations
    public void createDependentTable() throws TaskException {
        dependentDAO.createDependentTable();
    }

    public int addDependent(Dependent dependent) throws TaskException {
        return dependentDAO.addDependent(dependent);
    }

    public List<Dependent> getDependentsByEmployee(int employeeId) throws TaskException {
        return dependentDAO.getDependentsByEmployee(employeeId);
    }

    public List<Dependent> getDependentsByEmployeeName(String employeeName) throws TaskException {
        return dependentDAO.getDependentsByEmployeeName(employeeName);
    }

    public List<Dependent> getDependentsForFirstNEmployeesSorted(int reqTotal) throws TaskException {
        return dependentDAO.getDependentsForFirstNEmployeesSorted(reqTotal);
    }
}