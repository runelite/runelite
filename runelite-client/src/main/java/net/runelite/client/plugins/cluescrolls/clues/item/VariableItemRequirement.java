package net.runelite.client.plugins.cluescrolls.clues.item;

import net.runelite.api.Client;
import net.runelite.api.Item;

import static org.apache.commons.lang3.ArrayUtils.contains;

public class VariableItemRequirement implements ItemRequirement
{
    private String name;
    private int[] itemChoices;

    public VariableItemRequirement(String name, int[] itemChoices)
    {
        this.name = name;
        this.itemChoices = itemChoices;
    }

    @Override
    public boolean fulfilledBy(int itemId) {
        for (int item: itemChoices)
        {
            if (item == itemId)
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean fulfilledBy(Item[] items) {
        for (Item item: items)
        {
            if (contains(this.itemChoices, item.getId()))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getCollectiveName(Client client) {
        return null;
    }
}
