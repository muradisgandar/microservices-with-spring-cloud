package com.company.ticketservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ticket")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends BaseEntityModel {

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    @Id
    private String id;

    @Column(name = "description", length = 600)
    private String description;

    @Column(name = "notes", length = 4000)
    private String notes;

    @Column(name = "assignee", length = 50)
    private String assignee;

    @Column(name = "ticket_date")
    private Date ticketDate;

    @Column(name = "priority_type")
    @Enumerated(EnumType.ORDINAL)
    private PriorityType priorityType;

    @Column(name = "ticket_status")
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;


}
