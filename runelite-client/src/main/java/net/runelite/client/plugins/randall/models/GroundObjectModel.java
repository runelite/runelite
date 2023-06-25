package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.Client;
import net.runelite.api.GroundObject;
import net.runelite.api.Perspective;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;

import java.awt.*;

public class GroundObjectModel implements DataModel {

    private final JsonObject data;

    public GroundObjectModel(Client client, Tile tile, GroundObject groundObject) {
        data = new JsonObject();
        data.addProperty("id", groundObject.getId());
        data.addProperty("x", groundObject.getWorldLocation().getX());
        data.addProperty("y", groundObject.getWorldLocation().getY());
//        data.addProperty("minimap_x", groundObject.getMinimapLocation().getX());
//        data.addProperty("minimap_y", groundObject.getMinimapLocation().getY());

        LocalPoint tileLocalLocation = tile.getLocalLocation();
        Polygon poly = Perspective.getCanvasTilePoly(client, tileLocalLocation);
        if (poly != null) {
            int centerX = (int) poly.getBounds().getCenterX();
            int centerY = (int) poly.getBounds().getCenterY();

            data.addProperty("screenX", centerX);
            data.addProperty("screenY", centerY);
        }
    }


    @Override
    public JsonObject toJson() {
        return data;
    }
}
