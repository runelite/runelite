package net.runelite.client.plugins.alfred.scripts.chickenkiller;

import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.item.RSGroundItem;
import net.runelite.client.plugins.alfred.api.rs.npc.RSNpc;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChickenKillerThread extends Thread {

    @Override
    public void run() {
        Alfred.api.account().login();
        Alfred.sleep(5000);
        RSPlayer player = Alfred.api.players().getLocalPlayer();

        if (!Alfred.api.combat().isPunchSelected()) {
            Alfred.setStatus("Setting attack to punch");
            Alfred.api.combat().clickPunch();
            Alfred.api.tabs().clickInventoryTab();
        }

        Alfred.setStatus("Dropping any eggs");
        Alfred.api.inventory().dropAll("egg");

        Alfred.setStatus("Dropping any raw chicken");
        Alfred.api.inventory().dropAll("raw chicken");

        Alfred.setStatus("Dropping any bones");
        Alfred.api.inventory().interactAll("bones", "bury");

        while (true) {
            List<RSNpc> chickens = Alfred.api.npcs().getAttackableNpcs("chicken").stream().sorted(Comparator.comparingInt(c -> c.getWorldLocation().distanceTo(player.getWorldLocation()))).collect(Collectors.toList());

            RSNpc chicken = chickens.stream().findFirst().orElse(null);

            if (chicken != null) {

                Alfred.setStatus("Looking at chicken");
                Alfred.api.camera().lookAt(chicken.getWorldLocation());
                Alfred.sleep(100);

//                if (Alfred.api.screen().isPointOnScreen(chicken.getWorldLocation())) {
                Alfred.setStatus("Attacking chicken");
                chicken.attack();
                Alfred.sleep(500);

                Alfred.setStatus("Waiting until done attacking chicken");
                Alfred.sleepUntil(() -> !player.isWalking() && !player.isInteracting(), 50, 1000 * 30);
//                }
            }

            Alfred.setStatus("Checking for feathers");
            List<RSGroundItem> items = Alfred.api.items().getItemsFromTiles(15, "feather");

            for (RSGroundItem rsGroundItem : items) {
                Alfred.api.camera().lookAt(rsGroundItem.getWorldLocation());
                Alfred.sleep(100, 150);
                Alfred.setStatus("Taking feather");
                rsGroundItem.clickAction("take");
                Alfred.sleep(500);
                Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting(), 50, 1000 * 30);
                Alfred.sleep(1000);
            }

            Alfred.sleep(500);
        }
    }
}
