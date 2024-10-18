package hw05;

public class App {
    public static void main(String[] args) {
        var sounds = TreeMap.<String, String>empty();
        sounds = sounds.put("Cow", "Moo");
        System.out.println("size: " + sounds.size());

        sounds = sounds.put("Pig", "Oink");
        sounds = sounds.put("Chicken", "Cluck");
        sounds = sounds.put("Pig", "Hello");

        System.out.println("size: " + sounds.size());
        System.out.println("pig says: " + sounds.get("Pig"));
        System.out.println("cow says: " + sounds.get("Cow"));
    }
}