package my.issues.issue18;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Bus implements Runnable {

    private int duration;
    private int id;
    private CyclicBarrier cyclicBarrier;

    public Bus(int duration, int id, CyclicBarrier cyclicBarrier) {
        this.duration = duration;
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ": Bus " + id + " is ready.");
            Thread.sleep(duration);

            cyclicBarrier.await();

            System.out.println(Thread.currentThread().getName() + ": Bus " + id + " were arrived.");

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class MyCyclicBarriers {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("\nFour buses were departed.\n");
                    }
                });

        for (int i = 0; i < 4; i++) {
            service.execute(new Bus(1000, i + 1, cyclicBarrier));
        }
        service.shutdown();
    }
}
