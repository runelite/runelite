package net.runelite.api.events;

import lombok.Data;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;

@Data
public class ContainerChanged
{
    private ItemContainer container;
    private int idx;
    private Item item;
    private Item previousItem;
}
