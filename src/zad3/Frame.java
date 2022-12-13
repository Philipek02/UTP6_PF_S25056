package zad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Frame extends JFrame {
    List<Task<?>> taskList = new ArrayList<>();
    Frame(){
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(400,300));
        setVisible(true);
        setResizable(false);
        Task<?> t1 = new Task<>("task1");
        Task<?> t2 = new Task<>("task2");
        Task<?> t3 = new Task<>("task3");
        Task<?> t4 = new Task<>("task4");
        Task<?> t5 = new Task<>("task5");

        Task<?>[] tasks = {t1,t2,t3,t4,t5};
        JList<Task<?>> list = new JList<>(tasks);
        list.setBackground(Color.BLUE);
        t1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("pozdro");
                t1.cancel(true);

            }
        });

        add(list);

        list.setBounds(150, 20, 100,200);


        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Task<Integer> task1 = new Task<>("task1");

    }

    public void addTask(String name){
        this.taskList.add(new Task<>(name));
    }
}
