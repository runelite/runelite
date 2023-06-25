package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;

import java.awt.*;

public class GroundItemModel implements DataModel {

    private final JsonObject data;

    public GroundItemModel(Client client, Tile tile, TileItem tileItem) {
        data = new JsonObject();
        ItemComposition itemComposition = client.getItemDefinition(tileItem.getId());

        data.addProperty("id", tileItem.getId());
        data.addProperty("name", itemComposition.getName());
        data.addProperty("members_name", itemComposition.getMembersName());
        data.addProperty("quantity", tileItem.getQuantity());
        data.addProperty("plane", tile.getWorldLocation().getPlane());
        data.addProperty("x", tile.getWorldLocation().getX());
        data.addProperty("y", tile.getWorldLocation().getY());

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
