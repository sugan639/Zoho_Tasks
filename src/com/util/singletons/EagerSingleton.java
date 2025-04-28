package com.util.singletons;

public class EagerSingleton {

	 private static final EagerSingleton instance = new EagerSingleton();

	    private EagerSingleton() {}

	    public static EagerSingleton getInstance() {
	        return instance;
	    }
	
	
	// Instance is created at class load time, even if unused.


	    //drawback in applications where resource efficiency or delayed initialization was critical.



	
	}

