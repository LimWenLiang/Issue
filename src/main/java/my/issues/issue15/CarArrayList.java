package my.issues.issue15;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Counter {
    int count = 1;

    public synchronized void increment() {
        count++;
    }
}

public class CarArrayList {

    static Car car1 = new Car("PEE9776", "Proton", 2000);
    static Car car2 = new Car("PEB6056", "Honda", 2005);
    static Car car3 = new Car("PAC3042", "Toyota", 1998);
    static Car car4 = new Car("PEF3584", "Perdua", 2001);
    static Car car5 = new Car("PNG3884", "Yamaha", 2006);
    static Car car6 = new Car("PDL1742", "Nissan", 2010);
    static ArrayList<Car> carList = new ArrayList<>();
    static CarArrayList carArrayList = new CarArrayList();
    static Counter instruction = new Counter();

    public void print() {

        for (Car myCar : carList) {
            System.out.println(myCar);
        }

        System.out.println("");
    }

    /* Instruction
    1. Add 3 objects to an ArrayList
    2. Remove the last object
    3. Add new object
    4. Remove the 1st object
    5. Add a new object
    6. Add again a new object
    7. Remove the 2nd object
    */

    static class addCar implements Runnable {

        @Override
        public void run() {
            if (carList.size() == 0 && instruction.count == 1) {
                System.out.println("1. Add 3 objects to an ArrayList");
                carList.add(car1);
                carList.add(car2);
                carList.add(car3);
                carArrayList.print();
                instruction.increment();
            } else if (carList.size() == 2 && instruction.count == 3) {
                System.out.println("3. Add new object");
                carList.add(car4);
                carArrayList.print();
                instruction.increment();
            } else if (carList.size() == 2 && instruction.count == 5) {
                System.out.println("5. Add a new object");
                carList.add(car5);
                carArrayList.print();
                instruction.increment();
            } else if (carList.size() == 3 && instruction.count == 6) {
                System.out.println("6. Add again a new object");
                carList.add(car6);
                carArrayList.print();
                instruction.increment();
            }

        }
    }

    static class deleteCar implements Runnable {

        @Override
        public void run() {
            int lastIndex = carList.size() - 1;
            int firstIndex = 0;
            int secondIndex = 1;

            if (carList.size() == 3 && instruction.count == 2) {
                System.out.println("2. Remove the last object");
                carList.remove(lastIndex);
                carArrayList.print();
                instruction.increment();
            } else if (carList.size() == 3 && instruction.count == 4) {
                System.out.println("4. Remove the 1st object");
                carList.remove(firstIndex);
                carArrayList.print();
                instruction.increment();
            } else if (carList.size() == 4 && instruction.count == 7) {
                System.out.println("7. Remove the 2nd object");
                carList.remove(secondIndex);
                carArrayList.print();
                instruction.increment();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        service.scheduleWithFixedDelay(new addCar(), 0, 1, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new deleteCar(), 0, 1, TimeUnit.SECONDS);

        try {
            if (!service.awaitTermination(6, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }


    }
}
