package arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.util.customexception.ExceptionMessages;
import com.util.customexception.TaskException;
import com.util.helpers.Helper;

public class ArrayListTasks {

    // Task 1: Create an empty List and return its size. 
    public <T> List<T> getList() {
        return new ArrayList<>();
    }


    // Task 2: Add 'count' elements of a specific type to the List
    public <T> List<T> addElements(T[] inputs) throws TaskException {
     
        int len = Helper.getListSize(inputs);
        
        List<T> list = getList();
        for (int i = 0; i < len; i++) {
            list.add(inputs[i]);
        }
        return list;
    }
    
    

    // Task 3: Find the index of a target element in the list
    public <T> int findIndexOfElement(List<T> list, T target) throws TaskException {
        Helper.checkNull(list);
        Helper.checkNull(target);
        
        int index = list.indexOf(target);
  
        return index;
        
    }

    // Task 4: Return string representation using iterator and for loop
    public <T> Iterator<T> getIterator(List<T> list) throws TaskException {
     
        Helper.checkNull(list);

        return list.iterator();
    }

    public <T> T getElementAtIndex(List<T> list, int index) throws TaskException {
       
        int len = Helper.getListLength(list);  // Using new helper method
        Helper.checkLength(len, index);
        return list.get(index);
    }

    // Task 6: Find first and last occurrence of a target element
  
    public <T> int[] findFirstAndLastPosition(List<T> list, T target) throws TaskException {
        Helper.checkNull(list); 
        Helper.checkNull(target);
        
        int first = list.indexOf(target); // Find first occurrence
        
        if (first == -1) {
        	throw new TaskException(ExceptionMessages.ELEMENT_NOT_FOUND);
        }
        
        int last = list.lastIndexOf(target); // Find last occurrence
        return new int[]{first, last};
    }
 
    // Task 7: Add an element at a specific position
    public <T> List<T> addElementAtPosition(List<T> list, int position, T value) throws TaskException {
        
        Helper.checkNull(value);
        
        int len = Helper.getListLength(list);
        Helper.checkLength(len, position);
        list.add(position, value);
        return list;
    }

    // Task 8: Create a sublist from start to end index
 
	public <T> List<T> createSublist(List<T> list, int start, int end) throws TaskException {
     
        Helper.checkLength(end, start);
        int len  = Helper.getListLength(list);
        Helper.checkLength(len, end);
        
        List<T> list1 =  list.subList(start, end);
       
        return list1;
        
      
    }

    // Task 9: Merge two Lists 
		public <T> List<T> mergeLists(List<T> list1, List<T> list2, boolean secondFirst) throws TaskException {
    	
    	 Helper.checkNull(list1); 
    	 Helper.checkNull(list2); 

    	 if (secondFirst) {
    		 list2.addAll(list1);
    		 return list2;      
    	 } 

    	 list1.addAll(list2);
    	 return list1;        
    	    
    }

    // Task 10: Remove an element at a specific index
    public <T> List<T> removeElementAtIndex(List<T> list, int index) throws TaskException {
        
        int len = Helper.getListLength(list);
        
        Helper.checkLength(len, index);
        
        if(len== index) {
        	throw new TaskException(ExceptionMessages.INDEX_OUT_OF_BOUND);
        }
        
        list.remove(index);
        return list;
    }

    // Task 11: Remove elements present in the second list
    public <T> List<T> removeAllPresent(List<T> list1, List<T> list2) throws TaskException {
        Helper.checkNull(list1);
        Helper.checkNull(list2);
        list1.removeAll(list2);
        return list1;
    }

    // Task 12: Retain elements present in the second list
    public <T> List<T> retainAllPresent(List<T> list1, List<T> list2) throws TaskException {
        Helper.checkNull(list1);
        Helper.checkNull(list2);
        list1.retainAll(list2);
        return list1;
    }

    // Task 13: Clear all elements from the list
    public <T> List<T> clearList(List<T> list) throws TaskException {
        Helper.checkNull(list);
        list.clear();
        return list;
    }
    // Task 14: Check if an element is present in the list
    public <T> boolean checkElementPresence(List<T> list, T target) throws TaskException {
        Helper.checkNull(list);
        Helper.checkNull(target);
        
        return list.contains(target);
    }
}