package com.util.stringbuilder;

import com.util.customexception.*;
import java.util.Scanner;

public class StringBuilderRunner {
	
    private StringBuilderTasks tasks = new StringBuilderTasks();
    private Scanner scanner;

    public StringBuilderRunner() {
        this.scanner = new Scanner(System.in);
    }

    
    
    	// Private methods
    private void handleAppendString() throws TaskException {
        StringBuilder sb1 = tasks.getStringBuilder();
        System.out.print("Enter a string to append: ");
        String input = scanner.nextLine();
        System.out.println(tasks.appendString(sb1, input));
        sb1.setLength(0);
    }

    private void handleConcatenateStrings() throws TaskException {
        StringBuilder sb2 = tasks.getStringBuilder();
        System.out.print("Enter number of strings: ");
        int count = getIntInput(scanner);
        String[] inputs = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            inputs[i] = scanner.nextLine();
        }
        System.out.print("Enter separator: ");
        String separator = scanner.nextLine();
        System.out.println(tasks.concatenateStrings(sb2, inputs, separator));
        sb2.setLength(0);
    }

    private void handleInsertAtPosition() throws TaskException {
        StringBuilder sb3 = tasks.getStringBuilder();
        System.out.print("Enter original string: ");
        String original3 = scanner.nextLine();
        System.out.print("Enter string to insert: ");
        String toInsert = scanner.nextLine();
        System.out.print("Enter position: ");
        int position = getIntInput(scanner);
        System.out.println(tasks.insertAtPosition(sb3, original3, toInsert, position));
        sb3.setLength(0);
    }

    private void handleDeletePortion() throws TaskException {
        StringBuilder sb4 = tasks.getStringBuilder();
        System.out.print("Enter original string: ");
        String original4 = scanner.nextLine();
        System.out.print("Enter start index: ");
        int start4 = getIntInput(scanner);
        System.out.print("Enter end index: ");
        int end4 = getIntInput(scanner);
        System.out.println(tasks.deletePortion(sb4, original4, start4, end4));
        sb4.setLength(0);
    }

    private void handleReplaceChar() throws TaskException {
        StringBuilder sb5 = tasks.getStringBuilder();
        System.out.print("Enter original string: ");
        String original5 = scanner.nextLine();
        System.out.print("Enter index to replace: ");
        int index = getIntInput(scanner);
        System.out.print("Enter new character: ");
        char newChar = scanner.nextLine().charAt(0);
        System.out.println(tasks.replaceChar(sb5, original5, index, newChar));
        sb5.setLength(0);
    }

    private void handleReverseString() throws TaskException {
        StringBuilder sb6 = tasks.getStringBuilder();
        System.out.print("Enter string to reverse: ");
        String original6 = scanner.nextLine();
        StringBuilder res = tasks.reverseString(sb6, original6);
        System.out.println(res);
    }

    private void handleDeleteRange() throws TaskException {
        StringBuilder sb7 = tasks.getStringBuilder();
        System.out.print("Enter original string: ");
        String original7 = scanner.nextLine();
        System.out.print("Enter start index: ");
        int start7 = getIntInput(scanner);
        System.out.print("Enter end index: ");
        int end7 = getIntInput(scanner);
        System.out.println(tasks.deleteRange(sb7, original7, start7, end7));
        sb7.setLength(0);
    }

    private void handleReplaceRange() throws TaskException {
        StringBuilder sb8 = tasks.getStringBuilder();
        System.out.print("Enter original string: ");
        String original8 = scanner.nextLine();
        System.out.print("Enter start index: ");
        int start8 = getIntInput(scanner);
        System.out.print("Enter end index: ");
        int end8 = getIntInput(scanner);
        System.out.print("Enter replacement string: ");
        String replacement = scanner.nextLine();
        System.out.println(tasks.replaceRange(sb8, original8, start8, end8, replacement));
        sb8.setLength(0);
    }

    private void handleFindFirst() throws TaskException {
        StringBuilder sb9 = tasks.getStringBuilder();
        System.out.print("Enter original string: ");
        String original9 = scanner.nextLine();
        System.out.print("Enter search string: ");
        String search9 = scanner.nextLine();
        int firstIndex = tasks.findFirst(sb9, original9, search9);
        System.out.println("First occurrence at index: " + firstIndex);
        sb9.setLength(0);
    }

    private void handleFindLast() throws TaskException {
        StringBuilder sb10 = tasks.getStringBuilder();
        System.out.print("Enter original string: ");
        String original10 = scanner.nextLine();
        System.out.print("Enter search string: ");
        String search10 = scanner.nextLine();
        int lastIndex = tasks.findLast(sb10, original10, search10);
        System.out.println("Last occurrence at index: " + lastIndex);
        sb10.setLength(0);
    }

    	
    // Main method
    public static void main(String[] args) {
    	
        StringBuilderRunner runner = new StringBuilderRunner();
        boolean running = true;

        
        
        
        // Choosing the choices for core functionality
        while (running) {
            displayMenu();
            System.out.print("Enter 0 to exit! Enter your choice (1-10):  ");
            int choice = runner.getIntInput(runner.scanner);

            try {
                switch (choice) {
                    case 1: // Append String 
                        runner.handleAppendString();
                        break;

                    case 2: // Concatenate Strings
                        runner.handleConcatenateStrings();
                        break;

                    case 3: // Insert at Position
                        runner.handleInsertAtPosition();
                        break;

                    case 4: // Delete Portion
                        runner.handleDeletePortion();
                        break;

                    case 5: // Replace Character
                        runner.handleReplaceChar();
                        break;

                    case 6: // Reverse String
                        runner.handleReverseString();
                        break;

                    case 7: // Delete Range
                        runner.handleDeleteRange();
                        break;

                    case 8: // Replace Range
                        runner.handleReplaceRange();
                        break;

                    case 9: // Find First Occurrence
                        runner.handleFindFirst();
                        break;

                    case 10: // Find Last Occurrence
                        runner.handleFindLast();
                        break;
                        
                    case 0: // Exit
                        running = false;
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please select between 1 and 10.");
                }
            } 
            
            
            // Catching the exception
            catch (TaskException e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (running) {
                System.out.println("\n Press Enter to continue...");
                runner.scanner.nextLine(); // Clear buffer and wait for Enter
            }
        }
        runner.scanner.close();
    }
    
    
    

    // Display menu options
    private static void displayMenu() {
        System.out.println("=== StringBuilder Tasks Menu ===");
        System.out.println("1. Append String");
        System.out.println("2. Concatenate Multiple Strings");
        System.out.println("3. Insert String at Position");
        System.out.println("4. Delete Portion");
        System.out.println("5. Replace Character at Index");
        System.out.println("6. Reverse String");
        System.out.println("7. Delete Range");
        System.out.println("8. Replace Range");
        System.out.println("9. Find First Occurrence");
        System.out.println("10. Find Last Occurrence");
        System.out.println("0. Exit");
    }

    // Helper method to get integer input safely
    private int getIntInput(Scanner scanner) {
        int input = 0;
        boolean valid = false;
        while (!valid) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number: ");
            }
        }
        return input;
    }
}