package org.sip.exo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoMVCController {

    @GetMapping("/ynov")
    public String displayMessage() {
        return "Hello Ynov";
    }
}

