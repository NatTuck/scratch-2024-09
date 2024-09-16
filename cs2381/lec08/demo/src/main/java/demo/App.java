package demo;

public class App {
    public static void main(String[] args) {
        var xs = new ArrayWrap();
        var ys = new ArrayList();

        for (int ii = 0; ii < 1000; ii++) {
            xs.add(ii);
            ys.add(ii);
        }

        for (int ii = 0; ii < ys.size(); ++ii) {
            System.out.println(ys.get(ii));
        }

        System.out.println("ArrayWrap ops: " + xs.ops);
        System.out.println("ArrayList ops: " + ys.ops);
    }
}

