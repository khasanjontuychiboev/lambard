package demo.demo41.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Names {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Xasan2");
        names.add("Xusan2");
        names.add("Ali2");
        names.add("Jamshid2");
        try {
            FileOutputStream fileOutputStream  = new FileOutputStream("names.txt", true);
            for (String name: names) {
                byte[] bytes = name.getBytes();
                fileOutputStream.write(bytes);
                fileOutputStream.write(",".getBytes());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
