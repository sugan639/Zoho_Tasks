package com.util.thread;

public class RunnableThreadLocal implements Runnable {
    private String name;
    private int threadNumber;

    public RunnableThreadLocal(String name, int threadNumber) {
        this.name = name;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
       A a = new A();
        a.setContext(name, threadNumber);

        a.clear();
    }
}

