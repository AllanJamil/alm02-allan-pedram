package org.nackademin.alm02allanpedram.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;


class FortuneCookieTest {

    private FortuneCookie fortuneCookie;
    private List<String> testList;
    private File fortunesFile;

    @BeforeEach
    void setUp() throws IOException {
        fortuneCookie = new FortuneCookie();
        testList = new ArrayList<>();
        fortunesFile = ResourceUtils.getFile("classpath:fortunes.txt");
        Stream<String> stream = Files.lines(Path.of(fortunesFile.getPath()));
        stream.forEach(line -> testList.add(line));

    }

    @Test
    void testFileDoesNotExistReturnsNull() {
        Person person = new Person();


        try {
            fortuneCookie.setFile(ResourceUtils.getFile("classpath:f.txt"));
        } catch (FileNotFoundException e) {

            List<String> fortuneCookies = fortuneCookie.getFortuneCookies();
            assertNull(fortuneCookies);
        }

    }

    @Test
    void testFileExistAndHasSameValues() {
        //TODO: change to pure jUnit5

        Path filePath = Path.of(fortunesFile.getPath());

        assertTrue(Files.exists(filePath), "File should exist");

        assertThat(testList.get(0)).isEqualToIgnoringCase(fortuneCookie.getFortuneCookies().get(0));
    }


    @Test
    void testGetLengthOfFortuneList() {
        assertNotEquals(0, fortuneCookie.getSizeOfFortuneList());
    }

    @Test
    void testGetFileMethodIsTheSame() {

        File file = new File("f.txt");
        fortuneCookie.setFile(file);

        assertEquals(file, fortuneCookie.getFile());
        assertNotEquals(fortunesFile, fortuneCookie.getFile());
    }
}