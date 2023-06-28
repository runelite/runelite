package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.randall.interfaces.DataModelInterface;

import java.awt.*;

public class PlayerModel implements DataModelInterface {

    private final Client client;
    private final Player player;
    public int MAX_DISTANCE = 1200;


    public PlayerModel(Client client, Player player) {
        this.client = client;
        this.player = player;
    }

    public void render(Graphics2D graphics) {
        Color insideColor = new Color(30, 210, 30, 100);
        Color redColor = new Color(210, 30, 30, 255);
        Color redSmallColor = new Color(210, 30, 30, 100);

        LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();
        if (player.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE) {
//            Polygon polygon = player.getCanvasTilePoly();
//            if (polygon != null) {
//                OverlayUtil.renderPolygon(graphics, polygon, insideColor, insideColor, graphics.getStroke());
//            }

            Shape shape = player.getConvexHull();
            if (shape != null) {
                Color originalColor = graphics.getColor();
                graphics.setColor(redColor);
                graphics.draw(shape);
                graphics.setColor(redSmallColor);
                graphics.fill(shape);
                graphics.setColor(originalColor);
            }
        }
    }

    @Override
    public JsonObject toJson() {
        JsonObject data = new JsonObject();
        data.addProperty("id", player.getId());
        data.addProperty("name", player.getName());
        data.addProperty("plane", player.getWorldLocation().getPlane());
        data.addProperty("x", player.getWorldLocation().getX());
        data.addProperty("y", player.getWorldLocation().getY());
        data.addProperty("energy", client.getEnergy());
        data.addProperty("health_ratio", player.getHealthRatio());
        data.addProperty("total_level", client.getTotalLevel());
        data.addProperty("combat_level", player.getCombatLevel());
        data.addProperty("is_dead", player.isDead());
        data.addProperty("is_interacting", player.isInteracting());

        Polygon poly = player.getCanvasTilePoly();
//        LocalPoint tileLocalLocation = tile.getLocalLocation();
//        Polygon poly = Perspective.getCanvasTilePoly(client, tileLocalLocation);
        if (poly != null) {
            int centerX = (int) poly.getBounds().getCenterX();
            int centerY = (int) poly.getBounds().getCenterY();

            data.addProperty("screen_x", centerX);
            data.addProperty("screen_y", centerY);
        }

        return data;
    }
}
