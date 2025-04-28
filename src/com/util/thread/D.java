package com.util.thread;

public class D {
    public  void processData() {
    	
    	Context context = A.threadLocalContext.get();
    	
        if (context != null) {
            System.out.println(context);
        
    }
        
}}