package com.springframework.spring5petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerIndexController {
    @RequestMapping({"/owners", "/owners/", "/owners/index", "/owners/index.html"})
    public String ownerIndex() {
        return "/owners/index";
    }

}
