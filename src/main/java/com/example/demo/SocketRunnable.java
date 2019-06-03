package com.example.demo;

import static com.example.demo.Application.API_URL;
import static com.example.demo.Application.HOST_PORT_URL;
import static com.example.demo.Application.SOCKET_PROTOCOL;

import java.util.Arrays;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

public class SocketRunnable implements Runnable {

    static WebSocketStompClient client;

    private static final String URL = SOCKET_PROTOCOL + "://" + HOST_PORT_URL + "/" + API_URL + "/websocket";

    public SocketRunnable() {
        System.out.format("{ \"class\": \"SocketRunnable\", \"method\": \"SocketRunnable\" }\n\n");
    }

    @Override
    public void run() {
        System.out.format("{ \"class\": \"SocketRunnable\", \"method\": \"run\" }\n\n");
        try {
            client = new WebSocketStompClient(new SockJsClient(Arrays.asList(new WebSocketTransport(new StandardWebSocketClient()))));
            client.setMessageConverter(new MappingJackson2MessageConverter());
            client.connect(URL, new DefaultStompSessionHandler()).addCallback(
                stompSession -> {},
                throwable -> {
                    System.out.format("{ \"class\": \"SocketRunnable\", \"method\": \"run\", \"line\": \"throwable callback\" }\n\n");
                    throwable.printStackTrace();
                }
            );
        } catch (Exception ex) {
            client = null;
            System.out.format("{ \"class\": \"SocketRunnable\", \"method\": \"run\", \"line\": \"catch\" }\n\n");
            ex.printStackTrace();
        }
    }
}
