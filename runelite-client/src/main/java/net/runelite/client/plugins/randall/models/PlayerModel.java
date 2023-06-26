package net.runelite.client.plugins.randall.models;

import com.google.gson.JsonObject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.OverlayUtil;

import java.awt.*;

public class PlayerModel implements DataModel {

    private final Client client;
    private final Player player;
    public int MAX_DISTANCE = 1200;


    public PlayerModel(Client client, Player player) {
        this.client = client;
        this.player = player;
    }

    public void render(Graphics2D graphics) {
        Color insideColor = new Color(30, 210, 30, 100);
        Color borderColor = new Color(30, 210, 30, 255);
//        String text = player.getName() + " (A: " + player.getAnimation() + ") (P: " + player.getPoseAnimation() + ") (G: " + player.getGraphic() + ")";
//        OverlayUtil.renderActorOverlay(graphics, player, text, Color.BLUE);
        LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();
//        Point mousePosition = client.getMouseCanvasPosition();


//        Tile tile = player.getTile();
//        if (tile.getPlane() == client.getPlane() && player.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE) {
        if (player.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE) {
            Polygon polygon = player.getCanvasTilePoly();
            if (polygon != null) {
                OverlayUtil.renderPolygon(graphics, polygon, insideColor, insideColor, graphics.getStroke());
            }
            return;
            // This assumes that the obstacle is not clickable.
//            if (Obstacles.TRAP_OBSTACLE_IDS.contains(object.getId())) {
//                Polygon polygon = object.getCanvasTilePoly();
//                if (polygon != null) {
//                    OverlayUtil.renderPolygon(graphics, polygon, config.getTrapColor());
//                }
//                return;
//            }
//            Shape objectClickbox = object.getClickbox();
//            if (objectClickbox != null) {
//                AgilityShortcut agilityShortcut = obstacle.getShortcut();
//                Color configColor = agilityShortcut == null || agilityShortcut.getLevel() <= plugin.getAgilityLevel() ? config.getOverlayColor() : SHORTCUT_HIGH_LEVEL_COLOR;
//                if (config.highlightMarks() && !marksOfGrace.isEmpty()) {
//                    configColor = config.getMarkColor();
//                }
//
//                if (Obstacles.PORTAL_OBSTACLE_IDS.contains(object.getId())) {
//                    if (config.highlightPortals()) {
//                        configColor = config.getPortalsColor();
//                    } else {
//                        return;
//                    }
//                }
//
//                if (objectClickbox.contains(mousePosition.getX(), mousePosition.getY())) {
//                    graphics.setColor(configColor.darker());
//                } else {
//                    graphics.setColor(configColor);
//                }
//
//                graphics.draw(objectClickbox);
//                graphics.setColor(ColorUtil.colorWithAlpha(configColor, configColor.getAlpha() / 5));
//                graphics.fill(objectClickbox);
//            }
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

            data.addProperty("screenX", centerX);
            data.addProperty("screenY", centerY);
        }

        return data;
    }
}
