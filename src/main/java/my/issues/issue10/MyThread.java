package my.issues.issue10;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //create list of 1,000,000 random numbers
        int numbers[] = new int[1000000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 1000000);
        }
        System.out.println("Main Thread: " + Thread.currentThread().getName());

        //MIN
        executorService.submit(() -> {
            double sum = 0;
            for (int n : numbers) {
                sum += n;
            }
            double min = sum / numbers.length;
            System.out.printf("%s: MIN = %.2f%n", Thread.currentThread().getName(), min);
        });

        //MOD
        executorService.submit(() -> {
            int element = 0;
            int count = 0;
            for (int i = 0; i < numbers.length; i++) {
                int tempElement = numbers[i];
                int tempCount = 0;
                for (int j = 0; j < numbers.length; j++) {
                    tempCount++;
                }
                if (tempCount > count) {
                    element = tempElement;
                }
            }
            System.out.println(Thread.currentThread().getName() + ": MOD = " + element);
        });

        //MEDIAN
        executorService.submit(() -> {
            Arrays.sort(numbers);
            int oddMedian = numbers[numbers.length / 2];
            double evenMedian = (numbers[numbers.length / 2] + numbers[(numbers.length / 2) - 1]) / 2;
            if (numbers.length % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": MEDIAN = " + oddMedian);
            } else {
                System.out.printf("%s: MEDIAN = %.2f%n", Thread.currentThread().getName(), evenMedian);
            }
        });

        executorService.shutdown();


    }

}

