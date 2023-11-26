package demo.demo43;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedStreamExample {
    public static void main(String[] args) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("fayllar/myfile.txt"))) {
            // Mark the current position in the stream
            bufferedInputStream.mark(10);

            // Read and print the first 10 bytes
            byte[] buffer = new byte[10];
            int bytesRead = bufferedInputStream.read(buffer);
            for (int i=0; i<10; i++){
                System.out.println((char) buffer[i]);
            }
            System.out.println("First 10 bytes: " + new String(buffer, 0, bytesRead));

            // Reset the stream back to the marked position
            bufferedInputStream.reset();

            // Read and print the first 5 bytes again
            bytesRead = bufferedInputStream.read(buffer, 0, 5);
            System.out.println("First 5 bytes after reset: " + new String(buffer, 0, bytesRead));

            // Skip 3 bytes in the stream
            long bytesSkipped = bufferedInputStream.skip(3);
            System.out.println("Skipped " + bytesSkipped + " bytes.");

            // Read and print the next 5 bytes
            bytesRead = bufferedInputStream.read(buffer, 0, 5);
            System.out.println("Next 5 bytes: " + new String(buffer, 0, bytesRead));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}