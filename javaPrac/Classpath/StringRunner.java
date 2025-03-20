

public class StringRunner {
    public static void main(String[] inputs) {
	 StringTasks tasks = new StringTasks();
        
        System.out.println("Please select a task number: ");
        Scanner scanner = new Scanner(System.in);
        imt taskNumber = scanner.nextLine();
        scanner.close();
        
	switch (taskNumber) {
            case 1:
                if (inputs.length > 0) {
                    int length = stringTasks.getStringLength(inputs[1]);
                    System.out.println("String length: " + length);
                }
                break;
                
            case 2:
                if (inputs.length > 0) {
                    char[] charArray = stringTasks.convertToCharArray();
                    System.out.println("Character array: " + Arrays.toString(charArray));
                }
                break;
                
            case 3:
                if (inputs.length > 0) {
                    char penultimate = stringTasks.getPenultimateChar();
                    System.out.println("Penultimate character: " + (penultimate == '\0' ? "N/A" : penultimate));
                }
                break;
                
            case 4:
                int occurrences = stringTasks.countOccurrences();
                System.out.println("Character occurrences: " + occurrences);
                break;
                
            case 5:
                int lastIndex = stringTasks.getLastOccurrence();
                System.out.println("Last occurrence index: " + lastIndex);
                break;
                
            case 6:
                if (inputs.length > 0) {
                    String lastFive = stringTasks.getLastFiveChars();
                    System.out.println("Last five characters: " + lastFive);
                }
                break;
                
            case 7:
                if (inputs.length > 0) {
                    String firstThree = stringTasks.getFirstThreeChars();
                    System.out.println("First three characters: " + firstThree);
                }
                break;
                
            case 8:
                if (inputs.length > 0) {
                    String replaced = stringTasks.replaceFirstThreeWithXYZ();
                    System.out.println("After replacing first three with XYZ: " + replaced);
                }
                break;
                
            case 9:
                if (inputs.length > 0) {
                    boolean startsWithEnt = stringTasks.startsWithEnt();
                    System.out.println("Starts with 'ent': " + startsWithEnt);
                }
                break;
                
            case 10:
                if (inputs.length > 0) {
                    boolean endsWithLe = stringTasks.endsWithLe();
                    System.out.println("Ends with 'le': " + endsWithLe);
                }
                break;
                
            case 11:
                if (inputs.length > 0) {
                    String upperCase = stringTasks.toUpperCase();
                    System.out.println("Upper case: " + upperCase);
                }
                break;
                
            case 12:
                if (inputs.length > 1) {
                    String lowerCase = stringTasks.toLowerCase(inputs[1]);
                    System.out.println("Lower case: " + lowerCase);
                }
                break;
                
            case 13:
                if (inputs.length > 0) {
                    String reversed = stringTasks.reverseString();
                    System.out.println("Reversed string: " + reversed);
                }
                break;
                
            case 14:
                stringTasks.inputMultipleLines();
                break;
                
            case 15:
                String noSpaces = stringTasks.concatenateWithoutSpaces();
                System.out.println("Without spaces: " + noSpaces);
                break;
                
            case 16:
                String[] words = stringTasks.stringToArray();
                System.out.println("String array: " + Arrays.toString(words));
                break;
                
            case 17:
                if (inputs.length > 0) {
                    String merged = stringTasks.mergeWithHyphen(inputs);
                    System.out.println("Merged with hyphen: " + merged);
                }
                break;
                
            case 18:
                if (inputs.length >= 2) {
                    boolean equal = stringTasks.areStringsEqual();
                    System.out.println("Strings equal: " + equal);
                }
                break;
                
            case 19:
                if (inputs.length >= 2) {
                    boolean equalIgnoreCase = stringTasks.areStringsEqualIgnoreCase();
                    System.out.println("Strings equal (ignore case): " + equalIgnoreCase);
                }
                break;
                
            case 20:
                if (inputs.length > 1) {
                    String trimmed = stringTasks.trimString();
                    System.out.println("Trimmed string: " + trimmed);
                }
                break;
                
            default:
                System.out.println("Invalid choice. Please select a number between 1 and 20.");
                break;
        }
        
        
        
        
        System.out.println(
        
        tasks.countOccurrences()
        
        );
      
        
        
    }
}

