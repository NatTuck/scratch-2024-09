package lab09;

import java.util.List;
import java.util.ArrayList;
import java.util.BitSet;

public class Sieve {

    static long countPrimes(long nn) {
        var xs = findPrimes(nn);
        return xs.size();
    }

    static long firstMultiple(long xx, long ii) {
        while (ii % xx != 0) {
            ii += 1;
        }
        return ii;
    }

    static List<Long> findPrimes(long nn) {
        long sq = (long)(1 + Math.sqrt(nn));
        var ps = simpleFindPrimes(sq);

        //System.out.println("First primes: " + ps);

        var table = new BitSet((int) nn);

        long bsz = (1000 * 1000);
        long blocks = (long) Math.ceil((double)nn / bsz);
        for (long bb = 0; bb < blocks; ++bb) {
            //System.out.println("Block #" + bb);
            for (var prime : ps) {
                var b0 = bb * bsz;
                var b1 = b0 + bsz;
                var jj = firstMultiple(prime, b0);
                while (jj < b1) {
                    //System.out.println("Marking " + jj);
                    table.set((int) jj, true);
                    jj += prime;
                }
            }
        }

        var ys = new ArrayList<Long>();
        for (long ii = 2; ii < nn; ++ii) {
            if (!table.get((int) ii)) {
                ys.add(ii);
            }
        }

        return ys;
    }

    static List<Long> simpleFindPrimes(long nn) {
        var table = new BitSet((int) nn);
        // values default to false, false means prime

        long sq = (long) (1 + Math.sqrt(nn));

        for (long ii = 2; ii < sq; ++ii) {
            if (!table.get((int) ii)) {
                // Scan for and mark multiples.
                long jj = ii + ii;
                while (jj < nn) {
                    table.set((int) jj, true);
                    jj += ii;
                }
            }
        }

        var ys = new ArrayList<Long>();
        for (long ii = 2; ii < nn; ++ii) {
            if (!table.get((int) ii)) {
                ys.add(ii);
            }
        }

        return ys;
    }
}
