
import java.lang.*;
import java.util.*;

// Runnable is a Task and thread is a worker

public class runnableThread implements Runnable {
     private final int value;

    runnableThread(int val){
        this.value = val;
    }

    @Override
    public void run() {
        int sum = 0;
        for(int i = 1; i < value; i++){
            sum += i;
        }
        System.out.println("Sum = "+sum +" Name of thread is "+Thread.currentThread().getName());
    }
}

class runThread{

    public static void main(String[] args){

        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i < 2; i++){

            Runnable task = new runnableThread(1); // here the runnable is a task that we defined in above class
            Thread worker = new Thread(task); // here thread is a worker which perform that task

            worker.setName(String.valueOf(i));

            // never call run() method directly
            /*
                if you call the run() directly then the code inside the run will execute on the current thread.
                So no new thread is created and then main thread is stuck performing the task
                Can call run()
             */

            // calling start() twice on a same thread object or it may throw an IllegalStateException
            worker.start();

            threads.add(worker); // keeping threads info in List
        }

        int running = 0;
        do{
            running = 0;
            for(Thread t : threads){
                if(t.isAlive()){
                    running++;
                }
            }
            System.out.println("We have "+running+" threads running");
        }while(running > 0);
    }
}
