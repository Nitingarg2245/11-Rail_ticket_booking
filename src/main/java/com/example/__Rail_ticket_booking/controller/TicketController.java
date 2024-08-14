package com.example.__Rail_ticket_booking.controller;

import com.example.__Rail_ticket_booking.request.Passenger;
import com.example.__Rail_ticket_booking.response.Ticket;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TicketController {
    private final Map<Integer, Ticket>savedTickets=new HashMap<>();//for temporary storage

    @PostMapping(value = "/ticket",
            consumes ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
            produces ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
    public Ticket createTicket(@RequestBody Passenger passenger){
        Ticket ticket=new Ticket();
        ticket.setTicketId(10);
        ticket.setFrom(passenger.getFrom());
        ticket.setTo(passenger.getTo());
        ticket.setFirstName(passenger.getFname());
        ticket.setLastName(passenger.getLname());
        ticket.setTicketPrice(15000.00);
        savedTickets.put(ticket.getTicketId(), ticket);
        System.out.println(savedTickets);
        return ticket;
    }

    @GetMapping(value = "/ticket/{ticketId}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public Ticket getTicketDetails(@PathVariable int ticketId){
        if(savedTickets.containsKey(ticketId))return savedTickets.get(ticketId);
        return null;
    }
}
