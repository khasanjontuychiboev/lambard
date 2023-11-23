package demo.demo41.io;

import java.io.IOException;
import java.io.InputStream;

public class Sistemnik {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        int i =0;
        while ((i=is.read())!=-1){
            System.out.print((char)i);
        };
        is.close();
    }
}
