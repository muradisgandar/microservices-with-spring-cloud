package com.company.ticketservice.model;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Obvious"),
    IN_PROGRESS("In progress"),
    RESOLVED("Resolved"),
    CLOSED("Closed");

    private final String label;

    TicketStatus(String label) {
        this.label = label;
    }
}
