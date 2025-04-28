package com.util.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.util.customexception.TaskException;

public class RegexRunner {

    private static final Scanner scanner = new Scanner(System.in);
    private static final RegexCore regexCore = new RegexCore();

    public static void main(String[] args) {
    	RegexRunner regexRunner = new RegexRunner();
    	
        try {
            while (true) {
            	System.out.println("\nSelect an option:");
                System.out.println("1. Validate Mobile Number");
                System.out.println("2. Check Alphanumeric Input");
                System.out.println("3. Perform String Checks");
                System.out.println("4. Case-Insensitive Matching");
                System.out.println("5. Validate Email");
                System.out.println("6. Filter Strings by Length");
                System.out.println("7. Find Occurrences in Lists");
                System.out.println("8. Extract HTML Tags");
                System.out.println("9. Detect Currency Symbols");
                System.out.println("10. Filter Strings by custom regex");
                System.out.println("11. Exit");
                
                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); 
                } 
                catch (Exception e) {
                	
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); 
                    continue;
                }

                switch (choice) {
                    case 1:
                    	regexRunner.validateMobileNumber();
                        break;
                    case 2:
                    	regexRunner.checkAlphanumeric();
                        break;
                    case 3:
                    	regexRunner.performStringChecks();
                        break;
                    case 4:
                    	regexRunner.caseInsensitiveMatching();
                        break;
                    case 5:
                    	regexRunner.validateEmail();
                        break;
                    case 6:
                    	regexRunner.filterStringsByLength();
                        break;
                    case 7:
                    	regexRunner.findOccurrences();
                        break;
                    case 8:
                    	regexRunner.extractHtmlTags();
                        break;
                    case 9:
                    	regexRunner.detectCurrencySymbols();
                        break;
                    case 10:
                    	regexRunner.filterStringsByRegex();
                        break;
                    case 11:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } 
        catch (TaskException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        
    }

    private void validateMobileNumber() throws TaskException {
        System.out.print("Enter mobile number: ");
        String mobileNumber = scanner.nextLine().trim();

         String[] mobilePatterns = {
            RegexPattern.MOBILE_10_DIGITS,
            RegexPattern.MOBILE_DASH_DOT_SPACE,
            RegexPattern.MOBILE_WITH_EXTENSION,
            RegexPattern.MOBILE_WITH_AREA_CODE
        };

        boolean isValid = false;
        
        for (String pattern : mobilePatterns) {
            if (regexCore.isMatchingRegex(mobileNumber, pattern)) {
                isValid = true;
                break;
            }
        }

        System.out.println("Is valid mobile number? " + isValid);
    }


    /* 2. Checks if the input string contains only alphanumeric characters. */
    private void checkAlphanumeric() throws TaskException {
        System.out.print("Enter string: ");
        String input = scanner.nextLine();
        boolean isAlphaNumeric = regexCore.isMatchingRegex(input, RegexPattern.ALPHA_NUMERIC_REGEX);
        System.out.println("Is alphanumeric? " + isAlphaNumeric);
    }

    /* 3. Performs various checks on two strings. */
    private void performStringChecks() throws TaskException {
    	System.out.print("Enter given string: ");
        String givenString = scanner.nextLine();
        System.out.print("Enter matching string: ");
        String matchingString = scanner.nextLine();

        // Define the checks dynamically in the runner
        Map<String, String> checks = new HashMap<>();
        checks.put("Starts With", "^" + Pattern.quote(matchingString) + ".*");
        checks.put("Contains", ".*" + Pattern.quote(matchingString) + ".*");
        checks.put("Ends With", ".*" + Pattern.quote(matchingString) + "$");
        checks.put("Exact Match", "^" + Pattern.quote(matchingString) + "$");

        // Call the core method to get results
        Map<String, Boolean> result = regexCore.checkMatchingString(givenString, matchingString, checks);

        // Print results with meaningful labels
        for (Map.Entry<String, Boolean> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    /* 4. Case-insensitive matching of a string in a list. */
    private void caseInsensitiveMatching() throws TaskException {
        System.out.print("Enter list size: ");
        int size;
        try {
            size = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            return;
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            list.add(scanner.nextLine());
        }

        System.out.print("Enter matching string: ");
        String matchingString = scanner.nextLine();

        boolean matchFound = regexCore.caseInsensitiveMatch(list, matchingString);
        System.out.println("Case-insensitive match found? " + matchFound);
    }

    /* 5. Validates an email address. */
    private void validateEmail() throws TaskException {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        boolean isValid = regexCore.isMatchingRegex(email, RegexPattern.EMAIL_REGEX);
        System.out.println("Is valid email? " + isValid);
    }

    /* 6. Filters a list of strings based on length  */
    private void filterStringsByLength() throws TaskException {
        System.out.print("Enter list size: ");
        int size;
        try {
            size = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            return;
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            list.add(scanner.nextLine());
        }
        System.out.print("Enter filter length: ");
        int filterLen;
        try {
            filterLen = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            return;
        }

        List<String> filteredList = regexCore.filterByLength(list, filterLen);
        System.out.println("Filtered list: " + filteredList);
    }

    /* 7. Finds occurrences of strings from List2 in List1. */
    private void findOccurrences() throws TaskException {
        System.out.print("Enter size of List1: ");
        int size1;
        try {
            size1 = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            return;
        }

        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            list1.add(scanner.nextLine());
        }

        System.out.print("Enter size of List2: ");
        int size2;
        try {
            size2 = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            return;
        }

        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < size2; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            list2.add(scanner.nextLine());
        }

        Map<String, List<Integer>> result = regexCore.findOccurrences(list1, list2);
        System.out.println("Occurrences: " + result);
    }

    /* 8. Extracts HTML tags from a raw HTML string. */
    private void extractHtmlTags() throws TaskException {
        System.out.print("Enter raw HTML string: ");
        String html = scanner.nextLine();

        List<String> tags = regexCore.patternMatcher(html, RegexPattern.HTML_REGEX);
        System.out.println("\nExtracted HTML tags:");
        int size = tags.size();
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + "." + tags.get(i));
        }
    }
    //9
    private void detectCurrencySymbols() throws TaskException {
        System.out.print("Enter a string to detect currency symbols: ");
        String input = scanner.nextLine();

        List<String> results = regexCore.patternMatcher(input, RegexPattern.CURRENCY_REGEX);
        if (results.isEmpty()) {
            System.out.println("No currency symbols found.");
        } else {
            System.out.println("Detected currency symbols:");
            for (String result : results) {
                System.out.println(result);
            }
        }
    }
    
    //10
    private void filterStringsByRegex() throws TaskException {
        System.out.println("Enter the number of strings in the list:");
        int size = scanner.nextInt();
        scanner.nextLine(); 

        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            list.add(scanner.nextLine());
        }

        System.out.print("Enter the regex pattern: ");
        String regex = scanner.nextLine();

        List<String> matchedStrings = regexCore.customRegex(list, regex);
        if (matchedStrings.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            System.out.println("Matched strings:");
            for (String matchedString : matchedStrings) {
                System.out.println(matchedString);
            }
        }
    }



}