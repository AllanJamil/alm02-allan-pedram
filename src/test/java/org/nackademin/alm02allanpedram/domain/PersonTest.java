package org.nackademin.alm02allanpedram.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    //only testing set methods since get methods have been covered in other test classes
    Person person = new Person("John Burke", "USA", 46, GenderType.MALE);

    @Test
    void setFullName() {
        person.setFullName("Sarah Fish");
        assertThat(person.getFullName()).isNotEqualToIgnoringCase("John Burke");
        assertThat(person.getFullName()).isEqualToIgnoringCase("Sarah Fish");
    }

    @Test
    void setNationality() {
        person.setNationality("England");
        assertThat(person.getNationality()).isNotEqualToIgnoringCase("USA");
        assertThat(person.getNationality()).isEqualToIgnoringCase("England");
    }

    @Test
    void setAge() {
        person.setAge(23);
        assertThat(person.getAge()).isEqualTo(23);
        assertThat(person.getAge()).isNotEqualTo(46);
    }

    @Test
    void setGender() {
        person.setGender(GenderType.FEMALE);
        assertThat(person.getGender()).isEqualTo(GenderType.FEMALE);
        assertThat(person.getGender()).isNotEqualTo(GenderType.MALE);
    }
}