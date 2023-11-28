package demo.demo45.appplication;

import java.io.*;
import java.net.*;

public class CrudServer {

    public static void main(String[] args) {
        int port = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleRequest(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read the request line
            String requestLine = reader.readLine();
            System.out.println("Request: " + requestLine);

            // Parse the request method and path
            String[] requestParts = requestLine.split(" ");
            String method = requestParts[0];
            String path = requestParts[1];

            // Handle different HTTP methods
            switch (method) {
                case "GET":
                    // Implement logic for GET operation
                    String response = handleGetRequest(path);
                    writer.println(response);
                    break;
                case "POST":
                    // Implement logic for POST operation
                    handlePostRequest(path, reader);
                    writer.println("POST request processed successfully");
                    break;
                case "PUT":
                    // Implement logic for PUT operation
                    handlePutRequest(path, reader);
                    writer.println("PUT request processed successfully");
                    break;
                case "DELETE":
                    // Implement logic for DELETE operation
                    handleDeleteRequest(path);
                    writer.println("DELETE request processed successfully");
                    break;
                default:
                    writer.println("Unsupported HTTP method");
                    break;
            }

            // Close the streams and socket
            writer.close();
            reader.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String handleGetRequest(String path) {
        // Implement logic for GET operation
        // Retrieve data from the server based on the path
        // Return the response as a string
        return "GET request processed successfully";
    }

    private static void handlePostRequest(String path, BufferedReader reader) throws IOException {
        // Implement logic for POST operation
        // Read the request body from the reader
        String requestBody = reader.readLine();
        // Process the request body and save the data to the server based on the path
        System.out.println("Request Body: " + requestBody);
    }

    private static void handlePutRequest(String path, BufferedReader reader) throws IOException {
        // Implement logic for PUT operation
        // Read the request body from the reader
        String requestBody = reader.readLine();
        // Process the request body and update the data on the server based on the path
        System.out.println("Request Body: " + requestBody);
    }

    private static void handleDeleteRequest(String path) {
        // Implement logic for DELETE operation
        // Delete the data from the server based on the path
        System.out.println("Deleted data at path: " + path);
    }
}