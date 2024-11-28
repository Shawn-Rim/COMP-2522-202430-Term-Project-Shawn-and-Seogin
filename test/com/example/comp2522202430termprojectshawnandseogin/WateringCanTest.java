package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class WateringCanTest {
    WateringCan wateringCan = new WateringCan();

    @Test
    void testInitialRemainingUses() {
        assertEquals(3, wateringCan.getRemainingUses());
    }

    @Test
    void testUseTool() {
        Soil soil = new Soil(3, 3, 50);
        soil.togglePlantable();
        wateringCan.useTool(soil);
        wateringCan.useTool(soil);
        wateringCan.useTool(soil);
        assertEquals(0, wateringCan.getRemainingUses());
    }

    @Test
    void testFillWater() {
        Soil soil = new Soil(3, 3, 50);
        soil.togglePlantable();
        wateringCan.useTool(soil);
        wateringCan.useTool(soil);
        wateringCan.useTool(soil);
        wateringCan.fillWater();
        assertEquals(3, wateringCan.getRemainingUses());
    }

    @Test
    void testGetBuyPrice() {
        assertEquals(1000, wateringCan.getBuyPrice().intValue());
    }

    @Test
    void testGetName() {
        assertEquals("Watering Can", wateringCan.getName());
    }

    @Test
    void testGetQuantity() {
        assertEquals(1, wateringCan.getQuantity());
    }

    @Test
    void testSubtractQuantity() {
        wateringCan.subtractQuantity();
        assertEquals(0, wateringCan.getQuantity());
    }

    @Test
    void testToString() {
        assertEquals("WateringCan{remainingUses=3}", wateringCan.toString());
    }

    @Test
    void testEquals() {
        WateringCan wateringCan1 = new WateringCan();
        assertEquals(wateringCan, wateringCan1);
    }

    @Test
    void testNonEquals() {
        Hoe hoe = new Hoe();
        assertNotEquals(wateringCan, hoe);
    }

    @Test
    void testHashEquals() {
        WateringCan wateringCan1 = new WateringCan();
        assertEquals(wateringCan.hashCode(), wateringCan1.hashCode());
    }

    @Test
    void testNonHashEquals() {
        Hoe hoe = new Hoe();
        assertNotEquals(wateringCan.hashCode(), hoe.hashCode());
    }
  
}