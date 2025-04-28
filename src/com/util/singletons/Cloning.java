package com.util.singletons;

class Address implements Cloneable {
    String city;

    Address(String city) {
        this.city = city;
    }

    // Shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // address reference is copied, not the object itself
    }

    // Deep copy
    protected Person deepClone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = (Address) address.clone(); // Clone the nested object too
        return cloned;
    }
}

public class Cloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Original object
        Address address = new Address("Coimbatore");
        Person personData = new Person("Sugan", address);

        
        // Shallow clone
        Person shallowCopy = (Person) personData.clone();

        // Deep clone
        Person deepCopy = personData.deepClone();

        // Modify original's address
        personData.address.city = "Chennai";

        // Output to demonstrate the effect
        System.out.println("Original   : " + personData.name + " from " + personData.address.city);
        System.out.println("ShallowCopy: " + shallowCopy.name + " from " + shallowCopy.address.city);
        System.out.println("DeepCopy   : " + deepCopy.name + " from " + deepCopy.address.city);
    }
}
