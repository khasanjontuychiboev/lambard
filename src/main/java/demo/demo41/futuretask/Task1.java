package demo.demo41.futuretask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

class Oquvchi{
    private Integer Id;
    private String name;
    private Integer ball;

    public Oquvchi(Integer id, String name, Integer ball) {
        Id = id;
        this.name = name;
        this.ball = ball;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBall() {
        return ball;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        return "Oquvchi{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", ball=" + ball +
                '}';
    }
}
public class Task1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Oquvchi> oquvchis = new ArrayList<>();
        oquvchis.add(new Oquvchi(1, "Xasan",45));
        oquvchis.add(new Oquvchi(2, "Xusan",55));
        oquvchis.add(new Oquvchi(3, "zuhra",75));
        oquvchis.add(new Oquvchi(4, "Fotima",15));

        FutureTask<List<Oquvchi>> futureTask = new FutureTask<>(new Callable<List<Oquvchi>>() {
            @Override
            public List<Oquvchi> call() throws Exception {
                return oquvchis.stream()
                        .filter(o->o.getBall()>=50)
                        .collect(Collectors.toList());
            }
        });

        new Thread(futureTask).start();

        futureTask.get()
                .stream()
                .forEach(System.out::println);



    }
}
