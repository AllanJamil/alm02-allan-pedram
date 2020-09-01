package org.nackademin.alm02allanpedram.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nackademin.alm02allanpedram.domain.GenderType;
import org.nackademin.alm02allanpedram.domain.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FortuneCookieGeneratorServiceTest {


    @InjectMocks
    FortuneCookieGeneratorService fortuneCookieGeneratorService;



    @Test
    void generateFortuneCookie() {
        Person person = new Person("ea", "Norge", 18, GenderType.MALE);

        int i = RandomFactorService.generateRandomNumberOnPerson(person);
        System.out.println(i);

        String fortune = fortuneCookieGeneratorService.generateFortuneCookie(person).getFortune();
        String expectedValue = "If you think you can do a thing or think you can’t do a thing, you’re right.";

        assertThat(fortune).isEqualToIgnoringCase(expectedValue);

    }
}