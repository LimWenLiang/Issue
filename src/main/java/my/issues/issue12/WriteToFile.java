package my.issues.issue12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WriteToFile {
    public static void main(String[] args) {
        File file = new File("MyNumber.txt");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        int numbers[] = new int[1000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
            if (numbers[i] % 2 == 0) {
                System.out.println("Number " + (i + 1) + ": " + numbers[i]);
            } else {
                System.out.println("Number " + (i + 1) + ": " + numbers[i] + "(odd number)");
            }
        }

        executorService.execute(() -> {
            try {
                FileWriter fileWriter = new FileWriter(file);

                fileWriter.write("Below show odd numbers from 1,000 random numbers: \n");
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] % 2 != 0) {
                        fileWriter.write(numbers[i] + "\n");
                    }
                }
                fileWriter.write("Odd number done created.");

                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            executorService.shutdown();
            System.out.println("Finished");
        });
    }
}


