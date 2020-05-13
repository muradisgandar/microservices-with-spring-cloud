package com.company.notification;

import com.company.messaging.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class NotificationDistributionService {

    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification) {
        System.out.println("Notification is got and is sending to users");
        System.out.println("--------------------------------------------");
        System.out.println("Notification -> " + ticketNotification.toString());
    }
}
