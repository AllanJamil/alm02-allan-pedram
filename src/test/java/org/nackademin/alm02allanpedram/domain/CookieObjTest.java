package org.nackademin.alm02allanpedram.domain;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CookieObjTest {

    CookieObj cookieObj;

    @BeforeEach
    void setUp() {
        cookieObj = new CookieObj("This is a fortune.");
    }

    @Test
    void testGetFortune() {
        assertThat(cookieObj.getFortune()).isEqualToIgnoringCase("This is a fortune.");
    }

    @Test
    void testSetFortune() {
        cookieObj.setFortune("This is another Fortune");

        assertThat(cookieObj.getFortune()).isNotEqualToIgnoringCase("This is a fortune.");
        assertThat(cookieObj.getFortune()).isEqualToIgnoringCase("This is another Fortune");
    }
}