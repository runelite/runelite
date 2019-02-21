package net.runelite.client.plugins.maxhit.equipment;

import net.runelite.api.Client;
import net.runelite.api.Item;

public class EquipmentHelper {

    public static boolean wearsItemSet(Client client, Item[] equipedItems, EquipmentItemset itemSet) {
        return itemSet.getItems().stream().allMatch(item -> wearsItem(client, equipedItems, item.getEquipmentSlot(), item.getItem()));
    }

    public static boolean wearsItem(Client client, Item[] equipedItems, EquipmentSlot slot, String item){
        return client.getItemDefinition(equipedItems[slot.getId()].getId()).getName().toLowerCase().contains(item.toLowerCase());
    }

}
