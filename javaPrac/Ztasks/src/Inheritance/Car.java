package Inheritance;

import com.util.customexception.*;

public class Car {
    private int yearOfMake;
    private String engineNumber;
    private String type;

    public Car() {}
    
    public Car(String message) throws TaskException {
        throw new TaskException(message);
    }

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
