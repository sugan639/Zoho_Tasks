package test;
import birds.*;


public class TestRunner {
    public static void main(String[] args) {
        Bird b = new Bird();
        Parrot p = new Parrot();
        b.fly();
        p.fly();
        p.speak();
    }
}
