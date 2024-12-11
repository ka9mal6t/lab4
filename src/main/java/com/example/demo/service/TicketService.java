package com.example.demo.service;

import com.example.demo.models.Ticket;
import com.example.demo.dto.TicketDTO;
import com.example.demo.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {
    TicketRepository ticketRepository;

    UserService userProfileService;

    FlightService flightService;

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> getAllByUser(int id) {
        return ticketRepository.findByUserId(id);
    }

    public Ticket createTicket(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setPnr(ticketDTO.getPnr());
        ticket.setUser(userProfileService.getUserByUsername(ticketDTO.getUsername()));
        ticket.setFlight(flightService.findById(ticketDTO.getFlightId()));
        ticket.setCreatedAt(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }
}