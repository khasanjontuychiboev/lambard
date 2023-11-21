package demo.demo40;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class KvartiraTolov{
    private AtomicReference<Double> qarzdorlik = new AtomicReference<>(0.D);

    public void qarzdorliklikYozmoq(){
            qarzdorlik.updateAndGet(v->{
                System.out.printf("\nQarzdorlik %s shuncha bo'ldi",v+100);
                return v+100;
            });
    }

}
public class ScheduledThreadPoolExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a ScheduledThreadPoolExecutor with 3 threads
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        KvartiraTolov kvartiraTolov = new KvartiraTolov();
        // ... Perform task scheduling and execution
        executorService.scheduleAtFixedRate(() -> {
            kvartiraTolov.qarzdorliklikYozmoq();
        }, 3,30, TimeUnit.SECONDS);

        Thread.sleep((30*12+4)*1000);
        executorService.shutdown();
    }
}