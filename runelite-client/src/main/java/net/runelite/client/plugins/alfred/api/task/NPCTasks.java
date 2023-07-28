package net.runelite.client.plugins.alfred.api.task;

import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.npc.RSNpc;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;

public class NPCTasks {

    public void attackNpc(String name) {
        RSPlayer player = Alfred.api.players().getLocalPlayer();
        RSNpc npc = Alfred.api.npcs().getNearestAttackableNpc(name, player.getWorldLocation());

        if (npc == null) {
            return;
        }

        if (npc.getWorldLocation().distanceTo(player.getWorldLocation()) >= 5) {
            Alfred.api.walk().walkTo(npc.getWorldLocation());
        }

        Alfred.api.camera().lookAt(npc.getWorldLocation());
        if (npc.attack()) {
            Alfred.sleepUntil(player::isAnimating, 100, 2000);
            Alfred.setStatus("Waiting to finish attacking");
            Alfred.sleepUntil(() -> !player.isMoving() && player.isIdle(), 200, 1000 * 10);
            Alfred.sleepUntil(npc::isDead, 200, 1000 * 90);
            Alfred.sleep(3000, 3500);
        }
    }
}
