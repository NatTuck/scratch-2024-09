package demo;

import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {



    }

    // Design a new method that takes a list of integers and
    // adds one to each item in that list in place.

    /**
     * Add one to each item in list in place.
     *
     * @param  xs  The list of integers.
     */
    static void addOneToEach(List<Integer> xs) {
        for (int ii = 0; ii < xs.size(); ++ii) {
            xs.set(ii, 1 + xs.get(ii));
        }
        // Time to compute varies with length of input list.
        // Each additional item in the list adds a constant
        // number of operations to the method.
    }
    

    // Design a method that takes a list of integers and returns
    // a new list of numbers that are one greater than the input.

    /**
     * Add 1 to each item in list, returning new list.
     *
     * @param  xs  The input list.
     * @return     New list with items one greater.
     */
    static List<Integer> addOneToAll(List<Integer> xs) {
        var ys = new ArrayList<Integer>();
        for (var x : xs) {
            ys.add(x + 1);
        }
        return ys;
    }
       


    public static void main2(String[] args) {
        List<Integer> xs = new ArrayList<Integer>();

        xs.add(2);
        xs.add(3);
        xs.add(5);
        xs.add(7);

        xs.set(2, 35);

        for (var x : xs) {
            System.out.println("item is " + x);
        }
    }

    public static void main1(String[] args) {
        List<Integer> xs = List.of(1, 2, 3, 4);

        xs.isEmpty(); // => false
        xs.get(1); // => 2
        xs.size(); // => 4
        
        // Standard pattern for a list
        for (var x : xs) {
            System.out.println("item is " + x);
        }

        // Secondary pattern
        // for ii in range(xs.size())
        for (int ii = 0; ii < xs.size(); ++ii) {
            System.out.printf("item at index %d is %d\n", ii, xs.get(ii));
        }
    }
}
