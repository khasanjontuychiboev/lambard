package dars.dars40.future;


import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

class StudentService{
    private CopyOnWriteArrayList<Student> students;

    public StudentService() {
        students = new CopyOnWriteArrayList<>();
        students.add(new Student("Xasan", new AtomicInteger(0)));
        students.add(new Student("Xusan", new AtomicInteger(0)));
        students.add(new Student("Zuhra", new AtomicInteger(0)));
        students.add(new Student("Fotima", new AtomicInteger(0)));
        students.add(new Student("Ali", new AtomicInteger(0)));
    }

    public CopyOnWriteArrayList<Student> ballQoy(){
        return students.stream()
                .map(v ->{
                    v.setBall(new AtomicInteger(new Random().nextInt(2,5)));
                    return v;
                }).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }

}
public class Task1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        StudentService obj = new StudentService();
        Future<CopyOnWriteArrayList<Student>> st = service.submit(obj::ballQoy);
        System.out.println(st.get());


    }
}
