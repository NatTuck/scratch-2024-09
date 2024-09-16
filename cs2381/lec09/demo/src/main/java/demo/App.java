package demo;


public class App {
    public static void main(String[] args) {

        ArrayList<String> xs = new ArrayList<String>();
        xs.add("dog");
        xs.add("cat");
        xs.add("cow");

        for (int ii = 0; ii < xs.size(); ++ii) {
            String xx = xs.get(ii);
            xs.set(ii, xx + "s");
        }

        // print each item to confirm plural
        for (var xx : xs) {
            System.out.println("plural: " + xx);
        }

    }
}

