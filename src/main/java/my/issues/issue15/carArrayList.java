package my.issues.issue15;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class carArrayList {
    static ArrayList carModel = new ArrayList();

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(new Task1());
        service.execute(new Task2());
        service.shutdown();

    }

    static class Task1 implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            carModel.add("Proton");
            carModel.add("Yamaha");
            carModel.add("Nissan");

            System.out.println(carModel);
        }
    }

    static class Task2 implements Runnable {
        @Override
        public void run() {

        }
    }
}
