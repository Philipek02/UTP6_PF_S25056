package zad2;

public class StringTask implements Runnable{

    public enum TaskState {
        CREATED,
        RUNNING,
        ABORTED,
        READY,
    }
    Thread t1;
    String napis;
    volatile int liczba;
    volatile String finalString="";
    TaskState stan;

    public StringTask(String napis, int liczba){
        this.napis = napis;
        this.liczba = liczba;
        this.stan = TaskState.CREATED;
    }
    
    @Override
    public void run() {
        int liczbaPom = liczba;
        String napis2 = this.napis;
        for (int i = 0; i< liczbaPom-1; i++){
            if(Thread.currentThread().isInterrupted())return;
            napis2 = napis2+napis;
            this.finalString = napis2;
        }

        this.stan = TaskState.READY;
    }
    public void start(){
        this.stan = TaskState.RUNNING;
        t1 = new Thread(this);
        t1.start();
    }
    public boolean isDone(){
        return stan == TaskState.READY || stan == TaskState.ABORTED;
    }

    public TaskState getState() {
        return stan;
    }
    public String getResult(){
        return this.finalString;
    }

    public void abort(){
        this.stan = TaskState.ABORTED;
        t1.interrupt();

    }
}




