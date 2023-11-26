package dars.dars43;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;

class MyUser{
    private String name;
    private Integer age;

    public MyUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void addNewUser(String name,Integer age) throws IOException {

        MyUser myUser = new MyUser(name, age);
        System.out.println(myUser);
        FileWriter fileWriter = new FileWriter("fayllar/users.txt",true);
        String data = name+" "+ age+"\n";
        fileWriter.write(data);
        fileWriter.close();

    }
}

public class Main2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true){
            Socket client = serverSocket.accept();
            BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String data = bufferedReader.readLine();
            String[] dataArr  = data.replace("GET /","")
                    .replace(" HTTP/1.1","").split("[/&]");
            String request = dataArr[0];
            String data1 = dataArr[1].split("=")[1];
            String data2 = dataArr[2].split("=")[1];

           if (request.equals("createNewUser")){
               MyUser.addNewUser(data1,Integer.parseInt(data2));
           }

            bufferedReader.close();
        }









    }
}
