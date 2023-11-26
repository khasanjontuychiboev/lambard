package demo.demo43;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LocalhostServerExample {
    public static void main(String[] args) throws IOException {
        int serverPort = 8080;

        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server started on port " + serverPort);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (InputStream inputStream = clientSocket.getInputStream();
                 OutputStream outputStream = clientSocket.getOutputStream()) {

                String str = new String(inputStream.readAllBytes());
                System.out.println(str);

                // Process the request and generate the response
                String response = "Hello from the server!";

                // Send the response back to the client
                outputStream.write(response.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}