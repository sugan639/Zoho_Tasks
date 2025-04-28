package com.util.singletons;

public class DoubleCheckedLockingSingletonton3 {
	 private static volatile DoubleCheckedLockingSingletonton3 instance;

	    private DoubleCheckedLockingSingletonton3() {}

	    public static DoubleCheckedLockingSingletonton3 getInstance() {
	        if (instance == null) { // First check (no locking)
	            synchronized (DoubleCheckedLockingSingletonton3.class) {
	                if (instance == null) { // Second check (with locking)
	                    instance = new DoubleCheckedLockingSingletonton3();
	                }
	            }
	        }
	        return instance;
	    }
	    
	    //Complex to implement correctly.


}
