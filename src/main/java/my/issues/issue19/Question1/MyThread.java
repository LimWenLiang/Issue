package my.issues.issue19.Question1;

public class MyThread implements Runnable {

    static Multiplication multiplication;

    @Override
    public void run() {
        new Thread(() -> {
            int i = 1;
            for (int j = 1; j <= 3; j++) {
                multiplication = new Multiplication(i, j);
                int total = multiplication.calculate();
                System.out.println(Thread.currentThread().getName() + ": " + i + " * " + j + " = " + total);
            }
        }).start();

        new Thread(() -> {
            int i = 2;
            for (int j = 1; j <= 3; j++) {
                multiplication = new Multiplication(i, j);
                int total = multiplication.calculate();
                System.out.println(Thread.currentThread().getName() + ": " + i + " * " + j + " = " + total);
            }
        }).start();

        new Thread(() -> {
            int i = 3;
            for (int j = 1; j <= 3; j++) {
                multiplication = new Multiplication(i, j);
                int total = multiplication.calculate();
                System.out.println(Thread.currentThread().getName() + ": " + i + " * " + j + " = " + total);
            }
        }).start();
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
    }
}
