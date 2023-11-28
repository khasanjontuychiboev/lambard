package demo.demo44;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("localhost",3333);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str="",str2="";
        while(!str.equals("stop")){
            str=br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str2=din.readUTF();
            System.out.println("Server says: "+str2);
        }
        dout.close();
        s.close();

    }
} 