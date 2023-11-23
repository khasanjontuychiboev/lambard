package demo.demo41.futuretask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

class Xodim{
    private String ismi;
    private Integer yoshi;
    private Double oyligi;

    public Xodim(String ismi, Integer yoshi, Double oyligi) {
        this.ismi = ismi;
        this.yoshi = yoshi;
        this.oyligi = oyligi;
    }

    public String getIsmi() {
        return ismi;
    }

    public void setIsmi(String ismi) {
        this.ismi = ismi;
    }

    public Integer getYoshi() {
        return yoshi;
    }

    public void setYoshi(Integer yoshi) {
        this.yoshi = yoshi;
    }

    public Double getOyligi() {
        return oyligi;
    }

    public void setOyligi(Double oyligi) {
        this.oyligi = oyligi;
    }
}
public class Task2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Xodim> xodimList = new ArrayList<>();
        xodimList.add(new Xodim("xasan", 35, 100D));
        xodimList.add(new Xodim("xusan", 25, 100D));
        xodimList.add(new Xodim("zuhra", 15, 100D));
        xodimList.add(new Xodim("fotima", 75, 100D));
        xodimList.add(new Xodim("akmmal", 45, 100D));

        FutureTask<Double> futureTask = new FutureTask<>(()->{
            return xodimList.stream()
                    .mapToDouble(x -> {
                        if (x.getYoshi()>=30){
                            x.setOyligi(x.getOyligi()*1.2);
                        }
                        return x.getOyligi();
                    })
                    .average()
                    .orElse(0.0d);
        });

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(futureTask);

        System.out.println(futureTask.get());
        executorService.shutdown();
    }
}
