package com.company.ticketservice.model;

import lombok.Getter;

@Getter
public enum PriorityType {
    URGENT("Immediately"),
    LOW("Poor"),
    HIGH("Top");

    private final String label;

    PriorityType(String label) {
        this.label = label;
    }
}
