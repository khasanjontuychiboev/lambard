package dars.dars41.futuretask;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class Example {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf =
                CompletableFuture.runAsync(() -> {
                    System.out.println("running, in thread: " + Thread.currentThread().getName());
                });
        cf.join();//waits until task is completed
        System.out.println("main exiting, thread: "+Thread.currentThread().getName());
    }
}
