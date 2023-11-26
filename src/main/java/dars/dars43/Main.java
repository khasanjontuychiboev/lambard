package dars.dars43;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream i1 = new FileInputStream("fayllar/myfile1.txt");
        FileInputStream i2 = new FileInputStream("fayllar/myfile2.txt");
        FileInputStream i3 = new FileInputStream("fayllar/myfile3.txt");
        Vector v = new Vector();
        v.add(i1);
        v.add(i2);
        v.add(i3);

        SequenceInputStream sis = new SequenceInputStream(v.elements());

        String[] shikoyatlar = new String(sis.readAllBytes()).split("\n");

        FileOutputStream fos1 = new FileOutputStream("fayllar/frontchi.txt");
        FileOutputStream fos2 = new FileOutputStream("fayllar/backendchi.txt");

        for (String x:shikoyatlar) {
            if (x.contains("#b")){
                fos2.write(x.concat("\n").getBytes());
            }else if (x.contains("#f")){
                fos1.write(x.concat("\n").getBytes());
            }
        }

    }
}
