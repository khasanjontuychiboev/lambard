package demo.demo40;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExmpleThreaExecutorPoll {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        for (int i=0; i<10; i++){
            int finalI = i;
            arrayBlockingQueue.offer(()->{
                System.out.println(Thread.currentThread().getName()+" called "+ finalI);
            });
        }
        ThreadPoolExecutor threadPoolExecutor  = new ThreadPoolExecutor(
                5,
                10,
                5,
                TimeUnit.SECONDS,
                arrayBlockingQueue
        );

        threadPoolExecutor.prestartCoreThread();

        threadPoolExecutor.shutdown();

    }
}
