package org.nackademin.alm02allanpedram.domain;

import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FortuneCookie {

    private List<String> fortuneCookies = new ArrayList<>();
    File file;

    public List<String> getFortuneCookies() {

        try {
            file = ResourceUtils.getFile("classpath:fortunes.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        String line = null;

        while (true) {
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            fortuneCookies.add(line);
        }
        return fortuneCookies;
    }

    public int getSizeOfFortuneList() {
        return getFortuneCookies().size();
    }
}
