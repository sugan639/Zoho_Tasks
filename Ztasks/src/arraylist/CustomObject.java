package arraylist;

public class CustomObject {
    private String value;

    public CustomObject(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomObject{" + "value='" + value + '\'' + '}';
    }
}