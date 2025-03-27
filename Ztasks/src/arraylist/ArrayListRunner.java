package arraylist;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.util.customexception.TaskException;

public class ArrayListRunner {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayListTasks tasks = new ArrayListTasks();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            if (choice == 15) break;
            executeTask(choice);
        }
        scanner.close();
        System.out.println("Program terminated.");
    }  // Main ends

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void executeTask(int choice) {
        try {
            switch (choice) {
                case 1: 
                    System.out.println("Empty list size: " + tasks.getList());
                    break;
                case 2: 
                    handleAddElements();
                    break;
                case 3: 
                    handleFindIndex();
                    break;
                case 4: 
                    handlePrintList();
                    break;
                case 5: 
                    handleGetElement();
                    break;
                case 6: 
                    handleFindFirstLast();
                    break;
                case 7: 
                    handleAddAtPosition();
                    break;
                case 8: 
                    handleCreateSublist();
                    break;
                case 9: 
                    handleMergeLists();
                    break;
                case 10: 
                    handleRemoveElement();
                    break;
                case 11: 
                    handleRemoveAll();
                    break;
                case 12: 
                    handleRetainAll();
                    break;
                case 13: 
                    handleClearList();
                    break;
                case 14: 
                    handleCheckPresence();
                    break;
                default: 
                    System.out.println("Invalid choice! Please select between 1 and 15.");
                    break; 
            }
        } catch (TaskException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== ArrayList Tasks Menu ===");
        System.out.println("1. Get empty list size");
        System.out.println("2. Add elements");
        System.out.println("3. Find index of element");
        System.out.println("4. Print using iterator and for loop");
        System.out.println("5. Get element at index");
        System.out.println("6. Find first and last position");
        System.out.println("7. Add element at position");
        System.out.println("8. Create sublist");
        System.out.println("9. Merge two lists");
        System.out.println("10. Remove element at index");
        System.out.println("11. Remove all present in second list");
        System.out.println("12. Retain all present in second list");
        System.out.println("13. Clear list");
        System.out.println("14. Check element presence");
        System.out.println("15. Exit");
        System.out.print("Enter your choice (1-15): ");
    }

    private static List<Object> getUserList() {
    	ArrayListTasks task = new ArrayListTasks();
        List<Object> list = task.getList();
        System.out.println("Available datatypes: 1. Integer, 2. Double, 3. String");
        System.out.print("How many datatypes do you want to enter? ");
        int typeCount;
        try {
            typeCount = Integer.parseInt(scanner.nextLine().trim());
            if (typeCount < 0) throw new NumberFormatException("Negative count not allowed");
        } 
        catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a non-negative integer.");
            return list; // Return empty list on invalid input
        }

        for (int i = 0; i < typeCount; i++) {
            System.out.print("Enter datatype number (1-3) for type " + (i + 1) + ": ");
            int dataType;
            try {
                dataType = Integer.parseInt(scanner.nextLine().trim());
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid datatype! Skipping this type.");
                continue;
            }

            System.out.print("How many elements of this type? ");
            int count;
            try {
                count = Integer.parseInt(scanner.nextLine().trim());
                if (count < 0) throw new NumberFormatException("Negative count not allowed");
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid count! Please enter a non-negative integer. Skipping this type.");
                continue;
            }

            switch (dataType) {
                case 1: // Integer
                    for (int j = 0; j < count; j++) {
                        System.out.print("Int" + (j + 1) + ": ");
                        String input = scanner.nextLine().trim();
                        try {
                            list.add(Integer.parseInt(input));
                        } 
                        catch (NumberFormatException e) {
                            System.out.println("Invalid integer! Skipping this element.");
                        }
                    }
                    break;
                case 2: // Double
                    for (int j = 0; j < count; j++) {
                        System.out.print("Double" + (j + 1) + ": ");
                        String input = scanner.nextLine().trim();
                        try {
                            list.add(Double.parseDouble(input));
                        } 
                        catch (NumberFormatException e) {
                            System.out.println("Invalid double! Skipping this element.");
                        }
                    }
                    break;
                case 3: // String
                    for (int j = 0; j < count; j++) {
                        System.out.print("String" + (j + 1) + ": ");
                        String input = scanner.nextLine().trim();
                        if (!input.isEmpty()) {
                            list.add(input);
                        } 
                        else {
                            System.out.println("Empty string not allowed! Skipping this element.");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid datatype! Skipping this type.");
            }
        }
        return list;
    }

    private static void handleAddElements() throws TaskException {
        List<Object> list = getUserList();
        Object[] inputArray = list.toArray();
        List<Object> result = tasks.addElements( inputArray); // Adjusted to match method signature
        System.out.println("Resulting list: " + result);
    }

    private static void handleFindIndex() throws TaskException {
        List<Object> list = getUserList();
        System.out.print("Enter element to find (match datatype): ");
        String target = scanner.nextLine().trim();
        Object targetObj;
        try {
            if (target.matches("-?\\d+")) targetObj = Integer.parseInt(target);
            else if (target.contains(".")) targetObj = Double.parseDouble(target);
            else targetObj = target;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format! Using as String.");
            targetObj = target;
        }
        
        int index = tasks.findIndexOfElement(list, targetObj);
        System.out.println("Index of " + targetObj + ": " + index);
    }

    private static void handlePrintList() throws TaskException {
        List<Object> list = getUserList();

        // Get the iterator from the tasks object - Note: Assuming getIterator exists, but it doesn't in provided ArrayListTasks
        // Using list.iterator() instead since getIterator() isn't defined
        Iterator<Object> iterator = list.iterator();

        System.out.println("Using Iterator:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.print("Using for loop:");
        for(Object item : list) {
        	System.out.println(item);
        }
        
    }
    private static void handleGetElement() throws TaskException {
        List<Object> list = getUserList();
        System.out.print("Enter index: ");
        int index;
        try {
            index = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid index! Please enter an integer.");
            return;
        }
        Object element = tasks.getElementAtIndex(list, index);
        System.out.println("Element at index " + index + ": " + element);
    }

    private static void handleFindFirstLast() throws TaskException {
        List<Object> list = getUserList();
        System.out.print("Enter element to find (match datatype): ");
        String target = scanner.nextLine().trim();
        Object targetObj;
        try {
            if (target.matches("-?\\d+")) targetObj = Integer.parseInt(target);
            else if (target.contains(".")) targetObj = Double.parseDouble(target);
            else targetObj = target;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format! Using as String.");
            targetObj = target;
        }
        int[] positions = tasks.findFirstAndLastPosition(list, targetObj);
        System.out.println("First position: " + positions[0] + ", Last position: " + positions[1]);
    }

    private static void handleAddAtPosition() throws TaskException {
        List<Object> list = getUserList();
        System.out.print("Enter position: ");
        int position;
        try {
            position = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid position! Please enter an integer.");
            return;
        }
        System.out.print("Enter value (match datatype): ");
        String value = scanner.nextLine().trim();
        Object valueObj;
        try {
            if (value.matches("-?\\d+")) valueObj = Integer.parseInt(value);
            else if (value.contains(".")) valueObj = Double.parseDouble(value);
            else valueObj = value;
        } catch (NumberFormatException e) {
            System.out.println("Invalid value format! Using as String.");
            valueObj = value;
        }
        List<Object> result = tasks.addElementAtPosition(list, position, valueObj);
        System.out.println("Updated list: " + result);
    }

    private static void handleCreateSublist() throws TaskException {
        List<Object> list = getUserList();
        System.out.print("Enter start index: ");
        int start;
        try {
            start = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid start index! Please enter an integer.");
            return;
        }
        System.out.print("Enter end index (exclusive): ");
        int end;
        try {
            end = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid end index! Please enter an integer.");
            return;
        }
        List<Object> sublist = tasks.createSublist(list, start, end);
        System.out.println("Sublist: " + sublist);
    }

    private static void handleMergeLists() throws TaskException {
        System.out.println("Enter first list:");
        List<Object> list1 = getUserList();
        System.out.println("Enter second list:");
        List<Object> list2 = getUserList();
        System.out.print("Merge second list first? (true/false): ");
        boolean secondFirst;
        try {
            secondFirst = Boolean.parseBoolean(scanner.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid input! Defaulting to false.");
            secondFirst = false;
        }
        List<Object> merged = tasks.mergeLists(list1, list2, secondFirst);
        System.out.println("Merged list: " + merged);
    }

    private static void handleRemoveElement() throws TaskException {
        List<Object> list = getUserList();
        System.out.print("Enter index to remove: ");
        int index;
        try {
            index = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid index! Please enter an integer.");
            return;
        }
        List<Object> result = tasks.removeElementAtIndex(list, index);
        System.out.println("Updated list: " + result);
    }

    private static void handleRemoveAll() throws TaskException {
        System.out.println("Enter first list:");
        List<Object> list1 = getUserList();
        System.out.println("Enter second list (elements to remove):");
        List<Object> list2 = getUserList();
        List<Object> result = tasks.removeAllPresent(list1, list2);
        System.out.println("Updated list: " + result);
    }

    private static void handleRetainAll() throws TaskException {
        System.out.println("Enter first list:");
        List<Object> list1 = getUserList();
        System.out.println("Enter second list (elements to retain):");
        List<Object> list2 = getUserList();
        List<Object> result = tasks.retainAllPresent(list1, list2);
        System.out.println("Updated list: " + result);
    }

    private static void handleClearList() throws TaskException {
        List<Object> list = getUserList();
        List<Object> result = tasks.clearList(list);
        System.out.println("Cleared list: " + result);
    }

    private static void handleCheckPresence() throws TaskException {
        List<Object> list = getUserList();
        System.out.print("Enter element to check (match datatype): ");
        String target = scanner.nextLine().trim();
        Object targetObj;
        try {
            if (target.matches("-?\\d+")) targetObj = Integer.parseInt(target);
            else if (target.contains(".")) targetObj = Double.parseDouble(target);
            else targetObj = target;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format! Using as String.");
            targetObj = target;
        }
        boolean present = tasks.checkElementPresence(list, targetObj);
        System.out.println("Element " + targetObj + " present: " + present);
    }
}