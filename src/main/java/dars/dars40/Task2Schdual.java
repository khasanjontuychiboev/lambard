package dars.dars40;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task2Schdual {
    public static void main(String[] args) throws InterruptedException {
        MaxsulotService maxsulotService = new MaxsulotService();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        service.scheduleAtFixedRate(()->{
            maxsulotService.schuledDecrease();
        },1,1, TimeUnit.SECONDS);

        Thread.sleep(10_000);
        service.shutdown();
        System.out.println("Natija: ");
        maxsulotService.getMaxsulotlar().stream().forEach(System.out::println);

    }
}
