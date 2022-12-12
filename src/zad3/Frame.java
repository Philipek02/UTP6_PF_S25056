package zad3;

import javax.swing.*;
import java.awt.*;
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
        Task<?>[] tasks = {t1,t1,t1,t1,t1,t1};
        JList<Task<?>> list = new JList<>(tasks);
        list.setBackground(Color.BLUE);


        add(list);

        list.setBounds(150, 20, 100,200);


        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Task<Integer> task1 = new Task<>("task1");

    }

    public void addTask(String name){
        this.taskList.add(new Task<>(name));
    }
}
