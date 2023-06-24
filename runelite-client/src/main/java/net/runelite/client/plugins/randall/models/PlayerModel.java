package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.Client;
import net.runelite.api.Player;

public class PlayerModel implements DataModel {

    private final JsonObject data;

    public PlayerModel(Client client, Player player) {
        data = new JsonObject();
        data.addProperty("id", player.getId());
        data.addProperty("name", player.getName());
        data.addProperty("plane", player.getWorldLocation().getPlane());
        data.addProperty("x", player.getWorldLocation().getX());
        data.addProperty("y", player.getWorldLocation().getY());
        data.addProperty("energy", client.getEnergy());
        data.addProperty("health_ratio", player.getHealthRatio());
        data.addProperty("total_level", client.getTotalLevel());
        data.addProperty("combat_level", player.getCombatLevel());
        data.addProperty("is_dead", player.isDead());
        data.addProperty("is_interacting", player.isInteracting());
    }

    @Override
    public JsonObject toJson() {
        return data;
    }
}
