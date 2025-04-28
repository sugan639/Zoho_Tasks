package com.util.singletons;
import java.io.*;

class BrokenSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private BrokenSingleton() {
        System.out.println("Constructor called");
    }

    private static class SingletonHelper {
        private static final BrokenSingleton INSTANCE = new BrokenSingleton();
    }

    public static BrokenSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
   
    private Object readResolve() {
        return getInstance();
    }
}

public class DemoSerializationProblem {
    public static void main(String[] args) {
        try {
            BrokenSingleton instanceOne = BrokenSingleton.getInstance();

            // Serialize
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.ser"));
            out.writeObject(instanceOne);
            out.close();

            // Deserialize
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.ser"));
            BrokenSingleton instanceTwo = (BrokenSingleton) in.readObject();
            in.close();

            System.out.println("Instance One HashCode: " + instanceOne.hashCode());
            System.out.println("Instance Two HashCode: " + instanceTwo.hashCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
