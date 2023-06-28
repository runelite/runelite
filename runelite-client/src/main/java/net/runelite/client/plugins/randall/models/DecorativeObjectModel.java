package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.randall.interfaces.DataModelInterface;

import java.awt.*;

public class DecorativeObjectModel implements DataModelInterface {

    private final Client client;
    private final Tile tile;
    private final DecorativeObject decorativeObject;

    public DecorativeObjectModel(Client client, Tile tile, DecorativeObject decorativeObject) {
        this.client = client;
        this.tile = tile;
        this.decorativeObject = decorativeObject;
    }


    @Override
    public JsonObject toJson() {
        ObjectComposition objectComposition = client.getObjectDefinition(decorativeObject.getId());

        JsonObject data = new JsonObject();
        data.addProperty("id", decorativeObject.getId());
        data.addProperty("name", objectComposition.getName());
        data.addProperty("plane", decorativeObject.getPlane());
        data.addProperty("x", decorativeObject.getWorldLocation().getX());
        data.addProperty("y", decorativeObject.getWorldLocation().getY());
//        data.addProperty("minimap_x", decorativeObject.getMinimapLocation().getX());
//        data.addProperty("minimap_y", decorativeObject.getMinimapLocation().getY());

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
