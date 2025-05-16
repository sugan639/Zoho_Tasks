package com.util.jdbc;

public class Employee {
    private int employeeId;
    private String name;
    private String mobile;
    private String email;
    private String department;

    // Constructor
    public Employee(int employeeId, String name, String mobile, String email, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.department = department;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    // Setters (if needed)
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // toString method for debugging or printing
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
