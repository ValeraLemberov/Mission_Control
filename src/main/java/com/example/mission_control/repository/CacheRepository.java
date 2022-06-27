package com.example.mission_control.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CacheRepository {
    private final Map<String, Object> requestCash;

    public CacheRepository() {
        this.requestCash = new HashMap<>();
    }

    public void addNewCash(String key, Object value) {
        requestCash.put(key,value);
    }

    public Object getCash(String key){
        return requestCash.get(key);
    }
}
