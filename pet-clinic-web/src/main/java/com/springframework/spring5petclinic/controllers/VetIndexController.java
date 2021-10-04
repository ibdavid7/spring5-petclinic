package com.springframework.spring5petclinic.controllers;

import com.springframework.spring5petclinic.model.Vet;
import com.springframework.spring5petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetIndexController {

    private final VetService vetService;

    public VetIndexController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"vets/", "vets/index", "vets", "vets/index.html"})
    public String vetsIndex(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

}
