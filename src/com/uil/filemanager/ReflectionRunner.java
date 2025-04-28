package com.uil.filemanager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import com.util.customexception.TaskException;

public class ReflectionRunner {
    
    public Object invokeDefaultConstructor(String className) throws TaskException {
        try {
        	
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getDeclaredConstructor();
          
            return constructor.newInstance();
            
            
        } 
        catch (ClassNotFoundException |NoSuchMethodException |InstantiationException 
        		|IllegalAccessException | InvocationTargetException e) 
        	{
        	    throw new TaskException("Unable to invoke the method", e); // ← this fixes it
        	}
        
    }

    public Object invokeOverloadedConstructor(String className,
    		Class<?>[] paramTypes, Object[] params) throws TaskException {
    	
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getDeclaredConstructor(paramTypes);
            
            return constructor.newInstance(params);
            
        } 
        catch (ClassNotFoundException |NoSuchMethodException |InstantiationException 
        		|IllegalAccessException e) 
    	{
    	    throw new TaskException("Unable to invoke the method", e); // ← this fixes it
    	}
        catch (Exception e) {
            throw new TaskException(className, e);
        }
    }

    public Object invokeGetter(Object obj, String methodName) throws TaskException {
    	
        try {
            Class<?> clazz = obj.getClass();
            Method method = clazz.getDeclaredMethod(methodName);
            
            return method.invoke(obj);
            
        } 
        
        catch (NoSuchMethodException |IllegalAccessException e) 
    	{
    	    throw new TaskException("Unable to invoke the method", e); // ← this fixes it
    	}
        
        catch (Exception e) {
            throw new TaskException(methodName, e);
        }
    }

    public void invokeSetter(Object obj, String methodName, 
    		Class<?> paramType, Object paramValue) throws TaskException {
    	
        try {
            Class<?> clazz = obj.getClass();
            Method method = clazz.getDeclaredMethod(methodName, paramType);
           
            method.invoke(obj, paramValue);
        } 
        catch (NoSuchMethodException |IllegalAccessException e) 
    	{
    	    throw new TaskException("Unable to invoke the method", e); // ← this fixes it
    	}
        
        catch (Exception e) {
            throw new TaskException(methodName, e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReflectionRunner runner = new ReflectionRunner();
        Object currentObject = null;

        while (true) {
            System.out.println("\n=== Reflection Runner Menu ===");
            System.out.println("1. Invoke Default Constructor");
            System.out.println("   Example: filerunner.DataContainer");
            System.out.println("2. Invoke Overloaded Constructor");
            System.out.println("   Example: filerunner.DataContainer, String, int (then enter values)");
            System.out.println("3. Invoke Getter");
            System.out.println("   Example: getStr (requires object from constructor first)");
            System.out.println("4. Invoke Setter");
            System.out.println("   Example: setStr, String, Hello (requires object first)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter class name: ");
                        String className = scanner.nextLine();
                        currentObject = runner.invokeDefaultConstructor(className);
                        System.out.println("Object created: " + currentObject);
                        break;

                    case 2:
                        System.out.print("Enter class name: ");
                        className = scanner.nextLine();
                        System.out.print("Enter String value: ");
                        String strValue = scanner.nextLine();
                        System.out.print("Enter int value: ");
                        int intValue = scanner.nextInt();
                        scanner.nextLine();
                        Class<?>[] paramTypes = {String.class, int.class};
                        Object[] params = {strValue, intValue};
                        currentObject = runner.invokeOverloadedConstructor(className, paramTypes, params);
                        System.out.println("Object created: " + currentObject);
                        break;

                    case 3:
                        if (currentObject == null) {
                            System.out.println("Error: Create an object first using constructor");
                            break;
                        }
                        System.out.print("Enter getter method name: ");
                        String getterName = scanner.nextLine();
                        Object result = runner.invokeGetter(currentObject, getterName);
                        System.out.println("Getter result: " + result);
                        break;

                    case 4:
                        if (currentObject == null) {
                            System.out.println("Error: Create an object first using constructor");
                            break;
                        }
                        System.out.print("Enter setter method name: ");
                        String setterName = scanner.nextLine();
                        System.out.print("Enter parameter type (String/int): ");
                        String type = scanner.nextLine();
                        System.out.print("Enter value: ");
                        if (type.equalsIgnoreCase("String")) {
                            String value = scanner.nextLine();
                            runner.invokeSetter(currentObject, setterName, String.class, value);
                        } else if (type.equalsIgnoreCase("int")) {
                            int value = scanner.nextInt();
                            scanner.nextLine();
                            runner.invokeSetter(currentObject, setterName, int.class, value);
                        } else {
                            System.out.println("Unsupported type. Use String or int.");
                        }
                        System.out.println("Setter executed. New object state: " + currentObject);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please select 1-5.");
                }
            } catch (TaskException e) {
                System.err.println("Reflection error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}