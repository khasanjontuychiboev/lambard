package dars.dars44;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("192.168.169.69",6666);
        DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());

        dataOutputStream.writeUTF("Salom");

        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        System.out.println(dataInputStream.readUTF());


        dataOutputStream.flush();
        dataOutputStream.close();
        client.close();
    }
}
