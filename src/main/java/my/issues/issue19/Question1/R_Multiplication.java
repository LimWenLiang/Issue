package my.issues.issue19.Question1;

public class R_Multiplication {

    private int num;

    public R_Multiplication(int num) {
        this.num = num;
    }

    public R_Multiplication() {

    }

    public void calculate() {

        int total = 0;
        for (int i = 1; i <= 3; i++) {
            total = num * i;
            System.out.println(Thread.currentThread().getName() + ": " + num + " * " + i + " = " + total);
        }
    }
}
