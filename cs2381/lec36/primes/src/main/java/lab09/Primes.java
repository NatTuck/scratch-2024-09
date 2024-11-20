package lab09;

import java.util.ArrayList;
import java.util.List;

public class Primes {

    /**
     * How many prime numbers less than nn.
     */
    static long countPrimes(long nn) {
        //var xs = findPrimes(nn);
        var xs = parFindPrimes(nn);
        return xs.size();
    }

    static List<Long> parFindPrimes(long nn) {
        long sn = Math.round(Math.sqrt(nn) + 1);
        var ps = findPrimes(sn);

        var workers = new Worker[10];
        for (int ww = 0; ww < 10; ++ww) {
            long i0 = ww * (nn / 10);
            long i1 = i0 + (nn / 10);

            workers[ww] = new Worker(ps, i0, i1);
            workers[ww].start();
        }

        var ys = new ArrayList<Long>();
        for (int ww = 0; ww < 10; ++ww) {
            try {
                workers[ww].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ys.addAll(workers[ww].data);
        }
        return ys;
    }

    /**
     * Find all prime numbers less than nn.
     * 
     */
    // Complexity: O(n^2)
    static List<Long> findPrimes(long nn) {
        var ys = new ArrayList<Long>();
        ys.add(2L);
        ys.add(3L);
        ys.add(5L); 

        for (long ii = 7; ii < nn; ii += 2) {
            if (isPrime(ii, ys)) {
                ys.add(ii);    
            }
        }
        return ys;
    }

    // Complexity: O(n)
    static boolean isPrime(long xx, List<Long> primes) {
        double sr = Math.sqrt(xx);

        for (var ii : primes) {
            if (ii > sr) {
                break;
            }
            if (xx % ii == 0) {
                return false;
            }
        }
        return true;
    }
}

class Worker extends Thread {
    public ArrayList<Long> data = new ArrayList<Long>();
    List<Long> primes;
    long i0;
    long i1;

    Worker(List<Long> primes, long i0, long i1) {
        if (i0 < 3) {
            data.add(2L);
            i0 = 3;
        }

        if (i0 % 2 == 0) {
            i0 += 1;
        }

        this.primes = primes;
        this.i0 = i0;
        this.i1 = i1;
    }
    
    @Override
    public void run() {
        // search numbers from i0 to i1
        // add any primes to data
        for (var ii = i0; ii < i1; ii += 2) {
            if (Primes.isPrime(ii, primes)) {
                data.add(ii);
            }
        }
    }
}