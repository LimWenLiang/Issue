package my.issues.issue19.Question3;

import my.issues.issue19.Question1.MyRunnable;
import my.issues.issue19.Question2.MyCallable;

public class Comparison {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        MyCallable myCallable = new MyCallable();

        System.out.println("-------------Question 1-------------");
        myRunnable.main(args);
        System.out.println();
        System.out.println("-------------Question 2-------------");
        myCallable.main(args);
    }


}
