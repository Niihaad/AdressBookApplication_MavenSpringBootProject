
package org.example.addressbookapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String geocodeAddress(String address) {
        String apiUrl = "https://api-adresse.data.gouv.fr/search/?q=" + address;
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public String getWeatherData(double latitude, double longitude) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude ;
        return restTemplate.getForObject(apiUrl, String.class);
    }

}