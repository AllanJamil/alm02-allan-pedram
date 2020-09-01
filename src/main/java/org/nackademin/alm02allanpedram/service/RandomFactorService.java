package org.nackademin.alm02allanpedram.service;

import org.nackademin.alm02allanpedram.domain.FortuneCookie;
import org.nackademin.alm02allanpedram.domain.GenderType;
import org.nackademin.alm02allanpedram.domain.Person;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomFactorService {

    public static int generateRandomNumberOnPerson(Person person) {
        int valueFromFullName = getValueFromFullName(person.getFullName());
        int valueFromNationality = getValueFromNationality(person.getNationality());
        int valueFromAge = getValueFromAge(person.getAge());
        int valueFromGender = getValueFromGender(person.getGender());
        int randomNumber  = (valueFromFullName + valueFromNationality + valueFromAge + valueFromGender);

        if (randomNumber < 100)
            randomNumber = randomNumber *  5;
        else
            randomNumber = randomNumber / 5;

        int lengthOfFortuneList = new FortuneCookie().getLengthOfFortuneList();
        if (randomNumber < 0 || randomNumber > lengthOfFortuneList)
            randomNumber = new Random().nextInt(lengthOfFortuneList);

        return randomNumber;
    }

    private static int getValueFromFullName(String fullName) {
        String firstLetter = Character.toString(fullName.charAt(0));
        String lastLetter = Character.toString(fullName.charAt(fullName.length() - 1));

        int v1 = 0, v2 = 0;

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars = alphabet.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (firstLetter.equalsIgnoreCase(String.valueOf(chars[i]))) {
                v1 = i;
            } else if (lastLetter.equalsIgnoreCase(String.valueOf(chars[i]))) {
                v2 = i;
            }
        }
        return (v1 - v2) / 2;
    }

    private static int getValueFromNationality(String nationality) {
        return (nationality.length() / 5) + 3;
    }

    private static int getValueFromAge(int age) {
        return (age - 10);
    }

    private static int getValueFromGender(GenderType genderType) {
        return genderType == GenderType.MALE ? 10 : 20;
    }
}
