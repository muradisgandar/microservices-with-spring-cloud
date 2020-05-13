package com.company.ticketservice.service.impl;

import com.company.messaging.TicketNotification;
import com.company.ticketservice.model.Ticket;
import com.company.ticketservice.service.TicketNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class TicketNotificationServiceImpl implements TicketNotificationService {

    private final Source source;

    @Override
    public void sendToQueue(Ticket ticket) {

        TicketNotification ticketNotification = TicketNotification
                .builder()
                .ticketId(ticket.getId())
                .accountId(ticket.getAssignee())
                .ticketDescription(ticket.getDescription())
                .build();

        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }
}
