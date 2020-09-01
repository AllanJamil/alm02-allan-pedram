package org.nackademin.alm02allanpedram.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nackademin.alm02allanpedram.domain.CookieObj;
import org.nackademin.alm02allanpedram.domain.Person;
import org.nackademin.alm02allanpedram.service.FortuneCookieGeneratorService;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
class ControllerTest {

    @InjectMocks
    Controller controller;

    @Mock
    FortuneCookieGeneratorService fortuneCookieGeneratorService;

    MockMvc mockMvc;

    @Test
    void getFortune() {

        //given
        given(fortuneCookieGeneratorService.generateFortuneCookie(any(Person.class))).willReturn(new CookieObj("A dubious friend may be an enemy in camouflage."));


        //when
        CookieObj fortune = controller.getFortune(new Person());

        //then
        assertThat(fortune.getFortune()).isEqualToIgnoringCase("A dubious friend may be an enemy in camouflage.");

        then(fortuneCookieGeneratorService).should(times(1)).generateFortuneCookie(any(Person.class));
    }
}