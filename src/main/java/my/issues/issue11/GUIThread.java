package my.issues.issue11;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GUIThread {

    private JFrame mainFrame;
    private JButton startButton;
    private JTextArea output;

    public GUIThread() {
        mainFrame = new JFrame("MyThread");
        mainFrame.setSize(500, 250);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(3);

        output = new JTextArea("Output");
        output.setBounds(200, 50, 230, 100);

        startButton = new JButton("Start");
        startButton.setBounds(50, 50, 100, 50);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutorService executorService = Executors.newFixedThreadPool(3);

                //create list of 1,000,000 random numbers
                int numbers[] = new int[1000000];
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = (int) (Math.random() * 1000000);
                }

                //MIN
                executorService.submit(() -> {
                    double sum = 0;
                    for (int n : numbers) {
                        sum += n;
                    }
                    double min = sum / numbers.length;
                    output.setText(String.format("%s : MIN = %.2f%n", Thread.currentThread().getName(), min));
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
                    output.append(Thread.currentThread().getName() + " : MOD = " + element + "\n");
                });

                //MEDIAN
                executorService.submit(() -> {
                    Arrays.sort(numbers);
                    int oddMedian = numbers[numbers.length / 2];
                    double evenMedian = (numbers[numbers.length / 2] + numbers[(numbers.length / 2) - 1]) / 2;
                    if (numbers.length % 2 != 0) {
                        output.append(Thread.currentThread().getName() + ": MEDIAN = " + oddMedian);
                    } else {
                        output.append(String.format("%s : MEDIAN = %.2f%n", Thread.currentThread().getName(), evenMedian));
                    }
                });

                executorService.shutdown();

            }
        });

        mainFrame.add(output);
        mainFrame.add(startButton);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUIThread();
    }
}
