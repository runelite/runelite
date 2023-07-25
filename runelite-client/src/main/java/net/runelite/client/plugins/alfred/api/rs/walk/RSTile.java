package net.runelite.client.plugins.alfred.api.rs.walk;

import lombok.Getter;
import net.runelite.api.Perspective;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;

public class RSTile {
    @Getter
    private final Tile tile;

    public RSTile(Tile tile) {
        this.tile = tile;
    }
//    public int heapCompare(RSTile item) {
//        int compare = Integer.compare(getFCost(), item.getFCost());
//        if (compare == 0) {
//            compare = Integer.compare(getHCost(), item.getHCost());
//        }
//        return -compare;
//    }

    public WorldPoint getWorldLocation() {
        return tile.getWorldLocation();
    }

    public boolean isOperable() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            if (tile.getWallObject() != null) {
                return RSWalkHelper.getOperableObjectIds().contains(tile.getWallObject().getId());
            }
            return false;
        });
    }

    public Polygon getCanvasPolygon() {
        return Perspective.getCanvasTilePoly(Alfred.getClient(), tile.getLocalLocation());
    }

}
