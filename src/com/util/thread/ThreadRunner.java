package com.util.thread;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.util.customexception.TaskException;

public class ThreadRunner {
    private static final String logFilePath = "thread_log.txt"; // Log file path
    private static ArrayList<ExtendedThread> extendedThreads = new ArrayList<>();
    private static ArrayList<RunnableThread> runnableThreads = new ArrayList<>();
  
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu for user interaction
        while (true) {
            System.out.println("\n--- Thread Runner Menu ---");
            System.out.println("1. Create ExtendedThreads");
            System.out.println("2. Create RunnableThreads");
            System.out.println("3. Stop a specific ExtendedThread");
            System.out.println("4. Stop a specific RunnableThread");
            System.out.println("5. Take Thread Dumps");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        createThreads(scanner, true); // Create ExtendedThreads
                        break;

                    case 2:
                        createThreads(scanner, false); // Create RunnableThreads
                        break;

                    case 3:
                        stopThread(scanner, true); // Stop an ExtendedThread
                        break;

                    case 4:
                        stopThread(scanner, false); // Stop a RunnableThread
                        break;

                    case 5:
                        takeThreadDumps(scanner); // Take thread dumps
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        throw new TaskException("Invalid choice.");
                }
            } catch (TaskException e) {
                System.err.println("TaskException: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    // Method to create threads (both ExtendedThread and RunnableThread)
    private static void createThreads(Scanner scanner, boolean isExtended) throws TaskException {
        System.out.print("Enter the number of threads to create: ");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.print("Enter name for " + (isExtended ? "ExtendedThread" : "RunnableThread") + "-" + (i + 1) + ": ");
            String name = scanner.next();
            System.out.print("Enter sleep time (in milliseconds) for " + name + ": ");
            long sleepTime = scanner.nextLong();

            if (isExtended) {
                ExtendedThread extThread = new ExtendedThread(name, sleepTime, logFilePath);
                extendedThreads.add(extThread);
                extThread.start();
                ThreadCore.logToFile(logFilePath, "Spawned: " + extThread.getName());
            } 
            else {
                RunnableThread runThread = new RunnableThread(name, sleepTime, logFilePath);
                runnableThreads.add(runThread);
                runThread.start();
                ThreadCore.logToFile(logFilePath, "Spawned: " + runThread.getThread().getName());
            }
        }
    }

    // Method to stop a specific thread (both ExtendedThread and RunnableThread)
    private static void stopThread(Scanner scanner, boolean isExtended) throws TaskException {
        ArrayList<?> threads = isExtended ? (ArrayList<?>) extendedThreads : runnableThreads;
        String threadType = isExtended ? "ExtendedThread" : "RunnableThread";

        System.out.println("List of " + threadType + "s:");
        for (int i = 0; i < threads.size(); i++) {
            System.out.println((i + 1) + ". " + (isExtended ? ((ExtendedThread) threads.get(i)).getName() : ((RunnableThread) threads.get(i)).getThread().getName()));
        }
        System.out.print("Enter the index of the " + threadType + " to stop: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < threads.size()) {
            if (isExtended) {
                ((ExtendedThread) threads.get(index)).stopRunning();
                ThreadCore.logToFile(logFilePath, "Stopped: " + ((ExtendedThread) threads.get(index)).getName());
            } else {
                ((RunnableThread) threads.get(index)).stopRunning();
                ThreadCore.logToFile(logFilePath, "Stopped: " + ((RunnableThread) threads.get(index)).getThread().getName());
            }
        } else {
            throw new TaskException("Invalid index.");
        }
    }

    // Method to take thread dumps using Thread.getAllStackTraces()
    private static void takeThreadDumps(Scanner scanner) throws InterruptedException {
    	
        System.out.print("Enter the number of thread dumps to take: ");
        int dumpCount = scanner.nextInt();
        System.out.print("Enter the interval between thread dumps (in milliseconds): ");
        long dumpInterval = scanner.nextLong();

        for (int i = 0; i < dumpCount; i++) {
            StringBuilder dumpMessage = new StringBuilder("\n--- Internal Thread Dump " + (i + 1) + " ---\n");

            // Get all stack traces for live threads
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();

            // Print stack traces using a separate method
            dumpMessage.append(ThreadCore.printStackTraces(allStackTraces));

            // Log the thread dump
            ThreadCore.logToFile(logFilePath, dumpMessage.toString());

            // Wait for the specified interval
            Thread.sleep(dumpInterval);
        }
    }

  
}