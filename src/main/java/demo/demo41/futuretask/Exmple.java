package demo.demo41.futuretask;

import java.util.concurrent.*;

public class Exmple {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                //simulating long running task
                Thread.sleep(1000);
                System.out.println("returning");
                return "The result";
            }
        }
        );

        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(futureTask);
        String s = futureTask.get();
        System.out.println(s);
        es.shutdown();
    }
}
