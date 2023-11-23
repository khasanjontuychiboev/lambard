package demo.demo41.futuretask;

import java.util.concurrent.*;

public class Example1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
           @Override
           public String call() throws Exception {
               return Thread.currentThread().getName();
           }
       });


        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(futureTask);


        try {
            System.out.println(futureTask.get(3,TimeUnit.SECONDS));

        }catch (Exception e){
            System.out.println("Qiymat qaytar olmadi");
        }

        service.shutdown();

    }
}
