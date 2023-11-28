package dars.dars45;

public class Xodim {
    private String name;
    private Double salary;

    public Xodim(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Xodim{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
