package dars.dars45;

import java.net.MalformedURLException;
import java.net.URL;

public class Sorov {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://daryo.uz/category/dunyo?id=3&name=xasan");
        System.out.println("protocol: "+url.getProtocol());
        System.out.println("host: "+url.getHost());
        System.out.println("port: "+url.getDefaultPort());
        System.out.println("path: " + url.getPath());
        System.out.println("query: "+url.getQuery());


    }
}
