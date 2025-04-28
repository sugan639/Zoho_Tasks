package com.util.thread;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.util.customexception.TaskException;

public class ThreadCore {
	  // Method to print stack traces
    public static String printStackTraces(Map<Thread, StackTraceElement[]> allStackTraces) {
        StringBuilder stackTraceBuilder = new StringBuilder();

        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            Thread thread = entry.getKey();
            StackTraceElement[] stackTraceElements = entry.getValue();

            stackTraceBuilder.append("Thread Name: ").append(thread.getName())
                    .append(", State: ").append(thread.getState())
                    .append(", Stack Trace:\n");

            if (stackTraceElements.length == 0) {
                stackTraceBuilder.append("\tNo stack trace available.\n");
            } else {
                for (StackTraceElement stackTraceElement : stackTraceElements) {
                    stackTraceBuilder.append("\t").append(stackTraceElement).append("\n");
                }
            }
        }

        return stackTraceBuilder.toString();
    }

    // Method to log messages to the file
    public static void logToFile(String logFilePath, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(new TaskException("Error writing to log file.", e));
        }
    }
}
