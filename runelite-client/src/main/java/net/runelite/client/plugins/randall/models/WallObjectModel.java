package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;

import java.awt.*;

public class WallObjectModel implements DataModel {

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
        JsonObject data = new JsonObject();
        data.addProperty("id", wallObject.getId());
        data.addProperty("x", wallObject.getWorldLocation().getX());
        data.addProperty("y", wallObject.getWorldLocation().getY());
//        data.addProperty("minimap_x", wallObject.getMinimapLocation().getX());
//        data.addProperty("minimap_y", wallObject.getMinimapLocation().getY());

        LocalPoint tileLocalLocation = tile.getLocalLocation();
        Polygon poly = Perspective.getCanvasTilePoly(client, tileLocalLocation);
        if (poly != null) {
            int centerX = (int) poly.getBounds().getCenterX();
            int centerY = (int) poly.getBounds().getCenterY();

            data.addProperty("screenX", centerX);
            data.addProperty("screenY", centerY);
        }
        return data;
    }
}
