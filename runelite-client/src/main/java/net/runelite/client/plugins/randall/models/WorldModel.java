package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.client.plugins.randall.interfaces.DataModelInterface;
import net.runelite.http.api.worlds.World;

public class WorldModel implements DataModelInterface {

    private final World world;

    public WorldModel(World world) {
        this.world = world;
    }

    @Override
    public JsonObject toJson() {
        JsonObject data = new JsonObject();
        data.addProperty("id", world.getId());
        data.addProperty("activity", world.getActivity());
        data.addProperty("player_count", world.getPlayers());
        data.addProperty("region", world.getRegion().toString());
        return data;
    }
}
