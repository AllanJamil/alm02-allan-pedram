package org.nackademin.alm02allanpedram.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.nackademin.alm02allanpedram.domain.FortuneCookie;
import org.nackademin.alm02allanpedram.domain.GenderType;
import org.nackademin.alm02allanpedram.domain.Person;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomFactorServiceTest {

    private Person person = new Person("ea", "Norge", 18, GenderType.MALE);
    private int expectedValue;

    @Test
    void testRandomNumberIsLessThan100WillGetMultiplied() {
        int valueFromFullName = RandomFactorService.getValueFromFullName(person.getFullName());
        int valueFromNationality = RandomFactorService.getValueFromNationality(person.getNationality());
        int valueFromAge = RandomFactorService.getValueFromAge(person.getAge());
        int valueFromGender = RandomFactorService.getValueFromGender(person.getGender());
        int randomNumber = (valueFromFullName + valueFromNationality + valueFromAge + valueFromGender);

        if (randomNumber < 100)
            randomNumber = randomNumber * 5;
        else
            randomNumber = randomNumber / 5;

        int lengthOfFortuneList = new FortuneCookie().getSizeOfFortuneList();
        if (randomNumber < 0 || randomNumber > lengthOfFortuneList)
            randomNumber = new Random().nextInt(lengthOfFortuneList);

        assertEquals(randomNumber, RandomFactorService.generateRandomNumberOnPerson(person));
        person.setAge(43);
        assertNotEquals(randomNumber, RandomFactorService.generateRandomNumberOnPerson(person));

    }


    @Test
    void testRandomNumberAbove100WillGetDivided() {
        person.setAge(900);
        assertEquals(181, RandomFactorService.generateRandomNumberOnPerson(person));
    }

    @Test
    void testRandomNumberLessThanZeroWillReturnAboveZero() {
        person.setAge(-1000);
        assertThat(RandomFactorService.generateRandomNumberOnPerson(person)).isGreaterThan(0);
    }

    @Test
    void getValueFromFullName() {
        assertEquals(2, RandomFactorService.getValueFromFullName("ea"));
        assertNotEquals(2, RandomFactorService.getValueFromFullName("sfsdfsdgf"));
    }

    @Test
    void getValueFromNationality() {
        expectedValue = ("Norge".length() / 5) + 3;
        assertNotEquals(expectedValue, RandomFactorService.getValueFromNationality("Afghanistan"));
    }

    @Test
    void getValueFromAge() {
        expectedValue = 18 - 10;

        assertEquals(expectedValue, RandomFactorService.getValueFromAge(18));
        assertNotEquals(expectedValue, RandomFactorService.getValueFromAge(28));
    }

    @Test
    void getValueFromGender() {
        int expectedValueMale = 10;
        int expectedValueFemale = 20;

        assertEquals(expectedValueMale, RandomFactorService.getValueFromGender(GenderType.MALE));
        assertEquals(expectedValueFemale, RandomFactorService.getValueFromGender(GenderType.FEMALE));
        assertNotEquals(expectedValueMale, RandomFactorService.getValueFromGender(GenderType.FEMALE));
        assertNotEquals(expectedValueFemale, RandomFactorService.getValueFromGender(GenderType.MALE));

    }
}