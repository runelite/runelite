package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.Perspective;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;

import java.awt.*;

public class DecorativeObjectModel implements DataModel {

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
        JsonObject data = new JsonObject();
        data.addProperty("id", decorativeObject.getId());
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

            data.addProperty("screenX", centerX);
            data.addProperty("screenY", centerY);
        }
        return data;
    }
}
