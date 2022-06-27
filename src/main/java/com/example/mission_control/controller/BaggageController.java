package com.example.mission_control.controller;

import com.example.mission_control.repository.CacheRepository;
import com.example.mission_control.service.BaggageService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baggage")
public class BaggageController {
    private final BaggageService baggageService;
    private final CacheRepository cacheRepository;

    public BaggageController(BaggageService baggageService,
                             CacheRepository cacheRepository) {
        this.baggageService = baggageService;
        this.cacheRepository = cacheRepository;
    }

    @PutMapping("/add-destination")
    public void addDestination(@RequestParam Integer destinationId) {
        baggageService.addDestination(destinationId);
    }

    @PutMapping("/add-baggage")
    public boolean addBaggage(@RequestParam Integer destinationId,
                              @RequestParam Integer baggageId) {
        return baggageService.addBaggage(destinationId, baggageId);
    }

    @DeleteMapping("/remove-baggage")
    public boolean removeBaggage(@RequestParam Integer destinationId,
                                 @RequestParam Integer baggageId) {
        return baggageService.removeBaggage(destinationId, baggageId);
    }

    @GetMapping("/check-baggage")
    public boolean checkBaggage(@RequestParam Integer destinationId,
                                @RequestParam Integer baggageId) {
        String key = "checkBaggage" + destinationId + ":" + baggageId;
        Object cash = cacheRepository.getCash(key);
        if (cash == null) {
            boolean value = baggageService.checkInBaggage(destinationId, baggageId);
            cacheRepository.addNewCash(key, value);
            return value;
        }
        return (boolean)cash;
    }

    @DeleteMapping("/remove-destination")
    public void deleteDestination(@RequestParam Integer destinationId) {
        baggageService.deleteDestination(destinationId);
    }
}
