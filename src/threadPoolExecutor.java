import java.lang.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    Thread pool contains collection of worker threads and the collection of runnable objects
    that contains the task that needs be to executed

    Executors are capable of running asynchronous tasks
    Also we don't have to create threads manually
*/

public class threadPoolExecutor {

    public static final int nthreads = 3;

    public static void main(String[] args){

        // here a thread pool of fixed size i.e 3 is created.
        ExecutorService executor = Executors.newFixedThreadPool(nthreads);

        for(int i = 0; i < 3; i++){

            // only new runnable objects are created.
            Runnable r = new runnableThread(3);
            executor.execute(r);
        }

        executor.shutdown();

    }
}
