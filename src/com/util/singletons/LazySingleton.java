package com.util.singletons;

public class LazySingleton {
	
	 private static LazySingleton instance;

	    // Private constructor to prevent instantiation
	    private void LazySingleton() {}

	    // Public method to get the instance
	    public static LazySingleton getInstance() {
	        if (instance == null) {
	            instance = new LazySingleton();
	        }
	        return instance;
	    }
	    
	    //Not thread-safe


	    
}
