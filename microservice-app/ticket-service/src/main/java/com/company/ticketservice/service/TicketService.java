package com.company.ticketservice.service;

import com.company.ticketservice.dto.TicketDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {

    TicketDTO save(TicketDTO ticketDTO);

    TicketDTO update(String id, TicketDTO ticketDTO);

    TicketDTO getById(String ticketId);

    Page<TicketDTO> getPagination(Pageable pageable);
}
