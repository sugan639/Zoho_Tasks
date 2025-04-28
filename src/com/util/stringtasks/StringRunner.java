package com.util.stringtasks;

import java.util.Arrays;
import java.util.Scanner;

public class StringRunner {
	
	
    private StringTasks tasks = new StringTasks();
    private Scanner scanner;

    public StringRunner() {
        this.scanner = new Scanner(System.in);
    }
    
    
    // Private methods
    private void handleGetLength(String input) throws Exception {
        System.out.println("String length: " + tasks.getLength(input));
    }

    private void handleConvertToCharArray(String input) throws Exception {
        System.out.println("Character array: " + Arrays.toString(tasks.convertToCharArray(input)));
    }

    private void handleGetUltimateChar(String input) throws Exception {
        System.out.print("Enter number Nth ultimate charater: ");
        int reqChar = Integer.parseInt(scanner.nextLine().trim());
        char pen = tasks.getUltimateChar(input, reqChar);
        System.out.println("Penultimate character: " + (pen == '\0' ? "N/A" : pen));
    }

    private void handleCountOccurrences(String input) throws Exception {
        System.out.print("Enter a character to count: ");
        String charInput = scanner.nextLine();
        if (charInput.isEmpty()) {
            System.out.println("Error: No character provided!");
            return;
        }
        char ch = charInput.charAt(0);
        System.out.println("Occurrences: " + tasks.countOccurrences(input, ch));
    }

    private void handleGetLastOccurrence(String input) throws Exception {
        System.out.print("Enter a character to find: ");
        String charInput2 = scanner.nextLine();
        if (charInput2.isEmpty()) {
            System.out.println("Error: No character provided!");
            return;
        }
        char ch2 = charInput2.charAt(0);
        System.out.println("Last occurrence index: " + tasks.getLastOccurrence(input, ch2));
    }

    private void handleGetLastNChars(String input) throws Exception {
        System.out.print("Enter number of last characters required: ");
        int lastNCharacter = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Last n characters are: " + tasks.getLastNChars(input, lastNCharacter));
    }

    private void handleGetFirstNChars(String input) throws Exception {
        System.out.print("Enter number of first characters required: ");
        int firstNCharacter = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("First N number of characters: " + tasks.getFirstNChars(input, firstNCharacter));
    }

    private void handleStringReplacer(String input) throws Exception {
        System.out.print("Enter second string to replace at beginning: ");
        String replacerString = scanner.nextLine();
        System.out.print("Enter number of characters to replace: ");
        int replaceNum = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("After replacing : " + tasks.stringReplacer(input, replacerString, replaceNum));
    }

    private void handleStartsWith(String input) throws Exception {
        System.out.print("Enter second string to check start characters: ");
        String startString = scanner.nextLine();
        System.out.println("Starts with " + startString + " ? : " + tasks.startsWith(input, startString));
    }

    private void handleEndsWith(String input) throws Exception {
        System.out.print("Enter second string to check last characters: ");
        String endString = scanner.nextLine();
        System.out.println("Ends with " + endString + " ? : " + tasks.endsWith(input, endString));
    }

    private void handleToUpperCase(String input) throws Exception {
        System.out.println("Upper case: " + tasks.toUpperCase(input));
    }

    private void handleToLowerCase(String input) throws Exception {
        System.out.println("Lower case: " + tasks.toLowerCase(input));
    }

    private void handleReverseString(String input) throws Exception {
        System.out.println("Reversed string: " + tasks.reverseString(input));
    }

    private void handleInputMultipleStrings() throws Exception {
        System.out.println("Enter a line with multiple words:");
        String inputLine = scanner.nextLine();
        System.out.println("The line is " + tasks.inputMultipleStrings(inputLine));
    }

    private void handleConcatenateWithoutTarget(String input) throws Exception {
        System.out.print("Enter target String: ");
        String target = scanner.nextLine();
        System.out.println("Without spaces: " + tasks.concatenateWithoutTarget(input, target));
    }

    private void handleStringToArray(String input) throws Exception {
        System.out.print("Enter seperator String: ");
        String seperator = scanner.nextLine();
        System.out.println("String array: " + Arrays.toString(tasks.stringToArray(input, seperator)));
    }

    private void handleMergeStrings() throws Exception {
        System.out.println("How many strings do you want to enter? ");
        int size = Integer.parseInt(scanner.nextLine().trim());
        String[] array = new String[size];
        System.out.println("Enter " + size + " strings (press Enter after each):");
        for (int i = 0; i < size; i++) {
            System.out.println("String " + (i + 1) + ": ");
            String ip = scanner.nextLine();
            array[i] = ip.isEmpty() ? null : ip;
        }
        System.out.println("Enter the separator (e.g., ', '): ");
        String separator = scanner.nextLine();
        String result = tasks.mergeStrings(array, separator);
        System.out.println("Joined string: \"" + result + "\"");
    }

