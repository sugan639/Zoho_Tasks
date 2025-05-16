package com.util.jdbc;

public class Dependent {
    private int employeeId;
    private String employeeName;
    private int dependentId;
    private int age;
    private String relationship;

    public Dependent(int employeeId, String employeeName, int dependentId, int age, String relationship) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.dependentId = dependentId;
        this.age = age;
        this.relationship = relationship;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getDependentId() {
        return dependentId;
    }

    public int getAge() {
        return age;
    }

    public String getRelationship() {
        return relationship;
    }

    @Override
    public String toString() {
        return "DependentDetails{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", dependentId=" + dependentId +
                ", age=" + age +
                ", relationship='" + relationship + '\'' +
                '}';
    }
}