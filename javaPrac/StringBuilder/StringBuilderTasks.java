import com.util.customexception.TaskException;
import com.util.customexception.ExceptionMessages;
import com.util.helpers.Helper;

public class StringBuilderTasks {
	
    public StringBuilder getStringBuilder(){
    	StringBuilder sb = new StringBuilder();
    	return sb;
    }
    

    // Task 1: Append string
    public StringBuilder appendString(StringBuilder sb, String input) throws TaskException {
        Helper.checkNull(input);
        sb.append(input);
        return Helper.getResult(sb);
    }

    // Task 2: Append multiple strings with separator
    public StringBuilder concatenateStrings(StringBuilder sb, String[] inputs, String separator) throws TaskException {
	    Helper.checkNull(inputs);
	    Helper.checkNull(separator);
	    Helper.isArrEmpty(inputs);
	    Helper.isArrayElementNull(inputs);
	    
	    int sepLen = Helper.getLength(separator);
	    int totalLen = Helper.totalLenWithSeperators(inputs, sepLen);
	    
	    sb.append(inputs[0]);
	    for (int i = 1; i < inputs.length; i++) {
		sb.append(separator).append(inputs[i]);
	    }
	    return Helper.getResult(sb);
}


    // Task 3: Insert string at position
    public StringBuilder insertAtPosition(StringBuilder sb, String original, String toInsert, int position) throws TaskException {
        Helper.checkNull(original);
        Helper.checkNull(toInsert);
        Helper.isNegative(position);
        Helper.checkLength(original.length(), position);
        sb.append(original);
        
        sb.insert(position, toInsert);
        return Helper.getResult(sb);
    }

    // Task 4: Delete portion
    public StringBuilder deletePortion(StringBuilder sb, String original, int start, int end) throws TaskException {
        Helper.checkNull(original);
        Helper.isNegative(start);
        Helper.checkLength(original.length(), end);
        Helper.checkLength(end, start);
        sb.append(original);
        
        sb.delete(start, end);
        return Helper.getResult(sb);
    }

    // Task 5: Replace character
    public StringBuilder replaceChar(StringBuilder sb, String original, int index, char newChar) throws TaskException {
        Helper.checkNull(original);
        Helper.checkCharNull(newChar);
        sb.append(original);
        
        sb.setCharAt(index, newChar);
        
        return Helper.getResult(sb);
    }

    // Task 6: Reverse string
    public StringBuilder reverseString(StringBuilder sb, String original) throws TaskException {
        Helper.checkNull(original);
        
        sb.append(original);
       
        sb = sb.reverse();
       
        return sb;
    }

    // Task 7: Delete range
    public StringBuilder deleteRange(StringBuilder sb, String original, int start, int end) throws TaskException {
        Helper.checkNull(original);
        Helper.isNegative(start);
        Helper.checkLength(original.length(), end);
        Helper.checkLength(end, start);
        sb.append(original);
        
        sb.delete(start, end);
        return Helper.getResult(sb);
    }

    // Task 8: Replace range
    public StringBuilder replaceRange(StringBuilder sb, String original, int start, int end, String replacement) throws TaskException {
        Helper.checkNull(original);
        Helper.checkNull(replacement);
        Helper.isNegative(start);
        Helper.checkLength(original.length(), end);
        Helper.checkLength(end, start);
        sb.append(original);
        
        sb.replace(start, end, replacement);
        return Helper.getResult(sb);
    }

    // Task 9: Find first occurrence
    public int findFirst(StringBuilder sb, String original, String search) throws TaskException {
        Helper.checkNull(original);
        Helper.checkNull(search);
        sb.append(original);
        
        int firstOccur = sb.indexOf(search);
        return firstOccur;
    }

    // Task 10: Find last occurrence
    public int findLast(StringBuilder sb, String original, String search) throws TaskException {
        Helper.checkNull(original);
        Helper.checkNull(search);
        sb.append(original);
        
        int firstOccur = sb.lastIndexOf(search);
        return firstOccur;
    }
}











































