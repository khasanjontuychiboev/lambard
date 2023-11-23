package dars.dars41.iodars;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Yangilik{
    private String sarlovha;
    private String avtor;
    private String content;

    public Yangilik(String sarlovha, String avtor, String content) {
        this.sarlovha = sarlovha;
        this.avtor = avtor;
        this.content = content;
    }

    public String getSarlovha() {
        return sarlovha;
    }

    public void setSarlovha(String sarlovha) {
        this.sarlovha = sarlovha;
    }

    public String getAvtor() {
        return avtor;
    }

    public void setAvtor(String avtor) {
        this.avtor = avtor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Yangilik{" +
                "sarlovha='" + sarlovha + '\'' +
                ", avtor='" + avtor + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
public class Topshirq4 {
    public static void main(String[] args) throws IOException {
        List<Yangilik> yangilikList = new ArrayList<>();

        FileInputStream fileInputStream1 = new FileInputStream("fayllar/head.txt");
        FileInputStream fileInputStream2 = new FileInputStream("fayllar/body.txt");

        byte[] heads = fileInputStream1.readAllBytes();
        String[] headArray = new String(heads).split("\n");

        byte[] bodys = fileInputStream2.readAllBytes();
        String[] bodyArray = new String(bodys).split(";");

        for (int i=0; i<headArray.length; i++){
            String[] arr = headArray[i].split(" ");
            yangilikList.add(
                    new Yangilik(arr[0], arr[1],bodyArray[i])
            );
        }

        yangilikList
                .forEach(System.out::println);


    }
}
