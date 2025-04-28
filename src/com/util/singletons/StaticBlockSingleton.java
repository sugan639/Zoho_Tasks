package com.util.singletons;

public class StaticBlockSingleton {
	
	
	private static final StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance", e);
        }
    }
    
    private StaticBlockSingleton() {}

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
    
    
    
}
