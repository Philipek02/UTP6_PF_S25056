package zad1;

import java.util.ArrayList;


public class Letters extends ArrayList<Thread> {
    ArrayList<Thread> threads = new ArrayList<>();

    public Letters(String val){
        char[] chars = val.toCharArray();
        for (char ch:
             chars) {
            Thread thread = new Thread(){
                @Override
                public synchronized void run() {
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.print(this.getName().charAt(7));
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
            };
            thread.setName("Thread " + ch);
            this.threads.add(thread);
        }

    }

    public ArrayList<Thread> getThreads(){
        return this.threads;
    }



}
