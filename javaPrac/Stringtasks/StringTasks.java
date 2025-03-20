import com.util.helpers.Helper;
import com.util.customexception.*;
import java.util.stream.Stream;
import java.util.StringJoiner;



public class StringTasks {

	
   
    // === Public Methods === 
//1
    public int getLength(String str) throws TaskException {
       Helper.checkNull(str);
        return str.length();
    }

    public char[] convertToCharArray(String str) throws TaskException {
        Helper.checkNull(str);
        if (str.isEmpty()) {  
            throw new TaskException (ExceptionMessages.EMPTY_STRING_ERROR);
        }
        return str.toCharArray();
    }
//2
    public char getUltimateChar(String str, int reqChar) throws TaskException {
        Helper.checkNull(str);
        if (reqChar < 0) {
            throw new TaskException (ExceptionMessages.NEGATIVE_VALUE_ERROR);
        }
        int strLen = getLength(str);
        Helper.checkLength(strLen, reqChar);
        return str.charAt(strLen - reqChar);
    }
//3
    public int countOccurrences(String str, char ch) throws TaskException {
        Helper.checkNull(str);
        Helper.checkCharNull(ch);
        return (int) str.chars().filter(c -> c == ch).count();
    }
//4
    public int getLastOccurrence(String str, char ch) throws TaskException {
        Helper.checkNull(str);
        return str.lastIndexOf(ch);
    }
//5
    public String getLastNChars(String str, int lastNChar) throws TaskException {
        if (lastNChar < 0) {
            throw new TaskException (ExceptionMessages.NEGATIVE_VALUE_ERROR);
        }
        int strLen = getLength(str);
        Helper.checkLength(strLen, lastNChar);
        return str.substring(Math.max(0, strLen - lastNChar));
    }
//6
    public String getFirstNChars(String str, int firstNChar) throws TaskException {
        if (firstNChar < 0) {
            throw new TaskException (ExceptionMessages.NEGATIVE_VALUE_ERROR);
        }
        int strLen = getLength(str);
        Helper.checkLength(strLen, firstNChar);
        return str.substring(0, firstNChar);
    }
//7
    public String stringReplacer(String str, String replacer, int replaceNum) throws TaskException {
        int strLen = getLength(str);
        int replacerLen = getLength(replacer);
        Helper.checkLength(strLen, replaceNum);
        return replacer + str.substring(replaceNum);
    }
//8
    public boolean startsWith(String str, String start) throws TaskException {
        int strLen = getLength(str);
        int startLen = getLength(start);
        Helper.checkLength(strLen, startLen);
        return str.startsWith(start);
    }
//9
    public boolean endsWith(String str, String end) throws TaskException {
        int strLen = getLength(str);
        int endLen = getLength(end);
        Helper.checkLength(strLen, endLen);
        return str.endsWith(end);
    }
//10
    public String toUpperCase(String str) throws TaskException {
        Helper.checkNull(str);
        return str.toUpperCase();
    }
//11
    public String toLowerCase(String str) throws TaskException {
        Helper.checkNull(str);
        return str.toLowerCase();
    }
//12
    public String reverseString(String str) throws TaskException {
         
         char[] charArray = convertToCharArray(str);
         int len = getLength(str);
         
         for(int i=0; i< len/2; i++){
         	char temp = charArray[i];
         	charArray[i] = charArray[len-i-1];
         	 charArray[len-i-1] = temp;
         
         }
  
    return new String(charArray);
    }
 //13   
    public String inputMultipleStrings(String inputLine) throws TaskException {
        Helper.checkNull(inputLine);
        String trimmed = inputLine.trim(); 
        if (trimmed.isEmpty()) {
            throw new TaskException (ExceptionMessages.EMPTY_STRING_ERROR);
        }
        return trimmed;
    }
//14
    public String concatenateWithoutTarget(String str, String target) throws TaskException {
        Helper.checkNull(str);
        Helper.checkNull( target);
        return str.replace(target, "");
    }
//15
    public String[] stringToArray(String str, String separator) throws TaskException {
        Helper.checkNull(str);
        Helper.checkNull(separator);
        if (separator.isEmpty()) { 
            throw new TaskException (ExceptionMessages.EMPTY_SEPARATOR_ERROR);
        }
        return str.split(separator);
    }
//16 
    public String replaceWithAnyChar(String input, String target, String replacer) throws TaskException {
        Helper.checkNull(input);
        Helper.checkNull( target);
        Helper.checkNull(replacer);
        if (target.isEmpty()) {  
            throw new TaskException (ExceptionMessages.EMPTY_TARGET_ERROR);
        }
        return input.trim().replaceAll(target, replacer);
    }
    
 //17
    public String mergeStrings(String[] strings, String separator) throws TaskException { 
        Helper.checkNull(strings);
        Helper.isArrEmpty(strings);
        Helper.isArrayElementNull(strings);
        
    return String.join(separator, strings);
    	
    	
    }
    
//18
    public boolean areStringsEqual(String str1, String str2) throws TaskException {
        Helper.checkNull(str1);
        Helper.checkNull(str2);
        return str1.equals(str2);
    }
//19
    public boolean areStringsEqualIgnoreCase(String str1, String str2) throws TaskException {
        Helper.checkNull(str2);
        Helper.checkNull(str1);
        return str1.equalsIgnoreCase(str2);
    }
//20
    public String trimString(String str) throws TaskException {
        Helper.checkNull(str);
        return str.trim();
    }
}
