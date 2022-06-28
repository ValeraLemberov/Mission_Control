package com.example.mission_control.repository;

import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class TicketRepository {
    private final Boolean[] tickets;

    public TicketRepository() {
        this.tickets = new Boolean[526];
        Arrays.fill(tickets,1,tickets.length, false);
    }


    public boolean getTicketById(Integer id) {
        return tickets[id];
    }

    public void setBooking(Integer id) {
        tickets[id] = true;
    }

    public void deleteBooking(Integer id) {
        tickets[id] = false;
    }
}
