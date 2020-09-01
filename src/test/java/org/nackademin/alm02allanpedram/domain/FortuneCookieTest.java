package org.nackademin.alm02allanpedram.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@TestPropertySource("classpath:fortunes.txt")
class FortuneCookieTest {

    private FortuneCookie fortuneCookie;
    private List<String> testList;
    private File fortunes;

    @BeforeEach
    void setUp() throws IOException {
        fortuneCookie = new FortuneCookie();
        testList = new ArrayList<>();
        fortunes = ResourceUtils.getFile("classpath:fortunes.txt");
        Stream<String> stream = Files.lines(Path.of(fortunes.getPath()));
        stream.forEach(line -> testList.add(line));

    }

    @Test
    void fileExistAndHasSameValues() {


        //TODO: change to pure jUnit5

        Path filePath = Path.of(fortunes.getPath());

        assertTrue(Files.exists(filePath), "File should exist");

        assertThat(testList.get(0)).isEqualToIgnoringCase(fortuneCookie.getFortuneCookies().get(0));

    }


    @Test
    void getLengthOfFortuneList() {
        assertNotEquals(0, fortuneCookie.getSizeOfFortuneList());
    }
}