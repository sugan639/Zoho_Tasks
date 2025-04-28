package com.util.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.uil.filemanager.FileCreator;
import com.uil.filemanager.PropertiesManager;
import com.uil.filemanager.PropertiesReader;
import com.util.customexception.ExceptionMessages;
import com.util.customexception.TaskException;

public class Helper{

    // === Helper Methods ===
    // Single string null check
    public static void checkNull(Object str) throws TaskException {
        if (str == null) {
            throw new TaskException (ExceptionMessages.NULL_INPUT_ERROR);
        }
        
    }
    
    // String Builder Helper
    public static StringBuilder getResult(StringBuilder sb) {
    
        sb.append("  Length: " + sb.length() + ", String: " + sb);
        return sb;
    }
    
     public static int getLength(String str) throws TaskException {
        return str.length();
        
    }
   
 
	
	// Array elemnt nullify check
    public static void isArrayElementNull(Object[] array) throws TaskException {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new TaskException ("Null element found at index: " + i);
            }
        }
        }
    
    
    public static int totalLenWithSeperators(String[] strings, int sepLen) {  
    	
        int totalLength = Arrays.stream(strings)
            .filter(s -> s != null)
            .mapToInt(k -> k.length() + sepLen)
            .sum() - sepLen;  
    
        return totalLength;
    }
    
  
    
    public static void checkCharNull(char ch) throws TaskException {
        if (ch == '\0') {
            throw new TaskException (ExceptionMessages.EMPTY_CHAR_ERROR);
        }
    }
    
    public static boolean isNegative(int num) throws TaskException { 
        if (num < 0) {
            throw new TaskException (ExceptionMessages.NEGATIVE_VALUE_ERROR);
        }
        return false;  
    }
    
    public static boolean isArrEmpty(Object[] strings) throws TaskException {
        if (strings.length == 0) {
            throw new TaskException (ExceptionMessages.EMPTY_STRING_ERROR);
        }
        return false;
    }

    														
    public static void checkLength(int actualLength, int requiredLength) throws TaskException {
       
          isNegative( requiredLength );
          isNegative( actualLength );
          
        if (actualLength < requiredLength) {
            throw new TaskException (ExceptionMessages.LENGTH_ERROR);
        }
  }
    
    
    public static <T> int getListSize(T[] inputs) throws TaskException {
    	checkNull(inputs);
        return inputs.length;
    }
    
    // Helper method for List size
    public static <T> int getListLength(List<T> list) throws TaskException {
    	checkNull(list);
        return list.size();
    }
    
    // Helper to get map size.
    public static <K, V> int getMapSize(Map<K,V> map) throws TaskException {
    	checkNull(map);
        return map.size();
    }
    
 // getters for file creators
 	public static FileCreator getFileCreator() {
 		FileCreator fileCreator = new FileCreator();
 		return fileCreator;
 	}
 	
 	public static PropertiesManager getPropertiesManager() {
 		PropertiesManager propertiesManager =new PropertiesManager();
 		return propertiesManager;
 	}
 	
 	public static PropertiesReader getPropertiesReader() {
 		PropertiesReader propertiesReader = new PropertiesReader();
 		return propertiesReader ;
 	}
 	
 	  
 // Helper methods

 	public static boolean matchesRegex(String regex, String input) throws TaskException {
     	Helper.checkNull(input);
     	Helper.checkNull(regex);
     	 
         return Pattern.matches(regex, input);
     }

 	public static boolean startsWith(String str, String prefix) throws TaskException {
     	 
         
         String regex = "^" + Pattern.quote(prefix);
         return str.matches(regex + ".*");
     }

 	public static boolean contains(String str, String substring) throws TaskException {
     	 
         // Pattern: Matches the substring anywhere in the string.
         String regex = ".*" + Pattern.quote(substring) + ".*";
         return str.matches(regex);
     }

 	public static boolean endsWith(String str, String suffix) throws TaskException {
     	
         // Pattern: Matches the suffix at the end of the string.
         String regex = ".*" + Pattern.quote(suffix) + "$";
         return str.matches(regex);
     }

     
 	public static boolean exactMatch(String str1, String str2) throws TaskException {
     	
     	
         // Pattern: Matches the entire string exactly.
         String regex = "^" + Pattern.quote(str2) + "$";
         return str1.matches(regex);
     }

 	public static List<Integer> findIndices(List<String> list, String match) throws TaskException {
     	
     	int len = list.size();
     	
     	List<Integer> indices = new ArrayList<>();
     	
         for (int i = 0; i < len; i++) {
         	if(exactMatch(list.get(i), match)) {
            
                 indices.add(i);
             }
         }
         return indices;
     }
     
 	public static class LengthValidator {
         private final Integer filterLen;

         public LengthValidator(Integer filterLen) {
             this.filterLen = filterLen;
         }

         public boolean isValidLength(String str) {
             int len = str.length();
             return len >= 1 && len <= filterLen;
         }
     }
    
 	public static Pattern compilePattern(String regex) throws TaskException {
         try {
             return Pattern.compile(regex);
         } catch (Exception e) {
             throw new TaskException(ExceptionMessages.REGEX_ERROR);
         }
     }

 	public static List<String> filterMatchingStrings(List<String> list, Pattern pattern) {
         return list.stream()
                    .filter(str -> pattern.matcher(str).find())
                    .collect(Collectors.toList());
     }
     
 	public static Map<String, List<Integer>> findMatchingIndices(List<String> list1, List<String> list2) throws TaskException {
         Map<String, List<Integer>> resultMap = new HashMap<>();
         
         for (String match : list2) {
             resultMap.put(match, findIndices(list1, match));
         }
         return resultMap;
     }
     
 	public static List<String> findPatternMatches(String input, String regex) {
         List<String> results = new ArrayList<>();
         
         Matcher matcher = Pattern.compile(regex).matcher(input);
         while (matcher.find()) {
             results.add(matcher.group());
         }
         return results;
     }



 	
}

