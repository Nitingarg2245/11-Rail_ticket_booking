package com.example.__Rail_ticket_booking.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private Integer ticketId;
    private String from;
    private String to;
    private String firstName;
    private String lastName;
    private Double ticketPrice;
}
