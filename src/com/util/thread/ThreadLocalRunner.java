package com.util.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadLocalRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of threads to spawn: ");
        int numberOfThreads = scanner.nextInt();
        scanner.nextLine(); 

        // List to store threads
        List<Thread> threads = new ArrayList<>();

        
        String[] threadNames = new String[numberOfThreads];

      
        for (int i = 0; i < numberOfThreads; i++) {
            System.out.print("\nEnter a name for thread " + (i + 1) + ": ");
            threadNames[i] = scanner.nextLine();
        }

        // Create threads
        for (int i = 0; i < numberOfThreads; i++) {
            String name = threadNames[i];
            Thread thread = new Thread(new RunnableThreadLocal(name, i + 1), "Thread-" + (i + 1));
            threads.add(thread);
        }

        
        for (Thread thread : threads) {
            thread.start();

        }

        scanner.close();
    }
}