package dars.dars40.felixble;

import dars.dars40.smsxabar.SmsXizmat;

import java.util.concurrent.*;

public class Example {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> tasks = new ArrayBlockingQueue<>(10);

        for (int i=0;i<10; i++){
            int finalI = i;
            if (i==0){
                tasks.offer(()->{
                    System.out.println(finalI +" birinchi nimadir chiqarish by "+Thread.currentThread().getName());
                });
            } else if (i==1) {
                tasks.offer(()->{
                    System.out.println(finalI +" Boshqa nimadir chiqarish by "+Thread.currentThread().getName());
                });
            }
            else {
                tasks.offer(()->{
                    System.out.println(finalI +" Sout nimadir chiqarish by "+Thread.currentThread().getName());
                });
            }

        }

        ThreadPoolExecutor service = new ThreadPoolExecutor(
                5,
                10,
                1,
                TimeUnit.SECONDS,
                tasks
        );

        service.prestartCoreThread();



    }
}
