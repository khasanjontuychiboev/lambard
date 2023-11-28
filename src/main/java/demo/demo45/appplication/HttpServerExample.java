package demo.demo45.appplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpServerExample {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            handleRequest(clientSocket);
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String requestLine = reader.readLine();

        if (requestLine == null) {
            clientSocket.close();
            return;
        }
        System.out.println(requestLine);

        String[] requestParts = requestLine.split(" ");
        String method = requestParts[0];
        String url = requestParts[1];

        // Prepend default protocol if missing
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url; // Assuming default protocol is HTTP
        }

        // Extract URL components
        URL requestUrl = new URL(url);
        String path = requestUrl.getPath();
        Map<String, String> requestParams = parseQueryParameters(requestUrl.getQuery());

        // Print request details
        System.out.println("Method: " + method);
        System.out.println("URL: " + url);
        System.out.println("Path: " + path);
        System.out.println("Request Parameters: " + requestParams);

        // Handle different request methods
        if ("POST".equals(method)) {
            //...

        } else if ("GET".equals(method)) {
            // Perform GET request handling
            System.out.println("Get Method invoked");
        } else if ("PUT".equals(method)) {
            // Perform PUT request handling
            // ...
        } else if ("DELETE".equals(method)) {
            // Perform DELETE request handling
            // ...
        }

        reader.close();
        clientSocket.close();
    }

    private static Map<String, String> parseQueryParameters(String query) {
        Map<String, String> parameters = new HashMap<>();
        if (query != null && !query.isEmpty()) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                try {
                    String key = URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8);
                    String value = URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8);
                    parameters.put(key, value);
                } catch (Exception e) {
                    // Handle decoding exception
                }
            }
        }
        return parameters;
    }

    private static String readRequestBody(HttpURLConnection connection) throws IOException {
        StringBuilder requestBody = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
                System.out.println(line);
            }
        }

        return requestBody.toString();
    }
}