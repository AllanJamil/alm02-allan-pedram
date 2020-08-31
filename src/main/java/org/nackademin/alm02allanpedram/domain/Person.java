package org.nackademin.alm02allanpedram.domain;

public class Person {

    private String fullName;
    private String nationality;
    private int age;
    private GenderType gender;

    public Person(String fullName, String nationality, int age, GenderType gender) {
        this.fullName = fullName;
        this.nationality = nationality;
        this.age = age;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
