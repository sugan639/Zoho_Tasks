package com.util.inheritance;

public class Car {
    private int yearOfMake;
    private String engineNumber;
    private String type;

    public Car() {}
    
    public Car(String message)  {
    	System.out.println(message);
    }
    
    
    // Identify car method 
    public static String identifyCar(Car car) {
        if (car instanceof Swift) {
            return "Hatch";
        } else if (car instanceof XUV) {
            return "SUV";
        } else if (car instanceof SCross) {
            return "Sedan";
        }
        return "Unknown";
    }

    
    // Getters and setters
    public int getYearOfMake() {
    	 return yearOfMake; 
    	 }
    public void setYearOfMake(int yearOfMake) {
    	 this.yearOfMake = yearOfMake; 
    	 }
    public String getEngineNumber() { 
    	return engineNumber; 
    	}
    public void setEngineNumber(String engineNumber) { 
    	this.engineNumber = engineNumber; 
    	}
    public String getType() { 
    	return type; 
    	}
    public void setType(String type) { 
    	this.type = type;
    	 }

    public String maintenance() {
        return "Car under maintenance";
    }
}
