package dars.dars40.future;

import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    private String ismi;
    private AtomicInteger ball;

    public Student(String ismi, AtomicInteger ball) {
        this.ismi = ismi;
        this.ball = ball;
    }

    public String getIsmi() {
        return ismi;
    }

    public void setIsmi(String ismi) {
        this.ismi = ismi;
    }

    public AtomicInteger getBall() {
        return ball;
    }

    public void setBall(AtomicInteger ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ismi='" + ismi + '\'' +
                ", ball=" + ball +
                '}';
    }
}
