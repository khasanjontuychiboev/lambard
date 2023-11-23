package demo.demo41.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataReader {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("tesout.txt");

            Map<String, Integer> dataMap = new HashMap<>();
            StringBuilder nameBuilder = new StringBuilder();
            StringBuilder ageBuilder = new StringBuilder();
            boolean isAge = false;
            int character;
            while ((character = fileInputStream.read()) != -1) {
                // Check for space or newline character
                if (character == ' ' || character == '\n') {
                    if (!isAge){
                        isAge=true;
                    }else {
                        int age = Integer.parseInt(ageBuilder.toString());
                        String name = nameBuilder.toString();
                        isAge=false;
                        // Add the name and age to the map
                        dataMap.put(name, age);

                        // Reset the builders for the next pair
                        nameBuilder.setLength(0);
                        ageBuilder.setLength(0);
                    }




                } else {
                    // Append character to the appropriate builder
                    if (!isAge) {
                        nameBuilder.append((char) character);
                    } else {
                        ageBuilder.append((char) character);
                    }
                }
            }

            fileInputStream.close();

            // Print the data map
            for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
                String name = entry.getKey();
                int age = entry.getValue();
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}