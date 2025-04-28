package com.util.thread;

public class ThreadLocalDemo {

    // One shared ThreadLocal instance
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable task = () -> {
            // Each thread sets its own value
            threadLocal.set("Value for " + Thread.currentThread().getName());

            // Access value
            String value = threadLocal.get();

            // Reflectively access threadLocals map
            try {
                Thread currentThread = Thread.currentThread();
                java.lang.reflect.Field threadLocalsField = Thread.class.getDeclaredField("threadLocals");
                threadLocalsField.setAccessible(true);
                Object threadLocalMap = threadLocalsField.get(currentThread);

                System.out.println(Thread.currentThread().getName() + " => Value: " + value +
                        ", Map IdentityHashCode: " + System.identityHashCode(threadLocalMap));
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // Start 5 threads
        for (int i = 1; i <= 5; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
