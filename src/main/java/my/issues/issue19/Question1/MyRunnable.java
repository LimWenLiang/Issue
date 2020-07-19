package my.issues.issue19.Question1;

public class MyRunnable implements Runnable {

    static long executionTime = 0;

    @Override
    public void run() {

        new Thread(() -> {
            R_Multiplication RMultiplication = new R_Multiplication(1);
            RMultiplication.calculate();
        }).start();

        new Thread(() -> {
            R_Multiplication RMultiplication = new R_Multiplication(2);
            RMultiplication.calculate();
        }).start();

        new Thread(() -> {
            R_Multiplication RMultiplication = new R_Multiplication(3);
            RMultiplication.calculate();
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        new MyRunnable().run();

        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        Thread.sleep(500);
        System.out.println("\nExecution Time: " + executionTime + " milliseconds");
    }
}
