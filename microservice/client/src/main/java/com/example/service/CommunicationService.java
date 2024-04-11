package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommunicationService {

    private final RestTemplate restTemplate;

    @Autowired
    public CommunicationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callOtherService(String serviceName, String endpoint) {
        return restTemplate.getForObject("http://" + serviceName + endpoint, String.class);
    }
}
