package com.util.regex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.util.customexception.TaskException;
import com.util.helpers.Helper;
import com.util.helpers.Helper.LengthValidator;

public class RegexCore {

    // 3. Performs various checks on two strings using regex concepts.   
    
    public Map<String, Boolean> checkMatchingString(String givenString,
    												String matchingString, 
    												Map<String, String>  checks) 
    												throws TaskException {
    	
    	 Helper.checkNull(givenString);
         Helper.checkNull(matchingString);
         Helper.checkNull(checks);

         Map<String, Boolean> result = new HashMap<>();
         
         for (Map.Entry<String, String> entry : checks.entrySet()) {
             String checkName = entry.getKey();
             String regex = entry.getValue();
             
             result.put(checkName, givenString.matches(regex));
         }

         return result;
    }

    // 4. Case-insensitive matching of a string in a list. 
    
    public boolean caseInsensitiveMatch(List<String> list, String matchingString)
    													throws TaskException {
       
    	Helper.checkNull(matchingString);
        Helper.checkNull(list);
    
        Pattern pattern = Pattern.compile(matchingString, Pattern.CASE_INSENSITIVE);
    	
        return list.stream().anyMatch(pattern.asPredicate()); 
 }
    

    // 5. Validates an email address, phone number and alpha numeric strings.
   
    public boolean isMatchingRegex(String input, String regex) 
    									throws TaskException {
        
        return Helper.matchesRegex(regex, input);
    }

    
    // 6. Filters a list of strings based on length (1 to 6).
  
    public List<String> filterByLength(List<String> list, int filterLen) 
    									throws TaskException {
        Helper.checkNull(list);
        Helper.checkNull(filterLen);
        
        LengthValidator  validator= new LengthValidator(filterLen);

    	 return list.stream()
    	            .filter(validator::isValidLength)  
    	            .collect(Collectors.toList());
    } 
    

    // 7. Finds occurrences of strings from List2 in List1.
    
    public Map<String, List<Integer>> findOccurrences(List<String> list1,
    							 List<String> list2) throws TaskException {
    	
    	 Helper.checkNull(list1);
         Helper.checkNull(list2);
        
         return Helper.findMatchingIndices(list1, list2);
    }

    // 8, 9. Extracts HTML tags and currency symbol.
   
    public List<String> patternMatcher(String input, String regex) throws TaskException {
    	 
    	Helper.checkNull(input);
    	
    	return Helper.findPatternMatches(input, regex);
    }
    
    
    //10 Filter by regex
    public List<String> customRegex(List<String> list, String regex) throws TaskException {
    	 Helper.checkNull(list);
         Helper.checkNull(regex);
         
        return Helper.filterMatchingStrings(list, Helper.compilePattern(regex));
    }
    
}

















