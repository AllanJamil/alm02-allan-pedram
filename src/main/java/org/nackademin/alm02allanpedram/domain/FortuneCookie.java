package org.nackademin.alm02allanpedram.domain;

import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FortuneCookie {

    private List<String> fortuneCookies = new ArrayList<>();
    File file;

    {
        try {
            file = ResourceUtils.getFile("classpath:fortunes.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> getFortuneCookies()  {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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

    public int getLengthOfFortuneList() {
        return getFortuneCookies().size();
    }
}
