package lab09;


public class App {
    static Account alice = new Account("Alice");
    static Account bob = new Account("Bob");

    public static void main(String[] args) throws InterruptedException {
        var ta = new ThreadA();
        ta.start();

        var tb = new ThreadB();
        tb.start();

        ta.join();
        tb.join();

        System.out.println("all done");
    }
}

class Account {
    String name;
    int balance;

    Account(String name) {
        this.name = name;
        this.balance = 100;
    }

    synchronized void transferTo(Account that, int amt) throws Exception {
        if (balance < amt) {
            return;
        }

        System.out.println("Transferring $" + amt + " from " + this.name 
            + " to " +  that.name);

        this.balance -= amt;

        Thread.sleep(1000);

        synchronized (that) {
            that.balance += amt;
        }
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            App.alice.transferTo(App.bob, 5);
        }
        catch (Exception ee) {
            // pass
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            App.bob.transferTo(App.alice, 5);
        }
        catch (Exception ee) {
            // pass
        }
    }
}



class App1 {
    static long ABIL = 1000 * 1000 * 1000;

    static long sum = 0;
    static Object lock = new Object();
    
    public static void main(String[] args) {
        long t0 = System.nanoTime();
        main1(null);
        long t1 = System.nanoTime();
        long ms = ((t1 - t0) / (1000 * 1000));
        System.out.println("Program took " + ms + " ms.");
    }

    public static void main1(String[] args) {
        var threads = new Thread[10];
        var workers = new Worker[10];
        for (int ww = 0; ww < 10; ++ww) {
            workers[ww] = new Worker(ww);
            threads[ww] = new Thread(workers[ww]);
            threads[ww].start();
        }

        //long total_sum = 0;
        
        for (int ww = 0; ww < 10; ++ww) {
            try {
                threads[ww].join();
                //total_sum += workers[ww].sum;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //System.out.println(total_sum);
        System.out.println(sum);
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
                synchronized (App1.lock) {
                    App1.sum += ii;
                }
            }
        }
    }

}