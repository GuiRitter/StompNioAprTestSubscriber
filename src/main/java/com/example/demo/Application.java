package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.SocketRunnable;

@SpringBootApplication
public class Application {

    public static final String API_URL = "api";

    // public static final String HOST_PORT_URL = "localhost:9443";
    public static final String HOST_PORT_URL = "17fbd0e1.ngrok.io:9443";

    /**
     * {@code wss} if using SSL, {@code ws} otherwise.
     */
    public static final String SOCKET_PROTOCOL = "wss";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        new Thread(new SocketRunnable()).start();
    }
}
