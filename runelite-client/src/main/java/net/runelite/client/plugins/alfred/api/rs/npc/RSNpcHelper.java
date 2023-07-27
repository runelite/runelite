package net.runelite.client.plugins.alfred.api.rs.npc;

import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RSNpcHelper {

    public RSNpcHelper() {
    }

    private List<RSNpc> internalGetNpcs() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            List<RSNpc> npcList = new ArrayList<>();

            for (NPC npc : Alfred.getClient().getNpcs()) {
                npcList.add(new RSNpc(npc));
            }

            return npcList;
        });
    }

    public List<RSNpc> getNpcs() {
        return internalGetNpcs();
    }

    public List<RSNpc> getNpcs(String name) {
        return internalGetNpcs().stream().filter(npc -> npc.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public List<RSNpc> getNpcs(int id) {
        return internalGetNpcs().stream().filter(npc -> npc.getId() == id).collect(Collectors.toList());
    }

    public List<RSNpc> getAttackableNpcs() {
        return internalGetNpcs().stream().filter(npc -> !npc.isInteracting() && !npc.isDead()).collect(Collectors.toList());
    }

    public List<RSNpc> getAttackableNpcs(String name) {
        return internalGetNpcs().stream().filter(npc -> !npc.isInteracting() && !npc.isDead() && npc.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public RSNpc getNearestAttackableNpc(String name, WorldPoint worldPoint) {
        return getAttackableNpcs(name).stream().min(Comparator.comparingInt(c -> c.getWorldLocation().distanceTo(worldPoint))).orElse(null);
    }
}
