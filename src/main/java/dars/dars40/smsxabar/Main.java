package dars.dars40.smsxabar;

import demo.demo40.ScheduledThreadPoolExecutorExample;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SmsXizmat smsXizmat = new SmsXizmat();

       ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

       executor.scheduleAtFixedRate(()->{
           smsXizmat.smsYubor();
       },1,1, TimeUnit.SECONDS);

       Thread.sleep(10_000);
       executor.shutdown();

    }
}
