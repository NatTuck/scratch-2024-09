package dslabs;


/**
 * This is the main class for our Lander game.
 *
 * @author Starter Code
 */
public class App {
    public static void main(String args[]) {
        ConsList<String> xs = new ConsCell<String>("hello", new ConsCell<String>("list", new ConsEmpty<String>()));
        System.out.println("second item: " + xs.rest().first());
    }

    public static void main1(String args[]) {
        IntList xs = new IntCell(1, new IntCell(2, new IntCell(3, new Empty())));        
        System.out.println("static sum = " + sumList(xs));
        System.out.println("instance sum = " + xs.sum());
    }

    static int sumList(IntList xs) {
        if (xs.isEmpty()) {
            return 0;
        }
        else {
            return xs.first() + sumList(xs.rest());
        }
    }

    static void xx() {
        // no go, int parameter
        //var p1 = new Pair<int, int>(35, 7);

        var p1 = new Pair<Integer, Integer>(35, 7);

    }
}

record IntPair(int left, int right) {

}

record StringPair(String left, String right) {

}

record Pair<L,R>(L left, R right) {

}


interface IntList {
    boolean isEmpty();
    int length();
    int first();
    IntList rest();
    int sum();
}

record IntCell(int first, IntList rest) implements IntList{
    // record auto-generates first() accessor method.
    // record auto-generates rest() accessor method.

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int length() {
        return 1 + rest.length();
    }

    @Override
    public int sum() {
        return this.first() + this.rest().sum();
    }

}

record Empty() implements IntList {

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public int first() {
        throw new UnsupportedOperationException("empty list");
    }

    @Override
    public IntList rest() {
        throw new UnsupportedOperationException("empty list");
    }

    @Override
    public int sum() {
        return 0;
    }

}