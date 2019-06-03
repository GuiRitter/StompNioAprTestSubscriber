package com.example.demo;

import java.lang.reflect.Type;
import java.util.Arrays;

import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

public class DefaultStompSessionHandler extends StompSessionHandlerAdapter {

    public DefaultStompSessionHandler() {
        System.out.format("{ \"class\": \"DefaultStompSessionHandler\", \"method\": \"DefaultStompSessionHandler\" }\n\n");
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        System.out.format("{ \"class\": \"DefaultStompSessionHandler\", \"method\": \"afterConnected\", \"session id\": \"%s\" }\n\n", session.getSessionId());
        String topicURL = "/topic/hello_world";
        session.subscribe(topicURL, this);
        System.out.format("{ \"class\": \"DefaultStompSessionHandler\", \"method\": \"DefaultStompSessionHandler\", \"subscribed to\": \"%s\" }\n\n", topicURL);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        System.out.format("{ \"class\": \"DefaultStompSessionHandler\", \"method\": \"getPayloadType\", \"headers\": \"%s\" }\n\n", headers);
        return Object.class;
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        System.out.format("{ \"class\": \"DefaultStompSessionHandler\", \"method\": \"handleException\", \"session\": \"%s\", \"command\": \"%s\", \"headers\": \"%s\", \"payload\": \"%s\", \"exception\": \"%s\" }\n\n", session, command, headers, Arrays.toString(payload), exception);
        exception.printStackTrace();
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.format("{ \"class\": \"DefaultStompSessionHandler\", \"method\": \"handleFrame\", \"headers\": \"%s\", \"payload\": \"%s\" }\n\n", payload, headers);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        System.out.format("{ \"class\": \"DefaultStompSessionHandler\", \"method\": \"handleTransportError\", \"session\": \"%s\", \"exception\": \"%s\" }\n\n", session, exception);
        super.handleTransportError(session, exception);
    }
}
