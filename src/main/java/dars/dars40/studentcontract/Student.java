package dars.dars40.studentcontract;

import java.util.concurrent.atomic.AtomicReference;

public class Student {
    private String name;
    private AtomicReference<Double> qarzdorlik;

    public Student(String name, AtomicReference<Double> qarzdorlik) {
        this.name = name;
        this.qarzdorlik = qarzdorlik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AtomicReference<Double> getQarzdorlik() {
        return qarzdorlik;
    }

    public void setQarzdorlik(AtomicReference<Double> qarzdorlik) {
        this.qarzdorlik = qarzdorlik;
    }

    public void qarzdorLikyoz(){
        qarzdorlik.updateAndGet(v -> v+200);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", qarzdorlik=" + qarzdorlik +
                '}';
    }
}
