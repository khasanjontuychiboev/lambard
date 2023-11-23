package demo.demo41.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class SocketExample {
    public static void main(String[] args) {
        try {
            // Create a socket and connect to a remote server
            Socket socket = new Socket("127.0.0.1", 8080);

            // Send data to the server
            OutputStream out = socket.getOutputStream();
            out.write("Hello, server!".getBytes());

            // Receive data from the server
            InputStream in = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            String response = new String(buffer, 0, bytesRead);
            System.out.println("Server response: " + response);

            // Close the socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}