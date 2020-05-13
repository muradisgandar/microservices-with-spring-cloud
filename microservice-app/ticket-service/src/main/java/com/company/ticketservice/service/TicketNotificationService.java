package com.company.ticketservice.service;

import com.company.ticketservice.model.Ticket;

public interface TicketNotificationService {

    void sendToQueue(Ticket ticket);
}
