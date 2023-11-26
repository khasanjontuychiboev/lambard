package demo.demo43;

import java.io.*;
import java.util.Arrays;

public class MarkResetExample {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("fayllar/myfile.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

    }
}