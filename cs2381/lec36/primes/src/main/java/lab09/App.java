package lab09;

// sequential time: 3.56 seconds
// parallel time: 3.05 seconds
// non-shared parallel time: ~2 seconds

public class App {
    public static void main(String[] args) {
        long t0 = System.nanoTime();
        long yy = Primes.countPrimes(1000 * 1000);
        long t1 = System.nanoTime();
        long ms = ((t1 - t0) / (1000 * 1000));
        System.out.println("Found " + yy + " primes in " + ms + " ms.");
        //System.out.println(Primes.findPrimes(100));
    }
}


class App1 {
    static long ABIL = 1000 * 1000 * 1000;

    public static void main(String[] args) {
        var threads = new Thread[10];
        var workers = new Worker[10];
        for (int ww = 0; ww < 10; ++ww) {
            workers[ww] = new Worker(ww);
            threads[ww] = new Thread(workers[ww]);
            threads[ww].start();
        }

        long total_sum = 0;
        
        for (int ww = 0; ww < 10; ++ww) {
            try {
                threads[ww].join();
                total_sum += workers[ww].sum;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println(total_sum);
    }
}

class Worker implements Runnable {
    static long NPT = 100 * 1000 * 1000;
    long i0; 
    public long sum;

    Worker(long worker_id) {
        this.i0 = worker_id * NPT;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (long ii = i0; ii < (i0 + NPT); ++ii) {
            if (ii % 101 == 0) {
                this.sum += ii;
            }
        }
    }

}