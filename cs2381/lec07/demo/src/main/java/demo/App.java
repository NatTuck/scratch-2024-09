package demo;

import java.util.ArrayList;

public class App {
    public static void main1(String[] args) {
        var foo = new Pair(7, 12);
        var bar = foo;

        int[] xs = {1, 2, 4};

        for (var x : xs) {
            //System.out.println(x);
        }

        //System.out.println(x[2]);

        xs[0] = 29;

        for (var x : xs) {
            System.out.println(x);
        }

        for (int ii = 0; ii < xs.length; ++ii) {
            System.out.println(xs[ii]);
        }
    }

    public static void main(String[] args) {
        var ys = new ArrayWrap();
        for (int ii = 0; ii < 20; ii += 2) {
            ys.add(ii);
        }
        for (int ii = 0; ii < ys.size; ++ii) {
            System.out.println(ys.get(ii));
        }
    }
}

record Pair(int aa, int bb) {

}
