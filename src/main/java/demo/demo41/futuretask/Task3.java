package demo.demo41.futuretask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

class Tavar{
    Turi turi;
    String nomi;

    public Tavar(Turi turi, String nomi) {
        this.turi = turi;
        this.nomi = nomi;
    }

    public Turi getTuri() {
        return turi;
    }

    public void setTuri(Turi turi) {
        this.turi = turi;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    @Override
    public String toString() {
        return "Tavar{" +
                "turi=" + turi +
                ", nomi='" + nomi + '\'' +
                '}';
    }
}

enum Turi{
    SUT,
    NON
}
public class Task3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Tavar> tavarList = new ArrayList<>();
        tavarList.add(new Tavar(Turi.SUT, "QAtiq"));
        tavarList.add(new Tavar(Turi.NON, "Bolichka"));
        tavarList.add(new Tavar(Turi.NON, "Non"));
        tavarList.add(new Tavar(Turi.SUT, "Tvarok"));

        FutureTask<List<Tavar>> futureTask = new FutureTask<>(()->{
            return tavarList.stream()
                    .filter(t -> t.getTuri()!=Turi.SUT)
                    .toList();
        });

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(futureTask);

        futureTask.get()
                .forEach(System.out::println);
        service.shutdown();


    }
}
