package dars.dars40;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExmplpeSchualed {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        service.scheduleAtFixedRate(()->{
            System.out.println("Dars boshlandi!");
        },3,2, TimeUnit.SECONDS);





    }
}
