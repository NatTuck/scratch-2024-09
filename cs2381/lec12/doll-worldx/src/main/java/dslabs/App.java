package dslabs;


/**
 * This is the main class for our Lander game.
 *
 * @author Starter Code
 */
public class App {
    public static void main(String args[]) {
        var xs = ConsList.of(1, 2, 3, 4);
        xs = addOneV2(xs);
        for (var it = xs; !it.isEmpty(); it = it.rest()) {
            System.out.println(it.first());
        }
    }

    static ConsList<Integer> addOneV1(ConsList<Integer> xs) {
        var ys = ConsList.<Integer>of();
        for (var it = xs; !it.isEmpty(); it = it.rest()) {
            ys = new ConsCell<>(it.first() + 1, ys); 
        }
        return ys;
    }

    static ConsList<Integer> addOneV2(ConsList<Integer> xs) {
        if (xs.isEmpty()) {
            return xs;
        }
        else {
            return new ConsCell<>(xs.first() + 1, addOneV2(xs.rest()));
        }
    }
}