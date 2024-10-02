package hw05;

public class App {
    public static void main(String[] args) {
        var dq = new FixedDeque<Integer>(8);
        for (int ii = 0; ii < 5; ++ii) {
            dq.push(ii);
        }
        
        for (int ii = 0; ii < 5; ++ii) {
            System.out.println(dq.shift());
        }
        
        for (int ii = 0; ii < 5; ++ii) {
            dq.push(ii);
        }
        
        for (int ii = 0; ii < 5; ++ii) {
            System.out.println(dq.shift());
        }
    }
}