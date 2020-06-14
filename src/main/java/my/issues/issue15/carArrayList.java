package my.issues.issue15;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class carArrayList {
    static ArrayList car = new ArrayList();

    static class Add implements Runnable {
        @Override
        public void run() {

            // 1. Add 3 objects to an ArrayList
            car.add("Proton");
            car.add("Perdua");
            car.add("Yamaha");
            System.out.println("1. " + car);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 3. Add new object
            car.add("Honda");
            System.out.println("3. " + car);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 5. Add a new object
            car.add("Nissan");
            System.out.println("5. " + car);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 6. Add again a new object
            car.add("Toyota");
            System.out.println("6. " + car);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Delete implements Runnable {
        @Override
        public void run() {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 2. Remove the last object
            car.remove(2);
            System.out.println("2. " + car);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 4. Remove the 1st object
            car.remove(0);
            System.out.println("4. " + car);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 7. Remove the 2nd object
            car.remove(1);
            System.out.println("7. " + car);
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Add());
        service.execute(new Delete());

        service.shutdown();
    }


}
