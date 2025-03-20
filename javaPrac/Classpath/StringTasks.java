import java.util.*;


public class StringTasks {
  
  
  
    //1
 /*   public int getStringLength(String arguments){
            if (arguments.length == 0) {
            System.out.println("Please provide a string as a command-line argument.");
            return 0;
        }
        String input = arguments[0];  // Taking input from command line
        System.out.println("Length of the string: " + input.length());
        return input.length();
    }
    */
     public  int getStringLength(String str) {
   
  
     
        int length = 0;
        for (char c : str.toCharArray()) {
            length++;
        }
        return length;
    }

    
    //2
  public  char[] convertToCharArray() {
  System.out.println("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        
        char[] charArray = new char[getStringLength(str)];
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = str.charAt(i);
        }
        return charArray;
    }
	//3
    public  char getPenultimateChar() {
    System.out.println("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        int length = getStringLength(str);
        char penultimate= length > 1 ? str.charAt(length - 2) : '\0';
         return penultimate;
    }
	//4
    public  int countOccurrences() {
     System.out.println("Enter a string: ");
    
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        
        System.out.println("Enter a character: ");
        char ch = scanner.next().charAt(0);
        
        scanner.close();
        
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) count++;
        }
        return count;
    }

	//5
    public int getLastOccurrence() {
       System.out.println("Enter a string: ");
    
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        
        System.out.println("Enter a character: ");
        char ch = scanner.next().charAt(0);
        
        scanner.close();
        for (int i = getStringLength(str) - 1; i >= 0; i--) {
            if (str.charAt(i) == ch) return i;
        }
        return -1;
    }

	//6
    public  String getLastFiveChars( ) {
    System.out.println("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        int length = getStringLength(str);
        String result = "";
        for (int i = Math.max(0, length - 5); i < length; i++) {
            result += str.charAt(i);
        }
        return result;
    }
	//7
    public  String getFirstThreeChars() {
    System.out.println("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String result = "";
        for (int i = 0; i < Math.min(3, getStringLength(str)); i++) {
            result += str.charAt(i);
        }
        return result;
    }
	//8
    public  String replaceFirstThreeWithXYZ( ) {
    	System.out.println("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String result = "XYZ";
        for (int i = 3; i < getStringLength(str); i++) {
            result += str.charAt(i);
        }
        return result;
    }
	//9
    public boolean startsWithEnt( ) {
    System.out.println("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        return getStringLength(str) >= 3 && str.charAt(0) == 'e' && str.charAt(1) == 'n' && str.charAt(2) == 't';
    }
	//10
    public  boolean endsWithLe( ) {
    System.out.println("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        int length = getStringLength(str);
        return length >= 2 && str.charAt(length - 2) == 'l' && str.charAt(length - 1) == 'e';
    }
	//11
    public  String toUpperCase() {
     System.out.println("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String result = "";
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') result = result + (char) (c - 32);
            else result += c;
        }
        return result;
    }
	//12
    public   String toLowerCase() {
     System.out.println("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String result = "";
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') result += (char) (c + 32);
            else result += c;
        }
        return result;
    }
    
    
	//13
    public   String reverseString() {
    
        System.out.println("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
       
        String result = "";
        for (int i = getStringLength(str) - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
    
    //14
    public  void inputMultipleLines() {
     
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a line with multiple words:");
        
        String inputLine = scanner.nextLine();
        
        scanner.close();
        
        System.out.println("You entered: " + inputLine);
    }
    
    //15
    public  String concatenateWithoutSpaces() {
    System.out.println("Enter a line with multiple words:");
    
        Scanner scanner = new Scanner(System.in);
        
        String str = scanner.nextLine();
        
        scanner.close();
        
        String result = "";
        for (char c : str.toCharArray()) {
            if (c != ' ') result += c;
        }
        return result;
    }
    
    //16
     public  String[] stringToArray() {
     System.out.println("Enter a line with multiple words:");
    
        Scanner scanner = new Scanner(System.in);
        
        String str = scanner.nextLine();
        
        scanner.close();
        int spaceCount = 0;
        for (char c : str.toCharArray()) {
            if (c == ' ') spaceCount++;
        }
        String[] words = new String[spaceCount + 1];
        int index = 0;
        String word = "";
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                words[index++] = word;
                word = "";
            } else {
                word += c;
            }
        }
        words[index] = word;
        return words;
    }
    
    //17
    public  String mergeWithHyphen() {
    	 System.out.println("Enter string: ");
         
        Scanner scanner = new Scanner(System.in);
        String strings = scanner.nextLine();
        scanner.close();
       
        String result = "";
        for (int i = 0; i <getStringLength(strings); i++) {
            result += strings.charAt(i);
            if (i < getStringLength(strings) - 1) result += "-";
        }
        return result;
    }
    
    
    //18
    public  boolean areStringsEqual() {
        	 System.out.println("String equality");
    	 System.out.println("Enter first string: ");
    
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        System.out.println("Enter second string: ");
    
        
        String str2 = scanner.nextLine();
        
        scanner.close();
    
        if (getStringLength(str1) != getStringLength(str2)) return false;
        for (int i = 0; i < getStringLength(str1); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }
    
    //19
    public  boolean areStringsEqualIgnoreCase() {
    	
    	 System.out.println("Enter first string: ");
    
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        System.out.println("Enter second string: ");
        String str2 = scanner.nextLine();
        
        scanner.close();
    
    
        if (getStringLength(str1) != getStringLength(str2)) return false;
        for (int i = 0; i < getStringLength(str1); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 >= 'A' && c1 <= 'Z') c1 = (char) (c1 + 32);
            if (c2 >= 'A' && c2 <= 'Z') c2 = (char) (c2 + 32);
            if (c1 != c2) return false;
        }
        return true;
    }
    
    
     //20
    public String trimString() {
       
        System.out.println("Enter string to trim String: ");
    
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        
        int start = 0, end = getStringLength(str) - 1;
        while (start <= end && str.charAt(start) == ' ') start++;
        while (end >= start && str.charAt(end) == ' ') end--;
        
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }
}

  
