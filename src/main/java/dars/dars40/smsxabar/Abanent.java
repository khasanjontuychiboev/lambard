package dars.dars40.smsxabar;

import java.util.concurrent.atomic.AtomicLong;

public class Abanent {
    private Integer id;
    private String name;

    public Abanent(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Abanent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
