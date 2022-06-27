package com.example.mission_control.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class BaggageRepository {
    private final Map<Integer, List<Integer>> destinationsAndBaggage;

    public BaggageRepository() {
        this.destinationsAndBaggage = new HashMap<>();
    }

    public void addDestination(Integer destinationId) {
        destinationsAndBaggage.put(destinationId, new ArrayList<>());
    }

    public List<Integer> addDestinationAndBaggage(Integer destinationId, List<Integer> baggage) {
        return destinationsAndBaggage.put(destinationId, baggage);
    }

    public boolean deleteBaggage(Integer destinationId, Integer babbageId) {
        return destinationsAndBaggage.get(destinationId).remove(babbageId);
    }

    public boolean checkInBaggage(Integer destinationId, Integer baggageId){
        return destinationsAndBaggage.get(destinationId).contains(baggageId);
    }

    public void deleteDestination(Integer destinationId) {
        destinationsAndBaggage.remove(destinationId);
    }

    public List<Integer> getBaggageByDestination(Integer destinationId){
        return destinationsAndBaggage.get(destinationId);
    }
}

