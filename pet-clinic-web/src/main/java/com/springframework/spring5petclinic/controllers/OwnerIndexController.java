package com.springframework.spring5petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerIndexController {
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String ownerIndex() {
        return "/owners/index";
    }

}
