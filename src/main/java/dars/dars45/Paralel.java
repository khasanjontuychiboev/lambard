package dars.dars45;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Paralel {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("fayllar/paralle.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fayllar/paralle2.txt"))
        ) {
            List<Xodim> xodimList = new ArrayList<>();
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] dataArr =  line.split(" ");
                xodimList.add(new Xodim(dataArr[0],Double.parseDouble(dataArr[1])));
            }

            xodimList.stream()
                    .map(x->{
                        if (x.getSalary()>=300){
                            x.setSalary(x.getSalary()*0.9);
                        }
                        System.out.println(Thread.currentThread().getName());
                        return x;
                    })
                    .forEach(System.out::println);

        }catch (Exception e){
            System.out.println("Xatolik");
        }
    }
}
