package com.util.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.util.customexception.TaskException;
import com.util.helpers.Helper;

public class HashTasks {

 

    // Task 1: Create a HashMap 
    public <K, V> Map<K, V> createHashMap() {
        return new HashMap<>();
    }

    // Task 2-7: Add a key-value pair to the HashMap.
    public <K, V> Map<K, V> addKeyValuePair(Map<K, V> map, K key, V value) throws TaskException {
        Helper.checkNull(map);
       
        map.put(key, value);
        return map;
    }
    // Task 8: check key existing
    public <K,V> Boolean checkKeyExists(Map<K,V> map, K key ) throws TaskException {
    	Helper.checkNull(map);
    	return map.containsKey(key);
    }
    
    // Task 9: Check a value exists i Map
    public <K,V> Boolean checkValueExists(Map<K,V>map, V value) throws TaskException {
    	Helper.checkNull(map);
    	return map.containsValue(value);
    }
    
 // Task 10: Change values for all keys in the HashMap.
    public <K, V> Map<K, V> changeValues(Map<K, V> map, V newValue) throws TaskException {
        Helper.checkNull(map);
        
        map.replaceAll((key, oldValue) -> newValue);
        return map;
    }

    // Task 11-13: Return  a default value for a non-existing key.
    public <K, V> V getDefaultValueForNonExistingKey(Map<K, V> map, K key, V defaultValue) throws TaskException {
        Helper.checkNull(map);
        return map.getOrDefault(key, defaultValue);
    }

    
 // Task 14: Remove an existing key from the HashMap.
    public <K, V> Map<K, V> removeExistingKey(Map<K, V> map, K key) throws TaskException {
        Helper.checkNull(map);
        
        map.remove(key); // returns null if if key not present
        return map;
    }
    
    // Task 15: Remove an existing key only if its value matches.
    public <K, V> Map<K, V> removeKeyWithMatchingValue(Map<K, V> map, K key, V value) throws TaskException  {
        Helper.checkNull(map);
      
        map.remove(key, value);
        
        return map;
    }
    
    
 
    
 // Task 16: Replace the value of an existing key.
    public <K, V> Map<K, V> replaceValue(Map<K, V> map, K key, V newValue) throws TaskException {
        Helper.checkNull(map);
        
        map.replace(key, newValue); // returns null if if key not present
        return map;
    }
    
    // Task 17: Replace the value of an existing key only if its current value matches the old value.
    
    public <K, V> Map<K, V> replaceValueIfMatching(Map<K, V> map, K key, V oldValue, V newValue) throws TaskException {
        Helper.checkNull(map);
       
        map.replace(key, oldValue, newValue);
        
        return map;
    }

    // Task 18: Transfer all keys and values from one HashMap to another.
    public <K, V> Map<K, V> transferMaps(Map<K, V> source, Map<K, V> destination) throws TaskException {
        Helper.checkNull(source);
        Helper.checkNull(destination);
        destination.putAll(source);
        return destination;
    }

    // Task 19: Return an iterator over the HashMap.
    public <K, V> Iterator<Map.Entry<K, V>> getIterator(Map<K, V> map) throws TaskException {
        Helper.checkNull(map);
        return map.entrySet().iterator();
    }
    
 // Task 20: Remove all entries from the HashMap.
    public <K, V> Map<K, V> removeAllEntries(Map<K, V> map) throws TaskException {
        Helper.checkNull(map);
        map.clear();
        return map;
    }
}