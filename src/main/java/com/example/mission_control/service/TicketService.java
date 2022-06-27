package com.example.mission_control.service;

import com.example.mission_control.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public boolean checkTicket(Integer id){
        if(id > 525 || id < 1) {
            log.info("IN checkTicket = no seat by the id: {}", id);
           return false;
        }
        return ticketRepository.getTicketById(id);
    }

    public void bookYourPlace(Integer id){
        if(id > 525 || id < 1) {
            log.info("IN bookYourPlace = no seat by the id: {}", id);
        }
        ticketRepository.setBooking(id);
    }

    public void cancelYourBooking(Integer id){
        if(id > 525 || id < 1) {
            log.info("IN cancelYourBooking = no seat by the id: {}", id);
        }
        ticketRepository.deleteBooking(id);
    }
}
