package net.runelite.client.plugins.alfred.api.task;

import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.objects.RSObject;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;

import java.util.Comparator;
import java.util.List;

public class ObjectTasks {

    public void mineOre(String name) {
        RSPlayer player = Alfred.api.players().getLocalPlayer();
        List<RSObject> objects = Alfred.api.objects().getObjectsFromTiles(name);
        if (objects.isEmpty()) {
            return;
        }

        RSObject nearestObject = objects.stream()
                .min(Comparator.comparingInt(rsGroundItem -> rsGroundItem.getWorldLocation().distanceTo(player.getWorldLocation())))
                .orElse(null);

        if (nearestObject.getWorldLocation().distanceTo(player.getWorldLocation()) >= 5) {
            Alfred.api.walk().walkTo(nearestObject.getWorldLocation());
        }

        Alfred.api.camera().lookAt(nearestObject.getWorldLocation());
        if (nearestObject.clickAction("mine")) {
            Alfred.sleepUntil(player::isAnimating, 100, 1000 * 10);
            Alfred.setStatus("Waiting to finish mining");
            Alfred.sleepUntil(() -> !player.isMoving() && player.isIdle() && !player.isAnimating(), 200, 1000 * 90);
        }
    }
}
