package net.runelite.client.plugins.alfred.api.task;

import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.item.RSGroundItem;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;

import java.util.List;

public class ItemTasks {

    public void lootItems(String[] names, int radius) {
        RSPlayer player = Alfred.api.players().getLocalPlayer();

        for (String name : names) {
            List<RSGroundItem> items = Alfred.api.items().getItemsFromTiles(radius, name);
            if (items.isEmpty()) {
                continue;
            }

            if (Alfred.api.inventory().isFull()) {
                return;
            }


            for (RSGroundItem groundItem : items) {
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
}
