package dars.dars40.future;

import java.util.Random;
import java.util.concurrent.*;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) throws Exception, InterruptedException, CancellationException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<?> future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Salom");
            }
        });

        Thread.sleep(1000);


        if (future.isDone()){
            System.out.println(future.get());
        }else {
            System.out.println("Qiymat yo'q");
        }

        executorService.shutdown();
    }
}
