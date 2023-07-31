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
                .min(Comparator.comparingInt(gameObject -> gameObject.getWorldLocation().distanceTo(player.getWorldLocation())))
                .orElse(null);

        if (nearestObject.getWorldLocation().distanceTo(player.getWorldLocation()) >= 5) {
            Alfred.api.walk().walkTo(nearestObject.getWorldLocation());
        }

//        if (!Alfred.api.screen().isPointOnScreen(nearestObject.getWorldLocation())) {
        Alfred.api.camera().lookAt(nearestObject.getWorldLocation());
//        }

//        if (nearestObject.clickAction("mine")) {
        if (nearestObject.leftClick()) {
            Alfred.sleepUntil(player::isAnimating, 100, 1000 * 10);
            Alfred.setStatus("Waiting to finish mining");
            Alfred.sleepUntil(() -> !player.isMoving() && player.isIdle() && !player.isAnimating(), 100, 1000 * 90);
        }
    }

    public void chopTree(String name) {
        RSPlayer player = Alfred.api.players().getLocalPlayer();
        List<RSObject> objects = Alfred.api.objects().getObjectsFromTiles(name);
        if (objects.isEmpty()) {
            return;
        }

        RSObject nearestObject = objects.stream()
                .min(Comparator.comparingInt(gameObject -> gameObject.getWorldLocation().distanceTo(player.getWorldLocation())))
                .orElse(null);

        if (nearestObject.getWorldLocation().distanceTo(player.getWorldLocation()) >= 5) {
            Alfred.api.walk().walkTo(nearestObject.getWorldLocation());
        }

//        if (!Alfred.api.screen().isPointOnScreen(nearestObject.getWorldLocation())) {
        Alfred.api.camera().lookAt(nearestObject.getWorldLocation());
//        }

        if (nearestObject.clickAction("chop down")) {
//        if (nearestObject.leftClick()) {
            Alfred.sleepUntil(player::isAnimating, 100, 1000 * 10);
            Alfred.setStatus("Waiting to finish chopping down tree");
            Alfred.sleepUntil(() -> !player.isMoving() && player.isIdle() && !player.isAnimating(), 100, 1000 * 90);
        }
    }
}
