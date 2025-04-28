package com.util.thread;

public class A {
    
    public static ThreadLocal<Context> threadLocalContext = new ThreadLocal<>();

    public  void setContext(String name, int threadNumber) {
    	
    	Context context = new Context(name, threadNumber);
        threadLocalContext.set(context);
      //  System.out.println(context);
        B b =  new B();
        b.processData();
    }

    
    public void clear() {
        threadLocalContext.remove();
    }
}