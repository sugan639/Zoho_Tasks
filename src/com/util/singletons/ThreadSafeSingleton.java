package com.util.singletons;

public class ThreadSafeSingleton {
	 private static ThreadSafeSingleton instance;

	    private ThreadSafeSingleton() {}

	    public static synchronized ThreadSafeSingleton getInstance() {
	        if (instance == null) {
	            instance = new ThreadSafeSingleton();
	        }
	        return instance;
	    }
	 
	 //Performance overhead due to synchronization on every call lock/unlock
	    
	    //contention
	    // cpu cycles
	    // unnecessary syncronisation
}
