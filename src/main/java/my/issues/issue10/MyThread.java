package my.issues.issue10;

import java.util.Arrays;

public class MyThread {
    public static void main(String[] args) {
        int numbers[] = new int[1000000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * numbers.length);
        }

        //MIN
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        System.out.println("MIN = " + ((double) sum / numbers.length));

        //MEDIAN
        Arrays.sort(numbers);
        int oddMedian = numbers[numbers.length / 2];
        double evenMedian = (numbers[numbers.length / 2] + numbers[numbers.length / 2 - 1]) / 2;
        if (numbers.length % 2 != 0) {
            System.out.println("MEDIAN = " + oddMedian);
        } else {
            System.out.printf("MEDIAN = %.2f%n" + evenMedian);
        }
    }

}

