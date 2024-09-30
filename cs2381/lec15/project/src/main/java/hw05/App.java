package hw05;

public class App {
    public static void main(String[] args) {
        var q = new ArrayQueue<Integer>();

        for (int ii = 0; ii < 5; ++ii) {
            q.push(ii);
        }
         
        for (int ii = 0; ii < 5; ++ii) {
            System.out.println(q.shift());
        }
    }

    public static void main1(String[] args) {
        var q = new ConsQueue<Integer>();

        for (int ii = 0; ii < 5; ++ii) {
            q.push(ii);
        }
            
        System.out.println(q.shift());
        
        for (int ii = 5; ii < 10; ++ii) {
            q.push(ii);
        }
        
        for (int ii = 0; ii < 9; ++ii) {
            System.out.println(q.shift());
        }
    }
}