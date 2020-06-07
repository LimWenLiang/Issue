package my.issues.issue13;

class Counter {

    int count;

    public synchronized void increment() {
        count += 2;
    }
}

public class SyncDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    counter.increment();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    counter.increment();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    counter.increment();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Count: " + counter.count);


    }
}