    private void handleAreStringsEqual(String input) throws Exception {
        System.out.print("Enter second string: ");
        String input2 = scanner.nextLine();
        System.out.println("Strings equal: " + tasks.areStringsEqual(input, input2));
    }

    private void handleAreStringsEqualIgnoreCase(String input) throws Exception {
        System.out.print("Enter second string: ");
        String input3 = scanner.nextLine();
        System.out.println("Strings equal (ignore case): " + tasks.areStringsEqualIgnoreCase(input, input3));
    }

    private void handleTrimString(String input) throws Exception {
        System.out.println("Trimmed string: " + tasks.trimString(input));
    }
    
    
    
    
    // Main method
    public static void main(String[] args) {
        StringRunner runner = new StringRunner();

        // Checking for Exceptions and getting choice number 
        while (true) {
            int taskNumber = -1; 
            try {
                printMenu();
                System.out.print("Enter your choice (1-20, or 0 to exit): ");
                
                String inputChoice = runner.scanner.nextLine().trim();
                if (inputChoice.isEmpty()) {
                    System.out.println("Error: No input provided!");
                    continue;
                }

                taskNumber = Integer.parseInt(inputChoice);

                if (taskNumber == 0) {
                    System.out.println("Goodbye!");
                    break;
                }

                if (taskNumber < 1 || taskNumber > 20) {
                    System.out.println("Error: Please select a number between 1 and 20!");
                    continue;
                }

                String input = "";
                if (taskNumber != 14 && taskNumber != 17) { 
                    System.out.print("Enter a string: ");
                    input = runner.scanner.nextLine();
                }

                
                
                
                
                // Switch cases for choice number
                switch (taskNumber) {
                    case 1:
                        runner.handleGetLength(input);
                        break;
                    case 2:
                        runner.handleConvertToCharArray(input);
                        break;
                    case 3:
                        runner.handleGetUltimateChar(input);
                        break;
                    case 4:
                        runner.handleCountOccurrences(input);
                        break;
                    case 5:
                        runner.handleGetLastOccurrence(input);
                        break;
                    case 6:
                        runner.handleGetLastNChars(input);
                        break;
                    case 7:
                        runner.handleGetFirstNChars(input);
                        break;
                    case 8:
                        runner.handleStringReplacer(input);
                        break;
                    case 9:
                        runner.handleStartsWith(input);
                        break;
                    case 10:
                        runner.handleEndsWith(input);
                        break;
                    case 11:
                        runner.handleToUpperCase(input);
                        break;
                    case 12:
                        runner.handleToLowerCase(input);
                        break;
                    case 13:
                        runner.handleReverseString(input);
                        break;
                    case 14:
                        runner.handleInputMultipleStrings();
                        break;
                    case 15:
                        runner.handleConcatenateWithoutTarget(input);
                        break;
                    case 16:
                        runner.handleStringToArray(input);
                        break;
                    case 17:
                        runner.handleMergeStrings();
                        break;
                    case 18:
                        runner.handleAreStringsEqual(input);
                        break;
                    case 19:
                        runner.handleAreStringsEqualIgnoreCase(input);
                        break;
                    case 20:
                        runner.handleTrimString(input);
                        break;
                }
                System.out.println("\nPress Enter to continue...");
                runner.scanner.nextLine();
            } 
            
            
            
            // Exception catching
            catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format - " + e.getMessage());
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
        
        //Closing scanner
        runner.scanner.close();
    }

    
    
    
    
    
    // Options
    private static void printMenu() {
        System.out.println("\n=== String Operations Menu ===");
        System.out.println("1. Get string length");
        System.out.println("2. Convert to character array");
        System.out.println("3. Get penultimate character");
        System.out.println("4. Count character occurrences");
        System.out.println("5. Get last occurrence index");
        System.out.println("6. Get last N characters");
        System.out.println("7. Get first N characters");
        System.out.println("8. Replace first N character with other string");
        System.out.println("9. Check if starts with other string");
        System.out.println("10. Check if ends with other string");
        System.out.println("11. Convert to upper case");
        System.out.println("12. Convert to lower case");
        System.out.println("13. Reverse string");
        System.out.println("14. Input multiple strings");
        System.out.println("15. Concatenate without custom string");
        System.out.println("16. Convert to string to array with custom seperation");
        System.out.println("17. Replace a character with target");
        System.out.println("18. Check if strings are equal");
        System.out.println("19. Check if strings are equal (ignore case)");
        System.out.println("20. Trim string");
        System.out.println("0. Exit");
    }
}