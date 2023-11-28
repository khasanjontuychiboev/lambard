package dars.dars44;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDastur {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(6666);

               Socket clientSocket = serverSocket.accept();//ulanish
               DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

               String data = dis.readUTF();

               System.out.println("Client yozdi: "+ clientSocket.getRemoteSocketAddress()+"/: " +data);


               DataOutputStream dataOutputStream  = new DataOutputStream(clientSocket.getOutputStream());

               Scanner scanner  = new Scanner(System.in);
               String mal = scanner.next()+scanner.nextLine();
               dataOutputStream.writeUTF(mal);

               scanner.close();
               dataOutputStream.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
