package com.springframework.spring5petclinic.controllers;

import com.springframework.spring5petclinic.model.Owner;
import com.springframework.spring5petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerIndexController {

    private final OwnerService<Owner, Long> ownerService;

    public OwnerIndexController(OwnerService<Owner, Long> ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String ownerIndex(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "/owners/index";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "not_implemented";
    }

}
