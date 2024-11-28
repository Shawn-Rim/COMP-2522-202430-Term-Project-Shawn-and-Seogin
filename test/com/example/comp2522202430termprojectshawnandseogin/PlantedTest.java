package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantedTest {
    private final Seed seed = new EggplantSeed();
    private final Soil soil = new Soil(3, 3, 50);
    private final Planted planted = new Planted(seed, soil);

    @Test
    void testInitialProgress() {
        assertEquals(0.0, planted.getProgress());
    }

    @Test
    void testGrowPlant() {
        planted.growPlant();
        assertEquals(0.2, planted.getProgress());
    }

    @Test
    void testInteract() {
        planted.growPlant();
        planted.growPlant();
        planted.growPlant();
        planted.growPlant();
        planted.growPlant();
        planted.growPlant();
        assertNull(soil.getDecorator());
    }

    @Test
    void testToString() {
        assertEquals("Planted{progress=0.0, seed=Seed{growthRate=0.2}, " +
                "soil=Soil{isPlantable=false, isWatered=false}}", planted.toString());
    }

    @Test
    void testEquals() {
        Planted planted1 = new Planted(seed, soil);
        assertEquals(planted, planted1);
    }

    @Test
    void testNotEquals() {
        Grass grass = new Grass();
        assertNotEquals(planted, grass);
    }

    @Test
    void testEqualHashcode() {
        Planted planted1 = new Planted(seed, soil);
        assertEquals(planted.hashCode(), planted1.hashCode());
    }

    @Test
    void testNotEqualHashcode() {
        Grass grass = new Grass();
        assertNotEquals(planted.hashCode(), grass.hashCode());
    }
}