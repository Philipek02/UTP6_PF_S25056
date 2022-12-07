package zad2;

public class StringTask implements Runnable{
    String napis;
    int liczba;
    String finalString="";
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
            napis2 = napis2+napis;
        }
        this.finalString = napis2;
        this.stan = TaskState.READY;

    }
    public void start(){

        this.stan = TaskState.RUNNING;
        this.run();
        if (!Thread.currentThread().isInterrupted()) {
            this.stan = TaskState.READY;
        }else {
            this.stan = TaskState.ABORTED;
        }
    }
    public boolean isDone(){
        if (stan == TaskState.ABORTED){
            return false;
        }
        return true;
    }

    public TaskState getState() {
        return stan;
    }
    public String getResult(){
        return this.finalString;
    }
    public void abort(){
        this.stan = TaskState.ABORTED;
        Thread.currentThread().interrupt();

    }
}
