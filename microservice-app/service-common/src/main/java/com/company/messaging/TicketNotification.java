package com.company.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketNotification {

    private String ticketId;
    private String accountId;
    private String ticketDescription;
}
