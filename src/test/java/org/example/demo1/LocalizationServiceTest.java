package org.example.demo1;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceTest {

    @Test
    void shouldReturnMapForEnglishLocale() {
        Map<String, String> strings =
                LocalizationService.getLocalizedStrings(new Locale("en", "US"));

        assertNotNull(strings);
    }

    @Test
    void shouldReturnMapForFrenchLocale() {
        Map<String, String> strings =
                LocalizationService.getLocalizedStrings(new Locale("fr", "FR"));

        assertNotNull(strings);
    }

    @Test
    void shouldReturnMapForUrduLocale() {
        Map<String, String> strings =
                LocalizationService.getLocalizedStrings(new Locale("ur", "PA"));

        assertNotNull(strings);
    }
}