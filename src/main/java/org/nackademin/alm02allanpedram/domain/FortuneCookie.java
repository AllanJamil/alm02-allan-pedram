package org.nackademin.alm02allanpedram.domain;

import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FortuneCookie {

    private File file;
    private List<String> fortuneCookies = new ArrayList<>();

    {
        try {
            file = ResourceUtils.getFile("classpath:fortunes.txt");
        } catch (FileNotFoundException e) {
            fortuneCookies = null;
        }
    }



    public List<String> getFortuneCookies() {


        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(this.file));
        } catch (Exception e) {
            return fortuneCookies = null;
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

    public File getFile() {
        return file;
    }

    // for testing purposes
    public void setFile(File file) {
        this.file = file;
    }
}
