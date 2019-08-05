package net.runelite.client.plugins.banktags;

import net.runelite.api.Item;

public class BankItemCache {
    private static Item[] bankItems;


    public static int getItemQuantity(int itemId)
    {
        for (Item item:bankItems) {
            if(item.getId()==itemId)
            {
                return item.getQuantity();
            }
        }
        return 0;
    }

    public static void setBankItems(Item[] items) {
        bankItems = items;
    }
}
