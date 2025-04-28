package com.uil.filemanager;

public class DataContainer {
    private String str;
    private int num;

    // Default Constructor
    public DataContainer() {}

    // Parameterized Constructor
    public DataContainer(String str, int num) {
        this.str = str;
        this.num = num;
    }

    // Getters and Setters
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "String: " + str + ", Integer: " + num;
    }
}