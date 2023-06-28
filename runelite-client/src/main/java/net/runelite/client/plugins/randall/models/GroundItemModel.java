package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.randall.interfaces.DataModelInterface;

import java.awt.*;

public class GroundItemModel implements DataModelInterface {

    private final Client client;
    private final Tile tile;
    private final TileItem tileItem;

    public GroundItemModel(Client client, Tile tile, TileItem tileItem) {
        this.client = client;
        this.tile = tile;
        this.tileItem = tileItem;
    }


    @Override
    public JsonObject toJson() {
        ItemComposition itemComposition = client.getItemDefinition(tileItem.getId());

        JsonObject data = new JsonObject();
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

            data.addProperty("screen_x", centerX);
            data.addProperty("screen_y", centerY);
        }
        return data;
    }
}
