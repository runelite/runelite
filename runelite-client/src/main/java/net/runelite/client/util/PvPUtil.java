package net.runelite.client.util;

import net.runelite.api.ItemComposition;
import java.util.TreeMap;
import java.util.Comparator;
import org.apache.commons.lang3.ArrayUtils;
import java.util.Objects;
import net.runelite.api.ItemContainer;
import net.runelite.api.Item;
import net.runelite.api.InventoryID;
import net.runelite.client.game.ItemManager;
import net.runelite.api.Player;
import net.runelite.api.Client;
import net.runelite.api.coords.WorldPoint;

public class PvPUtil
{
    public PvPUtil() {
        super();
    }
    
    public static int getWildernessLevelFrom(final WorldPoint point) {
        final int x = point.getX();
        final int y = point.getY();
        final int underLevel = (y - 9920) / 8 + 1;
        final int upperLevel = (y - 3520) / 8 + 1;
        return (y > 6400) ? underLevel : upperLevel;
    }
    
    public static boolean isAttackable(final Client c, final Player p) {
        return Math.abs(c.getLocalPlayer().getCombatLevel() - p.getCombatLevel()) < getWildernessLevelFrom(c.getLocalPlayer().getWorldLocation());
    }
    
    public static int calculateRisk(final Client client, final ItemManager itemManager) {
        if (client.getItemContainer(InventoryID.EQUIPMENT) == null) {
            return 0;
        }
        if (client.getItemContainer(InventoryID.INVENTORY).getItems() == null) {
            return 0;
        }
        final Item[] items = (Item[])ArrayUtils.<Item>addAll(((ItemContainer)Objects.<ItemContainer>requireNonNull(client.getItemContainer(InventoryID.EQUIPMENT))).getItems(), ((ItemContainer)Objects.<ItemContainer>requireNonNull(client.getItemContainer(InventoryID.INVENTORY))).getItems());
        final TreeMap<Integer, Item> priceMap = new TreeMap<Integer, Item>(Comparator.<Integer>comparingInt(Integer::intValue));
        int wealth = 0;
        for (final Item i : items) {
            int value = itemManager.getItemPrice(i.getId()) * i.getQuantity();
            final ItemComposition itemComposition = itemManager.getItemComposition(i.getId());
            if (!itemComposition.isTradeable() && value == 0) {
                value = itemComposition.getPrice() * i.getQuantity();
                priceMap.put(Integer.valueOf(value), i);
            }
            else {
                value = itemManager.getItemPrice(i.getId()) * i.getQuantity();
                if (i.getId() > 0 && value > 0) {
                    priceMap.put(Integer.valueOf(value), i);
                }
            }
            wealth += value;
        }
        return Integer.parseInt(StackFormatter.quantityToRSDecimalStack(priceMap.keySet().stream().mapToInt(Integer::intValue).sum()));
    }
}
