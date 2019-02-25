package net.runelite.client.game;

import net.runelite.api.coords.LocalPoint;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemStackTest {


    @Test
    public void whenCreatingItemStack_thenItemStackCreated() {
        ItemStack stack = new ItemStack(1, 10, LocalPoint.fromScene(500, 500));
        Assert.assertNotNull(stack);
    }

    @Test
    public void givenQuantity10_whenCreatingItemStack_thenGetQuantityReturns10() {
        ItemStack stack = new ItemStack(1, 10, LocalPoint.fromScene(500, 500));
        assertEquals(stack.getQuantity(), 10);
    }

    @Test
    public void givenLocation_whenCreatingItemStack_thenGetLocationReturnsLocation() {
        ItemStack stack = new ItemStack(1, 10, LocalPoint.fromScene(500, 500));
        assertEquals(stack.getLocation(), LocalPoint.fromScene(500, 500));
    }

    @Test
    public void givenUnequalItemStacks_whenCreatingItemStack_thenEqualsReturnsFalse() {
        ItemStack stack = new ItemStack(1, 10, LocalPoint.fromScene(500, 500));
        ItemStack stack2 = new ItemStack(15, 10, LocalPoint.fromScene(500, 500));
        Assert.assertNotEquals(stack, stack2);
    }


}