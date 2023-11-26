package demo.demo43;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketDataSenderExample {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 8080;
        String data = "name=John age=24 salary=500";

        try (Socket socket = new Socket(serverAddress, serverPort);
             OutputStream outputStream = socket.getOutputStream()) {

            // Convert the data string to bytes
            byte[] dataBytes = data.getBytes();

            // Send the data to the server
            outputStream.write(dataBytes);

            System.out.println("Data sent successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}