package org.example.addressbookapp.controller;

import org.example.addressbookapp.model.Address;
import org.example.addressbookapp.model.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/addresses")
    public String showAddresses(Model model) {
        Iterable<Address> allAddresses = addressRepository.findAll();
        model.addAttribute("allAddresses", allAddresses);
        return "addresses";
    }
}