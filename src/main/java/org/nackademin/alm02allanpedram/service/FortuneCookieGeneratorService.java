package org.nackademin.alm02allanpedram.service;

import org.nackademin.alm02allanpedram.domain.FortuneCookie;
import org.nackademin.alm02allanpedram.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FortuneCookieGeneratorService {

    private RandomFactorService randomFactorService;
    private List<String> fortuneList = new FortuneCookie().getFortuneCookies();

    @Autowired
    public FortuneCookieGeneratorService(RandomFactorService randomFactorService) {
        this.randomFactorService = randomFactorService;
    }

    public String generateFortuneCookie(Person person) {
        int randomNumber = randomFactorService.generateRandomNumberOnPerson(person);
        return fortuneList.get(randomNumber);
    }


}
