package demo.demo41.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("testout.txt");

            ArrayList<String> names = new ArrayList<>();
            StringBuilder nameBuilder = new StringBuilder();
            int character;
            while ((character = fileInputStream.read()) != -1) {
                // Check for space character
                if (character == ' ') {
                    // Add the name to the list
                    names.add(nameBuilder.toString());

                    // Reset the name builder for the next name
                    nameBuilder.setLength(0);
                } else {
                    // Append character to the name builder
                    nameBuilder.append((char) character);
                }
            }

            // Add the last name if there is any
            if (nameBuilder.length() > 0) {
                names.add(nameBuilder.toString());
            }

            fileInputStream.close();

            // Print the names
            for (String name : names) {
                System.out.println(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
