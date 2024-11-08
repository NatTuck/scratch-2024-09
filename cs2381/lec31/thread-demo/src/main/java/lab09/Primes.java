package lab09;

import java.util.ArrayList;
import java.util.List;

public class Primes {

    /**
     * How many prime numbers less than nn.
     */
    static long countPrimes(long nn) {
        var xs = findPrimes(nn);
        return xs.size();
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
        for (var ii : primes) {
            if (xx % ii == 0) {
                return false;
            }
        }
        return true;
    }
}
