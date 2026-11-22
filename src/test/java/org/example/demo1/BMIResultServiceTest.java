package org.example.demo1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BMIResultServiceTest {

    @Test
    void shouldSaveResultWithoutThrowingException() {

        assertDoesNotThrow(() ->
                BMIResultService.saveResult(
                        70,
                        1.75,
                        22.86,
                        "en"
                )
        );
    }

    @Test
    void shouldHandleZeroValues() {
        assertDoesNotThrow(() ->
                BMIResultService.saveResult(
                        0,
                        0,
                        0,
                        "en"
                )
        );
    }

    @Test
    void shouldHandleNegativeValues() {
        assertDoesNotThrow(() ->
                BMIResultService.saveResult(
                        -1,
                        -1,
                        -1,
                        "en"
                )
        );
    }

    @Test
    void shouldHandleFrenchLanguage() {
        assertDoesNotThrow(() ->
                BMIResultService.saveResult(
                        80,
                        1.80,
                        24.69,
                        "fr"
                )
        );
    }

    @Test
    void shouldHandleEmptyLanguage() {
        assertDoesNotThrow(() ->
                BMIResultService.saveResult(
                        70,
                        1.75,
                        22.86,
                        ""
                )
        );
    }
}