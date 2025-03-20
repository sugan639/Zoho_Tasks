import java.util.Arrays;
import java.util.Scanner;

public class StringRunner {
    public static void main(String[] args) {
    	
        StringTasks tasks = new StringTasks();
        Scanner scanner = new Scanner(System.in);


	// Checking for Exceptions and getting choice number 
        while (true) {
            int taskNumber = -1; 
            try {
                printMenu();
                System.out.print("Enter your choice (1-20, or 0 to exit): ");
                
                String inputChoice = scanner.nextLine().trim();
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
                if (taskNumber != 14 && taskNumber != 17) { // inputMultipleLines doesn't need pre-input
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                   
                }


		// Switch cases for choice number
		
                switch (taskNumber) {
                    case 1:
                        System.out.println("String length: " + tasks.getLength(input));
                        break;
                    case 2:
                        System.out.println("Character array: " + Arrays.toString(tasks.convertToCharArray(input)));
                        break;
                    case 3:
                    	System.out.print("Enter number Nth ultimate charater: ");
                        int reqChar = Integer.parseInt(scanner.nextLine().trim());
                        char pen = tasks.getUltimateChar(input, reqChar);
                        System.out.println("Penultimate character: " + (pen == '\0' ? "N/A" : pen));
                        break;
                    case 4:
                        System.out.print("Enter a character to count: ");
                        String charInput = scanner.nextLine();
                        if (charInput.isEmpty()) {
                            System.out.println("Error: No character provided!");
                            continue;
                        }
                        char ch = charInput.charAt(0);
                        System.out.println("Occurrences: " + tasks.countOccurrences(input, ch));
                        break;
                    case 5:
                        System.out.print("Enter a character to find: ");
                        String charInput2 = scanner.nextLine();
                        if (charInput2.isEmpty()) {
                            System.out.println("Error: No character provided!");
                            continue;
                        }
                        char ch2 = charInput2.charAt(0);
                        System.out.println("Last occurrence index: " + tasks.getLastOccurrence(input, ch2));
                        break;
                    case 6:
                    	System.out.print("Enter number of last characters required: ");
                        int lastNCharacter = Integer.parseInt(scanner.nextLine().trim());

                        System.out.println("Last n characters are: " + tasks.getLastNChars(input,lastNCharacter));
                        break;
                    case 7:
                    System.out.print("Enter number of first characters required: ");
                        int firstNCharacter = Integer.parseInt(scanner.nextLine().trim());
                        System.out.println("First N number of characters: " + tasks.getFirstNChars(input, firstNCharacter));
                        break;
                    case 8:
                     	System.out.print("Enter second string to replace at beginning: ");
                        String replacerString = scanner.nextLine();
                        System.out.print("Enter number of characters to replace: ");
                        int replaceNum = Integer.parseInt(scanner.nextLine().trim());
                        System.out.println("After replacing : " + tasks.stringReplacer(input,replacerString, replaceNum ));
                        break;
                        
                        
                    case 9:
                    	System.out.print("Enter second string to check start characters: ");
                        String startString = scanner.nextLine();
                        System.out.println("Starts with "+ startString +" ? : " +tasks.startsWith(input, startString));
                        break;
                        
                        
                    case 10:
                    	System.out.print("Enter second string to check last characters: ");
                        String endString = scanner.nextLine();
                        System.out.println("Ends with "+ endString +" ? : " + tasks.endsWith(input, endString));
                        break;
                        
                        
                        
                    case 11:
                        System.out.println("Upper case: " + tasks.toUpperCase(input));
                        break;
                    case 12:
                        System.out.println("Lower case: " + tasks.toLowerCase(input));
                        break;
                    case 13:
                        System.out.println("Reversed string: " + tasks.reverseString(input));
                        break;
                    case 14:
                        
      		        System.out.println("Enter a line with multiple words:");
                        String inputLine = scanner.nextLine();
                        System.out.println("The line is "+tasks.inputMultipleStrings(inputLine));
                        break;
                    case 15:
                    	System.out.print("Enter target String: ");
        		String target = scanner.nextLine();
                        System.out.println("Without spaces: " + tasks.concatenateWithoutTarget(input, target));
                        break;
                    case 16:
                    	System.out.print("Enter seperator String: ");
        		String seperator = scanner.nextLine();
                        System.out.println("String array: " + Arrays.toString(tasks.stringToArray(input, seperator)));
                        break;
                    case 17:
			    System.out.println("How many strings do you want to enter? ");
			    int size = Integer.parseInt(scanner.nextLine().trim());
			    String[] array = new String[size];
			    System.out.println("Enter " + size + " strings (press Enter after each):");
			    for (int i = 0; i < size; i++) {
				System.out.println("String " + (i + 1) + ": ");
				String ip = scanner.nextLine();
				array[i] = ip.isEmpty() ? null : ip; // Fixed to store null for empty input
			    }
			    System.out.println("Enter the separator (e.g., ', '): ");
			    String separator = scanner.nextLine();
			    String result = tasks.mergeStrings(array, separator); // Use tasks instance here
			    System.out.println("Joined string: \"" + result + "\"");
			    break;
                    case 18:
                        System.out.print("Enter second string: ");
                        String input2 = scanner.nextLine();
                        System.out.println("Strings equal: " + tasks.areStringsEqual(input, input2));
                        break;
                    case 19:
                        System.out.print("Enter second string: ");
                        String input3 = scanner.nextLine();
                        System.out.println("Strings equal (ignore case): " + tasks.areStringsEqualIgnoreCase(input, input3));
                        break;
                    case 20:
                        System.out.println("Trimmed string: " + tasks.trimString(input));
                        break;
                }
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format - " + e.getMessage());
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
        scanner.close();
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
