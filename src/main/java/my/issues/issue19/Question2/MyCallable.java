package my.issues.issue19.Question2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCallable {

    public static int calculate(int[] num1) throws ExecutionException, InterruptedException {
        int total = 0;
        if (num1.length == 1) return num1[0];
        else if (num1.length == 0) throw new IllegalArgumentException();

        for (int j = 1; j <= 3; j++) {

        }

        ExecutorService service = Executors.newFixedThreadPool(3);


        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName());
        }

        return total;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};

        try {
            System.out.println(MyCallable.calculate(a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
