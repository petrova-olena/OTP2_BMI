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

    @Test
    void shouldReturnMapForPersianLocale() {
        Map<String, String> strings =
                LocalizationService.getLocalizedStrings(new Locale("fa", "IR"));

        assertNotNull(strings);
    }

    @Test
    void shouldReturnMapForVietnameseLocale() {
        Map<String, String> strings =
                LocalizationService.getLocalizedStrings(new Locale("vi", "VI"));

        assertNotNull(strings);
    }

    @Test
    void shouldReturnNonNullMapForUnknownLocale() {
        Map<String, String> strings =
                LocalizationService.getLocalizedStrings(
                        new Locale("xx", "XX"));

        assertNotNull(strings);
    }

    @Test
    void shouldReturnMapForEmptyLocale() {
        Map<String, String> strings =
                LocalizationService.getLocalizedStrings(
                        new Locale("", ""));

        assertNotNull(strings);
    }

    @Test
    void shouldCreateLocalizationServiceInstance() {
        LocalizationService service = new LocalizationService();

        assertNotNull(service);
    }
}