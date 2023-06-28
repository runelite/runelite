package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.randall.interfaces.DataModelInterface;

import java.awt.*;

public class WallObjectModel implements DataModelInterface {

    private final Client client;
    private final Tile tile;
    private final WallObject wallObject;

    public WallObjectModel(Client client, Tile tile, WallObject wallObject) {
        this.client = client;
        this.tile = tile;
        this.wallObject = wallObject;
    }


    @Override
    public JsonObject toJson() {
        ObjectComposition objectComposition = client.getObjectDefinition(wallObject.getId());

        JsonObject data = new JsonObject();
        data.addProperty("id", wallObject.getId());
        data.addProperty("name", objectComposition.getName());
        data.addProperty("x", wallObject.getWorldLocation().getX());
        data.addProperty("y", wallObject.getWorldLocation().getY());
//        data.addProperty("minimap_x", wallObject.getMinimapLocation().getX());
//        data.addProperty("minimap_y", wallObject.getMinimapLocation().getY());

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
