package org.example.demo1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HelloApplicationTest {

    @Test
    void shouldCreateApplicationObject() {
        HelloApplication app = new HelloApplication();
        assertNotNull(app);
    }
}