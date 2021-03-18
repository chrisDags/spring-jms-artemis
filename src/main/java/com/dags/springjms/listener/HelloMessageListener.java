package com.dags.springjms.listener;

import com.dags.springjms.config.JmsConfig;
import com.dags.springjms.model.HelloWorldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

@Component
public class HelloMessageListener {
    @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message) {

        //System.out.println("I got the message: " + helloWorldMessage);

    }

    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message) throws JMSException {

        System.out.println("The message received from Sender: "+helloWorldMessage);

        HelloWorldMessage payloadMessage = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("World!")
                .build();


        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMessage);
    }
}
