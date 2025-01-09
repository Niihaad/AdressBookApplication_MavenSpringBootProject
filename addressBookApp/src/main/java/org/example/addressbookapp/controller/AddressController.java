package org.example.addressbookapp.controller;

import org.example.addressbookapp.model.Address;
import org.example.addressbookapp.model.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    // Affichage de la page avec toutes les adresses
    @GetMapping("/addresses")
    public String showAddresses(Model model) {
        Iterable<Address> allAddresses = addressRepository.findAll();
        model.addAttribute("allAddresses", allAddresses);
        return "addresses";  // Affiche la page "addresses.html"
    }

}
