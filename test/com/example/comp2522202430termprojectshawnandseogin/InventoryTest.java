package com.example.comp2522202430termprojectshawnandseogin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    void setup() {
        inventory = new Inventory();
    }

    @Test
    void testInventoryConstructor() {
        inventory = new Inventory();

        assertEquals(new Hoe(), inventory.getItem(0));
        assertEquals(new WateringCan(), inventory.getItem(1));
    }

    @Test
    void testInventoryAddItem() {
        Item item = new Eggplant();
        inventory.addItem(item);

        assertEquals(item, inventory.getItem(2));
    }

    @Test
    void testInventoryAddSameItems() {
        Item item1 = new Eggplant();
        Item item2 = new Eggplant();

        inventory.addItem(item1);
        inventory.addItem(item2);

        assertEquals(2, inventory.getItem(2).getQuantity());
        assertNull(inventory.getItem(3));
    }

    @Test
    void testInventoryCheckItemWithQuantityAboveZero() {
        inventory.checkItem();

        assertEquals(new Hoe(), inventory.getItem(0));
        assertEquals(new WateringCan(), inventory.getItem(1));
    }

    @Test
    void testInventoryCheckItemWithQuantityZero() {
        inventory.getItem(1).subtractQuantity();
        inventory.checkItem();

        assertNull(inventory.getItem(1));
    }

    @Test
    void testInventoryCheckItemWithQuantityBelowZero() {
        inventory.getItem(1).subtractQuantity();
        inventory.getItem(1).subtractQuantity();
        inventory.checkItem();

        assertNull(inventory.getItem(1));
    }

    @Test
    void testInventoryRemoveItem() {
        inventory.removeItem(new Hoe());

        assertEquals(0, inventory.getItem(0).getQuantity());
    }

    @Test
    void testInventoryGetItem() {
        Item item1 = inventory.getItem(0);
        Item item2 = inventory.getItem(1);
        Item item3 = inventory.getItem(2);

        assertEquals(new Hoe(), item1);
        assertEquals(new WateringCan(), item2);
        assertNull(item3);
    }

    @Test
    void testInventoryGetItemIndexLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> inventory.getItem(-1));
    }

    @Test
    void testInventoryGetItemIndexMoreThanMaximumCapacity() {
        assertThrows(IllegalArgumentException.class, () -> inventory.getItem(Inventory.MAX_CAPACITY + 1));
    }

    @Test
    void testInventoryToString() {
        assertEquals(
                "Inventory{items=[" +
                        "Tool{name='Hoe', quantity=1, buyPrice=1000}" +
                        ", Tool{name='Watering Can', quantity=1, buyPrice=1000, remainingUses=0}" +
                        ", null" +
                        ", null" +
                        ", null" +
                        ", null" +
                        "]}",
                inventory.toString()
                );
    }

    @Test
    void testInventoryNotEquals() {
        Inventory newInventory = new Inventory();

        assertNotEquals(newInventory, inventory);
    }

    @Test
    void testInventoryHashCodeNotEquals() {
        Inventory newInventory = new Inventory();

        assertNotEquals(newInventory.hashCode(), inventory.hashCode());
    }
}
