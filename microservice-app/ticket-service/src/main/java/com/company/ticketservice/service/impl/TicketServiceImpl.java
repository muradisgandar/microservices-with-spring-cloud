package com.company.ticketservice.service.impl;

import com.company.client.AccountServiceClient;
import com.company.client.contract.AccountDTO;
import com.company.ticketservice.dto.TicketDTO;
import com.company.ticketservice.es.TicketModel;
import com.company.ticketservice.model.PriorityType;
import com.company.ticketservice.model.Ticket;
import com.company.ticketservice.model.TicketStatus;
import com.company.ticketservice.repository.TicketRepository;
import com.company.ticketservice.repository.es.TicketElasticRepository;
import com.company.ticketservice.service.TicketNotificationService;
import com.company.ticketservice.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketElasticRepository ticketElasticRepository;
    private final TicketRepository ticketRepository;
    private final TicketNotificationService ticketNotificationService;
    private final AccountServiceClient accountServiceClient;

    public TicketServiceImpl(TicketElasticRepository ticketElasticRepository,
                             TicketRepository ticketRepository,
                             ModelMapper modelMapper,
                             TicketNotificationService ticketNotificationService,
                             AccountServiceClient accountServiceClient) {
        this.ticketElasticRepository = ticketElasticRepository;
        this.ticketRepository = ticketRepository;
        this.ticketNotificationService = ticketNotificationService;
        this.accountServiceClient = accountServiceClient;
    }


    @Override
    public TicketDTO save(TicketDTO ticketDTO) {
        ResponseEntity<AccountDTO> accountDTOResponseEntity = accountServiceClient.get(ticketDTO.getAssignee());
        Ticket ticket = Ticket.builder()
                .description(ticketDTO.getDescription())
                .notes(ticketDTO.getNotes())
                .ticketDate(ticketDTO.getTicketDate())
                .ticketStatus(TicketStatus.valueOf(ticketDTO.getTicketStatus()))
                .priorityType(PriorityType.valueOf(ticketDTO.getPriorityType()))
                .assignee(accountDTOResponseEntity.getBody().getId())
                .build();

        ticket = ticketRepository.save(ticket);

        TicketModel ticketModel = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .assignee(accountDTOResponseEntity.getBody().getNameSurname())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate())
                .build();

        ticketElasticRepository.save(ticketModel);

        ticketDTO.setId(ticket.getId());

        ticketNotificationService.sendToQueue(ticket);

        return ticketDTO;
    }

    @Override
    public TicketDTO update(String id, TicketDTO ticketDTO) {
        return null;
    }

    @Override
    public TicketDTO getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDTO> getPagination(Pageable pageable) {
        return null;
    }
}
