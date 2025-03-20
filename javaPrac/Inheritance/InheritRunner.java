import java.util.Scanner;

public class InheritRunner {
    private static String identifyCar(Car car) {
        if (car instanceof Swift) {
            return "Hatch";
        } else if (car instanceof XUV) {
            return "SUV";
        } else if (car instanceof SCross) {
            return "Sedan";
        }
        return "Unknown";
    }

    private static String processSwift(Swift swift) {
        return "Processing Swift object";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nSelect a task (1-10, 0 to exit):");
            System.out.println("1. Swift instance demo");
            System.out.println("2. SCross instance demo");
            System.out.println("3. Identify car types");
            System.out.println("4. Process Swift demo");
            System.out.println("5. Maintenance demo");
            System.out.println("6. XUV constructor demo");
            System.out.println("7. BirdAbstract demo");
            System.out.println("8. Duck demo");

            int choice = scanner.nextInt();
            if (choice == 0) break;

            try {
                switch (choice) {
                    case 1: // Task 2
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
                        break;

                    case 2: // Task 3
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
                        break;

                    case 3: // Tasks 4 & 5
                        Swift swift2 = new Swift();
                        XUV xuv = new XUV();
                        SCross scross2 = new SCross();
                        System.out.println("Car Types:");
                        System.out.println(identifyCar(swift2));
                        System.out.println(identifyCar(xuv));
                        System.out.println(identifyCar(scross2));
                        break;

                    case 4: // Task 6
                        Swift swift3 = new Swift();
                        System.out.println(processSwift(swift3));
                        Car carSwift = new Swift();
                        // processSwift(carSwift); // Compilation error
                        break;

                    case 5: // Task 7
                        SCross scross3 = new SCross();
                        Car carSCross = new SCross();
                        Car car = new Car();
                        Swift swift4 = new Swift();
                        System.out.println("Maintenance Demo:");
                        System.out.println(scross3.maintenance());
                        System.out.println(carSCross.maintenance());
                        System.out.println(car.maintenance());
                        System.out.println(swift4.maintenance());
                        break;

                    case 6: // Task 8
                        System.out.println("XUV Constructor Demo:");
                        XUV xuv2 = new XUV();
                        break;

                    case 7: // Task 9
                        ParrotMod parrot = new ParrotMod();
                        System.out.println("Parrot Demo:");
                        System.out.println(parrot.fly());
                        System.out.println(parrot.speak());
                        break;

                    case 8: // Task 10
                        Duck duck = new Duck();
                        System.out.println("Duck Demo:");
                        System.out.println(duck.fly());
                        System.out.println(duck.speak());
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
