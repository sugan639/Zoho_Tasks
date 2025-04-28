package com.util.singletons;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



class FixedSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private FixedSingleton() {
        System.out.println("Constructor called");
    }

    private static class SingletonHelper {
        private static final FixedSingleton INSTANCE = new FixedSingleton();
    }

    public static FixedSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    
   
}

public class DemoSerialization {
	public static void main(String[] args) {
		  try {
	            FixedSingleton instanceOne = FixedSingleton.getInstance();

	            // Serialize using try-with-resources
	            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.ser"))) {
	                out.writeObject(instanceOne);
	                
	                
	            }
	            

	            // Deserialize using try-with-resources
	            FixedSingleton instanceTwo;
	            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.ser"))) {
	                instanceTwo = (FixedSingleton) in.readObject();
	            }

	            System.out.println("Instance One HashCode: " + instanceOne.hashCode());
	            System.out.println("Instance Two HashCode: " + instanceTwo.hashCode());
	            return;
		  }
		  catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hello from catch ");
            return;
        }
		  
		  finally {
			  System.out.println("Hello from finally ");
		  }
    }
}
