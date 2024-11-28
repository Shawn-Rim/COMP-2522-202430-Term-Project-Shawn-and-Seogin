package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassTest {
    private Grass grass;

    @BeforeEach
    void setup() {
        grass = new Grass();
    }

    @Test
    void testGrassToString() {
        assertEquals("Grass{}", grass.toString());
    }
}
