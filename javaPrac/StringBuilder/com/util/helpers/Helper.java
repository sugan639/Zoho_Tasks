package com.util.helpers;

import com.util.customexception.*;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.StringJoiner;
import java.lang.String;


public class Helper{

    // === Helper Methods ===
    // Single string null check
    public static void checkNull(Object str) throws TaskException {
        if (str == null) {
            throw new TaskException (ExceptionMessages.NULL_INPUT_ERROR);
        }
        
    }
    
    public static StringBuilder getResult(StringBuilder sb) {
    
        sb.append("  Length: " + sb.length() + ", String: " + sb);
        return sb;
    }
    
     public static int getLength(String str) throws TaskException {
        return str.length();
        
    }
   
 
	
	// Array elemnt nullity check
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
       
        
          if (requiredLength < 0) {
            throw new TaskException (ExceptionMessages.NEGATIVE_VALUE_ERROR);
        }
        if (actualLength < requiredLength) {
            throw new TaskException (ExceptionMessages.LENGTH_ERROR);
        }
        
      
  }

}

