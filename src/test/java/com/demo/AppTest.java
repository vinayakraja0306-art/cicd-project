package com.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void testMessage() {
        App app = new App();
        assertEquals("Hello from Jenkins CI/CD!", app.getMessage());
    }

    @Test
    void testAddition() {
        App app = new App();
        assertEquals(10, app.add(5, 5));
    }
}
