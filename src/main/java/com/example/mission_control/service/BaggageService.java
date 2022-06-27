package com.example.mission_control.service;

import com.example.mission_control.repository.BaggageRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BaggageService {
    private final BaggageRepository baggageRepository;

    public BaggageService(BaggageRepository baggageRepository) {
        this.baggageRepository = baggageRepository;
    }

    public void addDestination(Integer destinationId) {
        baggageRepository.addDestination(destinationId);
        log.info("IN addDestination - the destination was added by id: {}", destinationId);
    }

    public boolean addBaggage(Integer destinationId, Integer baggageId) {
        List<Integer> baggageByDestination = baggageRepository.getBaggageByDestination(destinationId);
        if(baggageByDestination == null){
            List<Integer> baggage = new ArrayList<>();
            baggage.add(baggageId);
            List<Integer> listBaggage = baggageRepository.addDestinationAndBaggage(destinationId, baggage);
            log.info("IN addDestinationAndBaggage - luggage: {} has been added", baggageId);
            return true;
        }
        baggageByDestination.add(baggageId,0);
        baggageRepository.addDestinationAndBaggage(destinationId,baggageByDestination);
        log.info("IN addDestinationAndBaggage - luggage: {} has been added", baggageId);
        return true;


    }

    public boolean removeBaggage(Integer destinationId, Integer baggageId){
        boolean isRemoved = baggageRepository.deleteBaggage(destinationId, baggageId);
        if (isRemoved){
            log.info("IN removeBaggage - baggage: {} has been removed", baggageId);
        }else {
            log.info("IN removeBaggage - baggage: {} cannot be removed", baggageId);
        }
        return isRemoved;
    }

    public boolean checkInBaggage(Integer destinationId, Integer baggageId) {
        boolean isPresent = baggageRepository.checkInBaggage(destinationId, baggageId);
        if(isPresent){
            log.info("IN checkInBaggage - the baggage by id: {} at destination: {} not found", baggageId, destinationId);
            return isPresent;
        }
        log.info("IN checkInBaggage - the baggage by id: {} at destination: {} found", baggageId, destinationId);
        return isPresent;
    }

    public void deleteDestination(Integer destinationId) {
        baggageRepository.deleteDestination(destinationId);
    }
}
