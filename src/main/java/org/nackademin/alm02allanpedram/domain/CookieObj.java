package org.nackademin.alm02allanpedram.domain;

public class CookieObj {

    private String fortune;

    public CookieObj(String fortune) {
        this.fortune = fortune;
    }

    public String getFortune() {
        return fortune;
    }

    public void setFortune(String fortune) {
        this.fortune = fortune;
    }

    @Override
    public String toString() {
        return "CookieObj{" +
                "fortune='" + fortune + '\'' +
                '}';
    }
}
