package org.nackademin.alm02allanpedram.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nackademin.alm02allanpedram.domain.CookieObj;
import org.nackademin.alm02allanpedram.domain.Person;
import org.nackademin.alm02allanpedram.service.FortuneCookieGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ControllerTest {

    @InjectMocks
    Controller controller;

    @Mock
    FortuneCookieGeneratorService fortuneCookieGeneratorService;

    @Test
    void getFortune() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        given(fortuneCookieGeneratorService.generateFortuneCookie(any(Person.class))).willReturn(new CookieObj("A dubious friend may be an enemy in camouflage."));

        CookieObj fortune = controller.getFortune(new Person());

        assertThat(fortune.getFortune()).isEqualToIgnoringCase("A dubious friend may be an enemy in camouflage.");
    }
}