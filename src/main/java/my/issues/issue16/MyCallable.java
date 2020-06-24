package my.issues.issue16;

import java.util.concurrent.*;

public class MyCallable implements Callable<Integer> {

    public static void main(String[] args) {

        Callable<Integer> myCallable = new MyCallable();
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> future = service.submit(myCallable);
        try {
            Integer max = future.get();
            System.out.println("Maximum Number: " + max);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Failed");
        }

        service.shutdown();
    }

    @Override
    public Integer call() throws Exception {
        int number[] = new int[100];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 10; i++) {
            number[i] = ThreadLocalRandom.current().nextInt(100);
            System.out.println("Number " + (i + 1) + ": " + number[i]);

            if (number[i] > max) {
                max = number[i];
            }
        }

        return max;
    }
}
