package com.company.ticketservice.service.impl;

import com.company.ticketservice.dto.TicketDTO;
import com.company.ticketservice.es.TicketModel;
import com.company.ticketservice.model.PriorityType;
import com.company.ticketservice.model.Ticket;
import com.company.ticketservice.model.TicketStatus;
import com.company.ticketservice.repository.TicketRepository;
import com.company.ticketservice.repository.es.TicketElasticRepository;
import com.company.ticketservice.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketElasticRepository ticketElasticRepository;
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    public TicketServiceImpl(TicketElasticRepository ticketElasticRepository, TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.ticketElasticRepository = ticketElasticRepository;
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public TicketDTO save(TicketDTO ticketDTO) {

        Ticket ticket = Ticket.builder()
                .description(ticketDTO.getDescription())
                .notes(ticketDTO.getNotes())
                .ticketDate(ticketDTO.getTicketDate())
                .ticketStatus(TicketStatus.valueOf(ticketDTO.getTicketStatus()))
                .priorityType(PriorityType.valueOf(ticketDTO.getPriorityType()))
                .build();

        ticket = ticketRepository.save(ticket);

        TicketModel ticketModel = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate())
                .build();

        ticketElasticRepository.save(ticketModel);

        ticketDTO.setId(ticket.getId());

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
