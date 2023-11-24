package demo.demo42;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            String matn = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

            FileOutputStream fos = new FileOutputStream("fayllar/demo.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, matn.length()+1);
            byte[] all = matn.getBytes();
            bos.write(all);
            Thread.sleep(5000);
            bos.flush();
            bos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
