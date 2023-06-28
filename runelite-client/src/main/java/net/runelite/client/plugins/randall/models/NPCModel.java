package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.client.plugins.randall.interfaces.DataModelInterface;

import java.awt.*;

public class NPCModel implements DataModelInterface {

    private final NPC npc;

    public NPCModel(NPC npc) {
        this.npc = npc;
    }

    @Override
    public JsonObject toJson() {
        NPCComposition npcComposition = npc.getComposition();

        JsonObject data = new JsonObject();
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

        Polygon poly = npc.getCanvasTilePoly();
//        LocalPoint tileLocalLocation = tile.getLocalLocation();
//        Polygon poly = Perspective.getCanvasTilePoly(client, tileLocalLocation);
        if (poly != null) {
            int centerX = (int) poly.getBounds().getCenterX();
            int centerY = (int) poly.getBounds().getCenterY();

            data.addProperty("screen_x", centerX);
            data.addProperty("screen_y", centerY);
        }
        return data;
    }
}
