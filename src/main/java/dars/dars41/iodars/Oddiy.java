package dars.dars41.iodars;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Xodim2 {
    private String name;
    private Integer age;
    private Double oyligi;

    public Xodim2(String name, Integer age, Double oyligi) {
        this.name = name;
        this.age = age;
        this.oyligi = oyligi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getOyligi() {
        return oyligi;
    }

    public void setOyligi(Double oyligi) {
        this.oyligi = oyligi;
    }

    @Override
    public String toString() {
        return "Xodim{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", oyligi=" + oyligi +
                '}';
    }
}
public class Oddiy {
    public static void main(String[] args) throws IOException {

        List<Xodim2> xodimList = new ArrayList<>();

        FileInputStream is = new FileInputStream("fayllar/xodimlar.txt");
        byte[] all = is.readAllBytes();

        String[] xodimlar = new String(all).split("\n");
        for (String s: xodimlar) {
            String[] arr = s.split(", ");
            xodimList.add(new Xodim2(arr[0],Integer.parseInt(arr[1]),Double.parseDouble(arr[2])));
        }

        FileOutputStream io = new FileOutputStream("fayllar/xodimlar.txt");

        xodimList.stream()
                .map(x ->{
                    if (x.getAge()>=30){
                        x.setOyligi(x.getOyligi()*1.1);
                    }
                    return x;
                })
                .forEach(x->{
                    String v = x.getName()
                            +", "
                            + x.getAge()
                            +", "
                            +x.getOyligi()
                            +"\n";
                    try {
                        io.write(v.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });



    }
}
