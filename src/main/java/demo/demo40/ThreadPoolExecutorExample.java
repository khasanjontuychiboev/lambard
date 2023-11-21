package demo.demo40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class Student{
    private String ism;
    private Integer ball;

    public Student(String ism, Integer ball) {
        this.ism = ism;
        this.ball = ball;
    }

    public String getIsm() {
        return ism;
    }

    public void setIsm(String ism) {
        this.ism = ism;
    }

    public Integer getBall() {
        return ball;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }
}
class StudentBalls{
    private final AtomicReference<CopyOnWriteArrayList<Student>> students;

    public StudentBalls() {
        CopyOnWriteArrayList<Student> staticStudents = new CopyOnWriteArrayList<>();
        staticStudents.add(new Student("Xasan",0));
        staticStudents.add(new Student("Xusan",0));
        staticStudents.add(new Student("Zuhra",0));
        staticStudents.add(new Student("Fotima",0));
        students  = new AtomicReference<>(staticStudents);
    }

    public CopyOnWriteArrayList<Student> doBall(){
        return students.updateAndGet(s -> {
            for (Student student:s) {
                student.setBall(new Random().nextInt(2, 5));
            }
            return s;
        });
    }
}
public class ThreadPoolExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       ExecutorService executorService = Executors.newFixedThreadPool(5);
       StudentBalls studentBalls = new StudentBalls();
       Future<CopyOnWriteArrayList<Student>> future = executorService.submit(studentBalls::doBall);

        for (Student student: future.get()) {
            System.out.println(student.getIsm()+": "+ student.getBall());
        }
        
        executorService.shutdown();

    }
}