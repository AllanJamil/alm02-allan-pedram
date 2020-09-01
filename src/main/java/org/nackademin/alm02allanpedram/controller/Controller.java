package org.nackademin.alm02allanpedram.controller;

import org.nackademin.alm02allanpedram.domain.CookieObj;
import org.nackademin.alm02allanpedram.domain.Person;
import org.nackademin.alm02allanpedram.service.FortuneCookieGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fortune/api")
public class Controller {

    private FortuneCookieGeneratorService fortuneCookieGeneratorService;

    @Autowired
    public Controller(FortuneCookieGeneratorService fortuneCookieGeneratorService) {
        this.fortuneCookieGeneratorService = fortuneCookieGeneratorService;
    }

    @PostMapping("cookie")
    public CookieObj getFortune(@RequestBody Person person) {
        return fortuneCookieGeneratorService.generateFortuneCookie(person);
    }
}