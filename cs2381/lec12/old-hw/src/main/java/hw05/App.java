package hw05;

public class App {

    public static void main(String[] args) {
        var xs = ConsList.of("Alice", "Bob", "Carol", "Dave");
        for (var xx : xs) {
            System.out.println(xx);
        }
    }
}
