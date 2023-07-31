package net.runelite.client.plugins.alfred.api.task;

import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.item.RSGroundItem;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ItemTasks {


    public void lootItems(String[] names, int radius) {
        RSPlayer player = Alfred.api.players().getLocalPlayer();

        List<RSGroundItem> allItems = new ArrayList<>();

        for (String name : names) {
            List<RSGroundItem> items = Alfred.api.items().getItemsFromTiles(radius, name);
            allItems.addAll(items);
        }

        if (allItems.isEmpty()) {
            return;
        }

        List<RSGroundItem> sortedItems = allItems.stream()
                .sorted(Comparator.comparingInt(rsGroundItem -> rsGroundItem.getWorldLocation().distanceTo(player.getWorldLocation())))
                .collect(Collectors.toList());

        for (RSGroundItem groundItem : sortedItems) {
            if (Alfred.api.inventory().isFull()) {
                return;
            }

            boolean standingOnItem = player.getWorldLocation().equals(groundItem.getWorldLocation());
            if (!standingOnItem) {
                Alfred.api.camera().lookAt(groundItem.getWorldLocation());
            }

            if (groundItem.clickAction("take")) {
                int currentInventoryCount = Alfred.api.inventory().count();

                if (!standingOnItem) {
                    Alfred.sleepUntil(player::isMoving, 50, 2000);
                }
                Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 30);
                Alfred.sleepUntil(() -> !Alfred.api.items().isItemOnGround(groundItem.getId(), groundItem.getWorldLocation()), 200, 1000 * 5);
                Alfred.sleepUntil(() -> Alfred.api.inventory().count() == currentInventoryCount + 1, 200, 1000 * 5);
            }
        }
    }
}
