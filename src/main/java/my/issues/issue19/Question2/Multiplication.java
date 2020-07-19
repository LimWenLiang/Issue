package my.issues.issue19.Question2;

import java.util.concurrent.Callable;

public class Multiplication implements Callable<Integer> {

    private int num1[];
    private int num2;
    private int start;
    private int end;

    public Multiplication(int[] num1, int num2, int start, int end) {
        this.num1 = num1;
        this.num2 = num2;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {

        int total = 0;

        for (int i = start; i < end; i++) {
            total = num1[i] * num2;
        }
        return total;
    }
}
