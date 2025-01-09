package org.example.addressbookapp.controller;

import org.example.addressbookapp.EtalabResponse;
import org.example.addressbookapp.EtalabService;
import org.example.addressbookapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MeteoController {

    @Autowired
    private WeatherService weatherService;
    @Autowired
    private EtalabService etalabService;

    @PostMapping("/meteo")
    public String getWeather(@RequestParam("address") String address, Model model) {
        // Récupérer les informations d'adresse
        EtalabResponse etalabResponse = etalabService.getAdresseInfo(address);

        if (etalabResponse != null && etalabResponse.getFeatures() != null && !etalabResponse.getFeatures().isEmpty()) {
            EtalabResponse.Feature feature = etalabResponse.getFeatures().get(0);

            // Extraire les informations utiles de l'adresse
            String addressLabel = feature.getProperties().getLabel();
            String city = feature.getProperties().getCity();
            String postcode = feature.getProperties().getPostcode();
            String context = feature.getProperties().getContext();

            // Passez à la vue pour afficher ces informations
            model.addAttribute("addressLabel", addressLabel);
            model.addAttribute("city", city);
            model.addAttribute("postcode", postcode);
            model.addAttribute("context", context);

            // Optionnel : appeler le service météo pour ajouter la météo pour cette adresse
            String weatherInfo = weatherService.geocodeAddress(address);
            model.addAttribute("weatherInfo", weatherInfo);
        } else {
            model.addAttribute("weatherInfo", "Aucune information trouvée pour cette adresse.");
        }

        return "meteo";  // Retourne à la vue "meteo.html"
    }
}
