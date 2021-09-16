package com.springframework.spring5petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetIndexController {

    @RequestMapping({"vets/", "vets/index", "vets", "vets/index.html"})
    public String vetsIndex() {
        return "vets/index";
    }

}
