package com.example.demo.controller;

import com.example.demo.dto.TicketDTO;
import com.example.demo.models.Ticket;
import com.example.demo.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@AllArgsConstructor
public class TicketController {

    TicketService ticketService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAll();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{id}")
    public List<Ticket> getAllTicketsByUserId(@PathVariable int id) {
        return ticketService.getAllByUser(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket save(@RequestBody TicketDTO ticket) {
        return ticketService.createTicket(ticket);

    }


}