package org.nackademin.alm02allanpedram.service;

import org.nackademin.alm02allanpedram.domain.CookieObj;
import org.nackademin.alm02allanpedram.domain.FortuneCookie;
import org.nackademin.alm02allanpedram.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FortuneCookieGeneratorService {

    private List<String> fortuneList = new FortuneCookie().getFortuneCookies();


    public FortuneCookieGeneratorService() {

    }

    public CookieObj generateFortuneCookie(Person person) {
        int randomNumber = RandomFactorService.generateRandomNumberOnPerson(person);
        return new CookieObj(fortuneList.get(randomNumber));
    }


}
