package demo.demo43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class LocalhostReadingExample1 {
    public static void main(String[] args) {
        try {
            // Create a ServerSocket and bind it to the localhost address and a specific port
            ServerSocket serverSocket = new ServerSocket(8080);

            // Wait for a client to connect
            System.out.println("Waiting for connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Obtain an input stream from the client socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Read and output each line sent by the client
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the reader and client socket
            reader.close();
            clientSocket.close();

            // Close the server socket
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}