package com.util.inheritance;

import java.util.Scanner;

import com.util.customexception.TaskException;

public class InheritRunner {
	
	
    

    private static String processSwift(Swift swift) {
        return "Processing Swift object";
    }
    

    private static  void handleSwiftDemo() {
        Swift swift = new Swift();
        swift.setYearOfMake(2020);
        swift.setEngineNumber("SW123");
        swift.setType("Hatchback");
        swift.setSeats(5);
        swift.setAirbags(2);
        swift.setModel("Desire");
        swift.setColor("Red");
        System.out.println("Swift Details:");
        System.out.println(swift.getYearOfMake());
        System.out.println(swift.getEngineNumber());
        System.out.println(swift.getType());
        System.out.println(swift.getSeats());
        System.out.println(swift.getAirbags());
        System.out.println(swift.getModel());
        System.out.println(swift.getColor());
    }

    private static  void handleSCrossDemo() {
        SCross scross = new SCross();
        scross.setYearOfMake(2021);
        scross.setEngineNumber("SC456");
        scross.setType("Sedan");
        scross.setSeats(5);
        scross.setAirbags(4);
        scross.setModel("SX4");
        scross.setColor("Blue");
        System.out.println("SCross Details:");
        System.out.println(scross.getYearOfMake());
        System.out.println(scross.getEngineNumber());
        System.out.println(scross.getType());
        System.out.println(scross.getSeats());
        System.out.println(scross.getAirbags());
        System.out.println(scross.getModel());
        System.out.println(scross.getColor());
    }

    private static void handleCarTypes() throws TaskException {
        Swift swift2 = new Swift();
        XUV xuv = new XUV();
        SCross scross2 = new SCross();
        System.out.println("Car Types:");
        System.out.println(Car.identifyCar(swift2));
        System.out.println(Car.identifyCar(xuv));
        System.out.println(Car.identifyCar(scross2));
    }

    private static void handleSwiftProcessing() {
        Swift swift3 = new Swift();
        System.out.println(processSwift(swift3));
        Car carSwift = new Swift();
        // processSwift(carSwift); // Compilation error
    }

    private static void handleMaintenanceDemo() {
        SCross scross3 = new SCross();
        Car carSCross = new SCross();
        Car car = new Car();
        Swift swift4 = new Swift();
        System.out.println("Maintenance Demo:");
        System.out.println(scross3.maintenance());
        System.out.println(carSCross.maintenance());
        System.out.println(car.maintenance());
        System.out.println(swift4.maintenance());
    }

    private static void handleXUVConstructorDemo() throws TaskException  {
        System.out.println("XUV Constructor Demo:");
        XUV xuv2 = new XUV();
        // XUV xuv3 = new XUV("Hello Overloaded subclass");  Error: The constructor XUV(String) is undefined.
    }

    private static void handleBirdAbstractDemo() {
        // BirdAbstract bird = new BirdAbstract();  Error: Abstract class cannot be initiated.
        ParrotMod parrot = new ParrotMod();
        System.out.println("Parrot Demo:");
        System.out.println(parrot.fly());
        System.out.println(parrot.speak());
    }

    private static void handleDuckDemo() {
        Duck duck = new Duck();
        System.out.println("Duck Demo:");
        System.out.println(duck.fly());
        System.out.println(duck.speak());
    }
    
    // To print options
    private static void printOptions()
    {
    	System.out.println("\nSelect a task (1-10, 0 to exit):");
        System.out.println("1. Swift instance demo");
        System.out.println("2. SCross instance demo");
        System.out.println("3. Identify car types");
        System.out.println("4. Process Swift demo");
        System.out.println("5. Maintenance demo");
        System.out.println("6. XUV constructor demo");
        System.out.println("7. BirdAbstract demo");
        System.out.println("8. Duck demo");

    	
    }

    
    
    
    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            printOptions();
        	
            int choice = scanner.nextInt();
            if (choice == 0) break;

            try {
                switch (choice) {
                    case 1: // Task 2
                        handleSwiftDemo();
                        break;

                    case 2: // Task 3
                        handleSCrossDemo();
                        break;

                    case 3: // Tasks 4 & 5
                        handleCarTypes();
                        break;

                    case 4: // Task 6
                        handleSwiftProcessing();
                        break;

                    case 5: // Task 7
                        handleMaintenanceDemo();
                        break;

                    case 6: // Task 8
                        handleXUVConstructorDemo();
                        break;

                    case 7: // Task 9
                        handleBirdAbstractDemo();
                        break;

                    case 8: // Task 10
                        handleDuckDemo();
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
        scanner.close();
    }
}