package lab09;

// sequential time: 3.56 seconds
// parallel time: 3.05 seconds
// non-shared parallel time: ~2 seconds

public class App {
    public static void main(String[] args) {
        long t0 = System.nanoTime();
        long yy = Primes.countPrimes(40 * 1000 * 1000);
        long t1 = System.nanoTime();
        long ms = ((t1 - t0) / (1000 * 1000));
        System.out.println("Found " + yy + " primes in " + ms + " ms.");
        //System.out.println(Primes.findPrimes(100));
    }
}