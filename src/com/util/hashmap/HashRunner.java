package com.util.hashmap;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.util.helpers.Helper;

public class HashRunner {
    private static final Scanner scanner = new Scanner(System.in);
    private static HashTasks hashTasks = new HashTasks();
    private static Map<Object, Object> currentMap =  hashTasks.createHashMap();

    public static void main(String[] args) {  // Main starts here
        
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getChoice();

            try {
                switch (choice) {
                    case 1: // Create HashMap
                        currentMap = hashTasks.createHashMap();
                        System.out.println("New HashMap created.");
                        break;
                    case 2: // Add key-value pair
                        addKeyValuePair();
                        break;
                    case 3: // Check key exists
                        checkKeyExists();
                        break;
                    case 4: // Check value exists
                        checkValueExists();
                        break;
                    case 5: // Change all values
                        changeValues();
                        break;
                    case 6: // Get default value for non-existing key
                        getDefaultValue();
                        break;
                    case 7: // Remove existing key
                        removeExistingKey();
                        break;
                    case 8: // Remove key if value matches
                        removeKeyWithMatchingValue();
                        break;
                    case 9: // Replace value
                        replaceValue();
                        break;
                    case 10: // Replace value if matches old
                        replaceValueIfMatching();
                        break;
                    case 11: // Transfer maps
                        transferMaps();
                        break;
                    case 12: // Iterate map
                        iterateMap();
                        break;
                    case 13: // Clear map
                        removeAllEntries();
                        break;
                    case 14: // Exit
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            } 
        }
        scanner.close();
    }	// Main ends
    
    
    
    
    
    
    
    
    

    private static void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Create HashMap");
        System.out.println("2. Add key-value pair");
        System.out.println("3. Check key exists");
        System.out.println("4. Check value exists");
        System.out.println("5. Change all values");
        System.out.println("6. Get default value for non-existing key");
        System.out.println("7. Remove existing key");
        System.out.println("8. Remove key if value matches");
        System.out.println("9. Replace value");
        System.out.println("10. Replace value if matches old");
        System.out.println("11. Transfer maps");
        System.out.println("12. Iterate map");
        System.out.println("13. Clear map");
        System.out.println("14. Exit");
    }

    private static int getChoice() {
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static Object getInput(String type) {
        System.out.print("Enter the type of " + type + " (String/Integer/Double/null): ");
        String inputType = scanner.nextLine().trim().toLowerCase();

        if ("null".equalsIgnoreCase(inputType)) {
            return null;
        }

        System.out.print("Enter the " + type + " (or 'null'): ");
        String inputValue = scanner.nextLine().trim();

        if ("null".equalsIgnoreCase(inputValue)) {
            return null;
        }

        switch (inputType) {
            case "string":
                return inputValue;
            case "integer":
                return Integer.parseInt(inputValue);
            case "double":
                return Double.parseDouble(inputValue);
            default:
                throw new IllegalArgumentException("Unsupported type: " + inputType);
        }
    }
    //1-7
    private static void addKeyValuePair() throws Exception {
        Object key = getInput("key");
        Object value = getInput("value");
        currentMap = hashTasks.addKeyValuePair(currentMap, key, value);
        
        int mapSize = Helper.getMapSize(currentMap);
        System.out.println("Key-value pair added. Map size: "+mapSize);
        iterateMap();
    }
    //8
    private static void checkKeyExists() throws Exception {
        Object key = getInput("key");
        boolean exists = hashTasks.checkKeyExists(currentMap, key);
        System.out.println("Key exists: " + exists);
    }
    //9
    private static void checkValueExists() throws Exception {
        Object value = getInput("value");
        boolean exists = hashTasks.checkValueExists(currentMap, value);
        System.out.println("Value exists: " + exists);
    }
    //10
    private static void changeValues() throws Exception {
        Object newValue = getInput("new value");
        int beforeSize = Helper.getMapSize(currentMap);
        System.out.println("Before change size: "+ beforeSize);
        currentMap = hashTasks.changeValues(currentMap, newValue);
        int afterSize = Helper.getMapSize(currentMap);
        System.out.println("After change size: "+ afterSize);
        System.out.println("All values updated.");
        iterateMap();
    }
    //13
    private static void getDefaultValue() throws Exception {
        Object key = getInput("key");
        Object defaultValue = getInput("default value");
        Object result = hashTasks.getDefaultValueForNonExistingKey(currentMap, key, defaultValue);
        System.out.println("Value: " + result);
        iterateMap();
    }
    //14
    private static void removeExistingKey() throws Exception {
        Object key = getInput("key");
        currentMap = hashTasks.removeExistingKey(currentMap, key);
        System.out.println("Key removed.");
        iterateMap();
    }
    //15
    private static void removeKeyWithMatchingValue() throws Exception {
        Object key = getInput("key");
        Object value = getInput("value");
        currentMap = hashTasks.removeKeyWithMatchingValue(currentMap, key, value);
        System.out.println("Key removed if value matched.");
        iterateMap();
    }
    //16
    private static void replaceValue() throws Exception {
        Object key = getInput("key");
        Object newValue = getInput("new value");
        currentMap = hashTasks.replaceValue(currentMap, key, newValue);
        System.out.println("Value replaced.");
        iterateMap();
    }
    //17
    private static void replaceValueIfMatching() throws Exception {
        Object key = getInput("key");
        Object oldValue = getInput("old value");
        Object newValue = getInput("new value");
        currentMap = hashTasks.replaceValueIfMatching(currentMap, key, oldValue, newValue);
        System.out.println("Value replaced if old value matched.");
        iterateMap();
    }
    //18
    private static void transferMaps() throws Exception {
        Map<Object, Object> newMap = hashTasks.createHashMap();
        newMap.put("K1", "V1");
        newMap.put("K2", "V2");
        currentMap = hashTasks.transferMaps(currentMap, newMap);
        System.out.println("Maps transferred.");
        iterateMap();
    }
    //19
    private static void iterateMap() throws Exception {
        Iterator<Map.Entry<Object, Object>> iterator = hashTasks.getIterator(currentMap);
        System.out.println("Map entries:");
        
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        
        
        int afterSize = Helper.getMapSize(currentMap);
        System.out.println("After change size: "+ afterSize);
      
        
    }
    
    //20
    private static void removeAllEntries() throws Exception {
    	int beforeSize = Helper.getMapSize(currentMap);
        System.out.println("Before change size: "+ beforeSize);
        
        currentMap = hashTasks.removeAllEntries(currentMap);
        System.out.println("Map cleared.");
        
        iterateMap();
        
    }
}