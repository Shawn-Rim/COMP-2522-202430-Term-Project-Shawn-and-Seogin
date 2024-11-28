package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class NPCTest {
    NPC npc = new NPC();


    @Test
    void testSellCrop() {
        Crop eggplant = new Eggplant();
        Player player = new Player(3, 3, 50);
        npc.interact(eggplant);
        assertEquals("-9000", player.getMoney());
    }

    @Test
    void testBuySeed() {
        Item item = new Hoe();
        Player player = new Player(3, 3, 50);
        npc.interact(item);
        assertEquals("-10500", player.getMoney());
    }
  
}