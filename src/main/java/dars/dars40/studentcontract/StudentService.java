package dars.dars40.studentcontract;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class StudentService {
    public static void main(String[] args) throws InterruptedException {
        Student student = new Student("Xasan", new AtomicReference<>(100D));

        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);

        service.scheduleAtFixedRate(()->{
            student.qarzdorLikyoz();
        },1,1, TimeUnit.SECONDS);

        Thread.sleep(15_000);
        service.shutdown();

        System.out.println(student);
    }
}
