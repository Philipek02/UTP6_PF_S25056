/**
 *
 *  @author Pańczak Filip S25056
 *
 */

package zad3;


import javax.swing.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    JList<Future<?>> list = new JList<>();


    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<?> returnedValues = executorService.submit(new Runnable() {
      @Override
      public void run() {
        System.out.println("pozdro");

        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    System.out.println("Result of Future object:: " + returnedValues.get());
    System.out.println("pause:: " + returnedValues.isDone());
    executorService.shutdown();


  }
}



























