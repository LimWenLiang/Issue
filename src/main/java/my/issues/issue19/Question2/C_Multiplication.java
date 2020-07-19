package my.issues.issue19.Question2;

import java.util.concurrent.Callable;

public class C_Multiplication implements Callable<Integer> {

    private int num;

    public C_Multiplication(int num) {
        this.num = num;
    }

    public C_Multiplication() {

    }

    @Override
    public Integer call() throws Exception {

        int total = 0;
        for (int i = 1; i <= 3; i++) {
            total = num * i;
            System.out.println(Thread.currentThread().getName() + ": " + num + " * " + i + " = " + total);
        }
        return null;
    }
}
