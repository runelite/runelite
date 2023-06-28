package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.randall.interfaces.DataModelInterface;

import java.awt.*;

public class GroundObjectModel implements DataModelInterface {

    private final Client client;
    private final Tile tile;
    private final GroundObject groundObject;

    public GroundObjectModel(Client client, Tile tile, GroundObject groundObject) {
        this.client = client;
        this.tile = tile;
        this.groundObject = groundObject;
    }


    @Override
    public JsonObject toJson() {
        ObjectComposition objectComposition = client.getObjectDefinition(groundObject.getId());

        JsonObject data = new JsonObject();
        data.addProperty("id", groundObject.getId());
        data.addProperty("name", objectComposition.getName());
        data.addProperty("x", groundObject.getWorldLocation().getX());
        data.addProperty("y", groundObject.getWorldLocation().getY());
//        data.addProperty("minimap_x", groundObject.getMinimapLocation().getX());
//        data.addProperty("minimap_y", groundObject.getMinimapLocation().getY());

        LocalPoint tileLocalLocation = tile.getLocalLocation();
        Polygon poly = Perspective.getCanvasTilePoly(client, tileLocalLocation);
        if (poly != null) {
            int centerX = (int) poly.getBounds().getCenterX();
            int centerY = (int) poly.getBounds().getCenterY();

            data.addProperty("screen_x", centerX);
            data.addProperty("screen_y", centerY);
        }

        JsonArray actions = new JsonArray();
        for (String action : objectComposition.getActions()) {
            if (action != null) {
                actions.add(action);
            }
        }

        data.add("actions", actions);
        return data;
    }
}
