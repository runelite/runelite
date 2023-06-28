package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.Client;
import net.runelite.client.plugins.randall.interfaces.DataModelInterface;

public class GameModel implements DataModelInterface {

    private final Client client;

    public GameModel(Client client) {
        this.client = client;
    }

    @Override
    public JsonObject toJson() {
        JsonObject data = new JsonObject();
        data.addProperty("state", client.getGameState().toString());
        data.addProperty("login_index", client.getLoginIndex());
        data.addProperty("idle_timeout", client.getIdleTimeout());
        return null;
    }
}
