package com.util.thread;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.util.customexception.TaskException;

public class ExtendedThread extends Thread {
    private volatile boolean running = true; // Condition variable for the while loop
    private long sleepTime;
    private String logFilePath;

    public ExtendedThread(String name, long sleepTime, String logFilePath) throws TaskException {
        super(name);
        this.sleepTime = sleepTime;
        this.logFilePath = logFilePath;
        validateParameters();
    }

    @Override
    public void run() {
        try {
            logMessage("Thread Name: " + getName() + ", Priority: " + getPriority() + ", State: " + getState());
            while (running) {
                logMessage("Going to Sleep: " + getName());
                Thread.sleep(sleepTime); // Sleep for the specified time
                logMessage("After sleeping: " + getName());
            }
            logMessage(getName() + " has exited.");
        } 
        catch (InterruptedException e) {
            throw new RuntimeException(new TaskException(getName() + " was interrupted.", e));
        } 
        catch (IOException e) {
            throw new RuntimeException(new TaskException("Error writing to log file.", e));
        }
    }

    public void stopRunning() {
        running = false; // Setter method to stop the thread
    }

    private void logMessage(String message) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true))) {
            writer.write(message);
            writer.newLine();
        }
    }

    private void validateParameters() throws TaskException {
        if (sleepTime <= 0) {
            throw new TaskException("Sleep time must be greater than 0.");
        }
        if (logFilePath == null || logFilePath.isEmpty()) {
            throw new TaskException("Log file path cannot be null or empty.");
        }
    }
}