package dslabs;


/**
 * This is the main class for our Lander game.
 *
 * @author Starter Code
 */
public class App {


    /*
    public static void main(String args[]) {
        var d3 = new Doll("pink", null);
        var d2 = new Doll("yellow", d3);
        var d1 = new Doll("red", d2);
        var d0 = new Doll("darkgreen", d1);
        var world0 = new DollWorld(d0);
        BigBang.start(world0, "Dolls");
    }
    */
   
    /* 
    public static void main(String args[]) {
        var xs = new IntList(1, new IntList(2, new IntList(3, null)));        

        var sum = 0;
        for (var ys = xs; ys != null; ys = ys.rest()) {
            sum += ys.item();
        }
        System.out.println("Sum = " + sum);

        sum = 0;
        while (xs != null) {
            sum += xs.item();
            xs = xs.rest();
        }
        System.out.println("Sum = " + sum);

    }
    */
    
    public static void main(String args[]) {
        var xs = new IntCell(1, new IntCell(2, new IntCell(3, new Empty())));        
    }
}

interface IntList {

}

record IntCell(int item, IntList rest) implements IntList{

}

record Empty() implements IntList {

}