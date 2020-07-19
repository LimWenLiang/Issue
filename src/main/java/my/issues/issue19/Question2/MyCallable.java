package my.issues.issue19.Question2;

import java.util.concurrent.FutureTask;

public class MyCallable {

    public void main() {

        for (int i = 1; i <= 3; i++) {
            FutureTask<Integer> futureTask = new FutureTask<>(new C_Multiplication(i));
            Thread thread = new Thread(futureTask);
            thread.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        new MyCallable().main();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        Thread.sleep(500);
        System.out.println("\nExecution Time: " + executionTime + " milliseconds");
    }

}
