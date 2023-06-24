package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;

public class NPCModel implements DataModel {

    private final JsonObject data;

    public NPCModel(NPC npc) {
        NPCComposition npcComposition = npc.getComposition();

        data = new JsonObject();
        data.addProperty("id", npc.getId());
        data.addProperty("name", npc.getName());
        data.addProperty("plane", npc.getWorldLocation().getPlane());
        data.addProperty("x", npc.getWorldLocation().getX());
        data.addProperty("y", npc.getWorldLocation().getY());
        data.addProperty("health_ratio", npc.getHealthRatio());
        data.addProperty("combat_level", npc.getCombatLevel());
        data.addProperty("is_clickable", npcComposition.isClickable());
        data.addProperty("is_follower", npcComposition.isFollower());
        data.addProperty("is_interactible", npcComposition.isInteractible());
        data.addProperty("is_minimap_visible", npcComposition.isMinimapVisible());
        data.addProperty("is_visible", npcComposition.isVisible());
    }

    @Override
    public JsonObject toJson() {
        return data;
    }
}
