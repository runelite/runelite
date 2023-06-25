package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Perspective;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;

import java.awt.*;

public class GameObjectModel implements DataModel {

    private final JsonObject data;

    public GameObjectModel(Client client, Tile tile, GameObject gameObject) {
        data = new JsonObject();
        data.addProperty("id", gameObject.getId());
        data.addProperty("x", gameObject.getWorldLocation().getX());
        data.addProperty("y", gameObject.getWorldLocation().getY());
        data.addProperty("plane", gameObject.getPlane());
        data.addProperty("minimap_x", gameObject.getMinimapLocation().getX());
        data.addProperty("minimap_y", gameObject.getMinimapLocation().getY());

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
