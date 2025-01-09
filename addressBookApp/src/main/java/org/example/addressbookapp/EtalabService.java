package org.example.addressbookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EtalabService {

    private static final String API_URL = "https://api-adresse.data.gouv.fr/search/?q=%s&limit=1";

    private final RestTemplate restTemplate;

    @Autowired
    public EtalabService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EtalabResponse getAdresseInfo(String adresse) {
        String url = String.format(API_URL, adresse.replace(" ", "+"));
        ResponseEntity<EtalabResponse> response = restTemplate.getForEntity(url, EtalabResponse.class);
        return response.getBody();
    }
}
