package com.example.mission_control.controller;

import com.example.mission_control.repository.CacheRepository;
import com.example.mission_control.service.TicketService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class TicketController {
    private final TicketService ticketService;
    private final CacheRepository cacheRepository;

    public TicketController(TicketService ticketService,
                            CacheRepository cacheRepository) {
        this.ticketService = ticketService;
        this.cacheRepository = cacheRepository;
    }

    @GetMapping("/check{ticketId}")
    public boolean checkTicket(@PathVariable Integer ticketId) {
        String key = "checkTicket" + ticketId;
        Object cash = cacheRepository.getCash(key);
        if(cash == null) {
            boolean value = ticketService.checkTicket(ticketId);
            cacheRepository.addNewCash(key, value);
            return value;
        }
        return (boolean)cash;
    }

    @PutMapping("/add{ticketId}")
    public void addBooking(@PathVariable Integer ticketId) {
        ticketService.bookYourPlace(ticketId);
    }

    @DeleteMapping("/delete{ticketId}")
    public void cancelBooking(@PathVariable Integer ticketId) {
        ticketService.cancelYourBooking(ticketId);
    }
}
