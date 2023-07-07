package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.MessageNode;
import net.runelite.client.plugins.randall.interfaces.DataModelInterface;

public class MessageModel implements DataModelInterface {

    private final MessageNode messageNode;

    public MessageModel(MessageNode messageNode) {
        this.messageNode = messageNode;
    }

    @Override
    public JsonObject toJson() {
        JsonObject data = new JsonObject();
        data.addProperty("id", messageNode.getId());
        data.addProperty("name", messageNode.getName());
        data.addProperty("message", messageNode.getValue());
        return data;
    }
}
