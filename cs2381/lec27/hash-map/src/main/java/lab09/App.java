package lab09;

//import java.util.ArrayList;

public class App {
    public static void main0(String[] args) {
        System.out.println("" + (10 % 4));
        System.out.println("" + (-10 % 4));
        System.out.println("" + Math.floorMod(-10, 4));
    }

    public static void main(String[] args) {
        var sounds = new HashMap<String, String>();
        sounds.insert("cow", "moo");
        sounds.insert("dog", "bark");
        sounds.insert("sheep", "baa");
        sounds.insert("chicken", "bacaw");
        
        System.out.println("size " + sounds.size());
        System.out.println("chicken says " + sounds.get("chicken"));
        System.out.println("keys " + sounds.keys());
        
        sounds.delete("sheep");
        System.out.println("keys " + sounds.keys());
        
        System.out.println("chicken says " + sounds.get("chicken"));
    }
}
