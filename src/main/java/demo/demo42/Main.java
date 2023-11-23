package demo.demo42;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fin=new FileInputStream("fayllar/demo.txt");
            BufferedInputStream bin=new BufferedInputStream(fin);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
