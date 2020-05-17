package my.issues.issue11;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GUIThread {

    private JFrame mainFrame;
    private JButton runButton;
    private Task task;

    public GUIThread() {
        mainFrame = new JFrame("MyThread");
        mainFrame.setSize(500, 250);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(3);

        runButton = new JButton("Run");
        runButton.setBounds(50, 50, 100, 50);
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task = new Task();
                task.start();

            }
        });

        mainFrame.add(runButton);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUIThread();
    }

    private class Task extends Thread {
        @Override
        public void run() {
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
            executorService.shutdown();
        }
    }
}
