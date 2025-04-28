package com.uil.filemanager;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.util.customexception.TaskException;
import com.util.singletons.SingletonManager;
import com.util.timemanager.DateTimeManager;

public class FileRunner {
    private static final Logger LOGGER = Logger.getLogger("LoggerExample");

    // Custom handlers for info and error logs
    private static FileHandler infoFileHandler;
    private static FileHandler errorFileHandler;

    static {
        try {
            LOGGER.setUseParentHandlers(false);

            // Create handlers
            infoFileHandler = new FileHandler("Logger/info.txt", true);
            errorFileHandler = new FileHandler("Logger/error.txt", true);

           
            infoFileHandler.setFormatter(new SimpleFormatter());
            errorFileHandler.setFormatter(new SimpleFormatter());

           
            LOGGER.setLevel(Level.ALL);

            // Filter to log ONLY INFO
            infoFileHandler.setFilter(record -> record.getLevel() == Level.INFO);

            // Filter to log ONLY SEVERE
            errorFileHandler.setFilter(record -> record.getLevel() == Level.SEVERE);

            // Add handlers
            LOGGER.addHandler(infoFileHandler);
            LOGGER.addHandler(errorFileHandler);

           

        } catch (IOException e) {
            e.printStackTrace(); // Avoid logging here since LOGGER might not be ready
        }
    }

    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            FileRunner fileRunner = new FileRunner();
            LOGGER.info("Displaying task menu.");
            System.out.println("Choose a task:");
            System.out.println("1. Create File");
            System.out.println("2. Store Properties");
            System.out.println("3. Load Properties");
            System.out.println("4. Directory and File Operations");
            System.out.println("5. Singleton Task");
            System.out.println("6. Reflection Task");
            System.out.println("7. DataContainer (POJO with Constructor)");
            System.out.println("8. DataContainer (Default Constructor with Setters/Getters)");
            System.out.println("9. Rainbow Colors Enum");
            System.out.println("10. DateTime Operations");
            System.out.println("11. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (choice) {
                    case 1:
                        fileRunner.createFile();
                        break;
                    case 2:
                        fileRunner.storeProperties();
                        break;
                    case 3:
                        fileRunner.loadProperties();
                        break;
                    case 4:
                        fileRunner.directoryAndFileOperations();
                        break;
                    case 5:
                        fileRunner.singletonTask();
                        break;
                    case 6:
                        fileRunner.reflectionTask();
                        break;
                    case 7:
                        fileRunner.dataContainerWithConstructor();
                        break;
                    case 8:
                        fileRunner.dataContainerWithSettersAndGetters();
                        break;
                    case 9:
                        fileRunner.rainbowColorsEnum();
                        break;
                    case 10:
                        fileRunner.dateTimeOperations();
                        break;
                    case 11:
                        LOGGER.info("Exiting application.");
                        System.out.println("Exiting...");
                        return;
                    default:
                        LOGGER.info("Invalid choice entered.");
                }
            } catch (TaskException e) {
            	
                LOGGER.log(Level.SEVERE, "Error in task execution: " + e.getMessage(), e);
            }
        }
    }

    private void createFile() throws TaskException {
        System.out.println("Enter file path:");
        String filePath = scanner.nextLine();
        System.out.println("Enter lines (type 'done' to finish):");
        List<String> lines = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("done")) break;
            lines.add(line);
        }
        new FileCreator().createFile(filePath, lines);
        
        LOGGER.info("File creation task completed.");
    }

    private void storeProperties() throws TaskException {
        System.out.println("Enter properties file path:");
        String filePath = scanner.nextLine();
        Properties properties = new Properties();
        System.out.println("Enter key-value pairs (type 'done' to finish):");
        while (true) {
            System.out.print("Key: ");
            String key = scanner.nextLine();
            if (key.equalsIgnoreCase("done")) break;
            System.out.print("Value: ");
            String value = scanner.nextLine();
            properties.setProperty(key, value);
        }
        new PropertiesManager().storeProperties(filePath, properties, "Stored Properties");
        
        LOGGER.info("Properties storage task completed.");
    }

    private void loadProperties() throws TaskException {
        System.out.println("Enter properties file path:");
        String filePath = scanner.nextLine();
        Properties properties = new PropertiesReader().loadProperties(filePath);
        
        LOGGER.info("Properties loading task completed.");
    }

    private void directoryAndFileOperations() throws TaskException {
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter sample file path:");
        String sampleFilePath = scanner.nextLine();
        System.out.println("Enter lines for sample file ");
        List<String> lines = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("done")) break;
            lines.add(line);
        }
        System.out.println("Enter properties file path:");
        String propsFilePath = scanner.nextLine();
        Properties properties = new Properties();
        System.out.println("Enter key-value pairs for properties (type 'done' to finish):");
        while (true) {
            System.out.print("Key: ");
            String key = scanner.nextLine();
            if (key.equalsIgnoreCase("done")) break;
            System.out.print("Value: ");
            String value = scanner.nextLine();
            properties.setProperty(key, value);
        }
        new DirectoryAndFileManager()
                .createDirectoryAndFiles(dirPath, sampleFilePath, lines,
                        propsFilePath, properties, "Comments");
        
        LOGGER.info("Directory and file operations task completed.");
    }

    private void singletonTask() {
        SingletonManager.INSTANCE.performTask();
        LOGGER.info("Singleton task completed.");
    }

    private void reflectionTask() throws TaskException {
        ReflectionRunner runner = new ReflectionRunner();
        System.out.println("Enter class name for default constructor:");
        String className = scanner.nextLine();
        Object obj = runner.invokeDefaultConstructor(className);
        LOGGER.info("Reflection task completed.");
    }

    private void dataContainerWithConstructor() throws TaskException {
        System.out.println("Enter class name for default constructor (e.g., filerunner.DataContainer):");
        String className = scanner.nextLine();
        ReflectionRunner runner = new ReflectionRunner();
        // Invoke default constructor
        Object obj = runner.invokeDefaultConstructor(className);
        System.out.println("Default constructor invoked successfully. Object created: " + obj);
        LOGGER.info("Default constructor invocation completed successfully");
    }

    private void dataContainerWithSettersAndGetters() {
        DataContainer container = new DataContainer();
        System.out.println("Enter string value:");
        String str = scanner.nextLine();
        System.out.println("Enter integer value:");
        int num = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        container.setStr(str);
        container.setNum(num);
        System.out.println("String: " + container.getStr());
        System.out.println("Integer: " + container.getNum());
        LOGGER.info("DataContainer with setters/getters task completed.");
    }

    private void rainbowColorsEnum() {
        for (RainbowColors color : RainbowColors.values()) {
            System.out.println(color + ": " + color.getCode());
        }
        LOGGER.info("Rainbow colors enum task completed.");
    }

    private void dateTimeOperations() {
        DateTimeManager dateTimeManager = new DateTimeManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a timezone (e.g., Europe/London, America/New_York, Asia/Tokyo): ");
        String zoneInput = scanner.nextLine();
        ZoneId zoneId;
        try {
            zoneId = ZoneId.of(zoneInput);
        } catch (Exception e) {
            System.out.println("Invalid timezone entered. Using system default timezone.");
            zoneId = ZoneId.systemDefault();
        }
        System.out.println("Please enter the date in YYYY-MM-DD format (e.g., 2025-04-08): ");
        String dateInput = scanner.nextLine();
        LocalDate date;
        try {
            date = LocalDate.parse(dateInput);
        } catch (Exception e) {
            System.out.println("Invalid date format. Using current date.");
            date = LocalDate.now(zoneId);
        }
        // Get time input
        System.out.println("Please enter the time in HH:MM format (e.g., 14:30): ");
        String timeInput = scanner.nextLine();
        LocalTime time;
        try {
            time = LocalTime.parse(timeInput);
        } catch (Exception e) {
            System.out.println("Invalid time format. Using current time.");
            time = LocalTime.now(zoneId);
        }
        // Get ZonedDateTime using dstAdjustment
        ZonedDateTime zonedDateTime = dateTimeManager.dstAdjustment(date, time, zoneId);
        // Check DST status
        boolean isDST = zoneId.getRules().isDaylightSavings(zonedDateTime.toInstant());
        long millis = zonedDateTime.toInstant().toEpochMilli();
        // Print results
        System.out.println("\nTime Information for " + zoneId + ":");
        System.out.println("Specified Local Date and Time: " + date + " " + time);
        System.out.println("Zoned DateTime: " + zonedDateTime);
        System.out.println("UTC Offset: " + zonedDateTime.getOffset());
        System.out.println("DST Active: " + (isDST ? "Yes" : "No"));
        System.out.println("Day of the week: " + dateTimeManager.getWeekday(millis, zoneId));
        System.out.println("Month: " + dateTimeManager.getMonth(millis, zoneId));
        LOGGER.info("DateTime operations task completed.");
    }
}