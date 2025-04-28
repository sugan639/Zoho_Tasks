package com.util.thread;


public class ThreadLocalExample {
    // Create a ThreadLocal variable
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable task1 = () -> {
            threadLocal.set("Data for Thread A");
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        };

        Runnable task2 = () -> {
            threadLocal.set("Data for Thread B");
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        };
        

        Thread t1 = new Thread(task1, "Thread-A");
        Thread t2 = new Thread(task2, "Thread-B");

        t1.start();
        t2.start();
    }
}
