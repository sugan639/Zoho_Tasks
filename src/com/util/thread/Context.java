package com.util.thread;


public class Context {
   
        private String name;
        private int threadNumber;

        public Context(String name, int threadNumber) {
            this.name = name;
            this.threadNumber = threadNumber;
        }

        public String getName() {
            return name;
        }

        public int getThreadNumber() {
            return threadNumber;
        }
        
        @Override
        public String toString() {
            return "\nThread Data : {name='" + name + "', ThreadNumber=" + threadNumber + "}";
        }
    }

    
    
    

