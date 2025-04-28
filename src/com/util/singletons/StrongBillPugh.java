package com.util.singletons;

import java.io.Serializable;

public class StrongBillPugh implements Serializable, Cloneable {

    // Private constructor to prevent instantiation from outside
    private static final long serialVersionUID = 1L;

	private StrongBillPugh() {
        // Prevent reflection 
        if (SingletonHolder.INSTANCE != null) {
            throw new IllegalStateException("Instance already created!");
        }
    }

    // Bill Pugh Singleton Holder
    private static class SingletonHolder {
        private static final StrongBillPugh INSTANCE = new StrongBillPugh();
    }

  
    public static StrongBillPugh getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // Prevent cloning 
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed for singleton class");
    }

    // Prevent deserialization 
    protected Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}