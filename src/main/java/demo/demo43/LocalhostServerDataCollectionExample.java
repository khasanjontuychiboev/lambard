package demo.demo43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalhostServerDataCollectionExample {
    public static void main(String[] args) {

        try {
            // Create a ServerSocket and bind it to the localhost address and a specific port
            ServerSocket serverSocket = new ServerSocket(8080);

            System.out.println("Server is running and waiting for connections...");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Obtain an input stream from the client socket
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Read the request data sent by the client
                String requestData = reader.readLine();
                // Output the received data to the console
                System.out.println("Received data: " + requestData);
                System.out.println("Received Alldata: " + reader.read());

                // Close the reader and the client socket
                reader.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}