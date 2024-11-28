package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterWellTest {
    WateringCan wateringCan = new WateringCan();

     @Test
    void testInteract() {
         Soil soil = new Soil(3, 3, 50);
         soil.togglePlantable();
         wateringCan.useTool(soil);
         wateringCan.useTool(soil);
         wateringCan.useTool(soil);
         WaterWell waterWell = new WaterWell();
         waterWell.interact(wateringCan);
         assertEquals(3, wateringCan.getRemainingUses());
     }
}