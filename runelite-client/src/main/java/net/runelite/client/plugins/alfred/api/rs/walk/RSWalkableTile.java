package net.runelite.client.plugins.alfred.api.rs.walk;

import lombok.Getter;
import net.runelite.api.Perspective;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;
import java.util.Set;


public class RSWalkableTile extends RSTile {

    @Getter
    private final Tile tile;

    public RSWalkableTile(Tile tile) {
        this.tile = tile;
    }

    @Override
    public WorldPoint getWorldLocation() {
        return tile.getWorldLocation();
    }

    @Override
    public boolean isOperable() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            if (tile.getWallObject() != null) {
                return RSWalkHelper.getOperableObjectIds().contains(tile.getWallObject().getId());
            }
            return false;
        });
    }

    @Override
    public Polygon getCanvasPolygon() {
        return Perspective.getCanvasTilePoly(Alfred.getClient(), tile.getLocalLocation());
    }

    @Override
    public boolean isWalkable(RSTile otherNode) {
        Set<WorldMovementFlag> worldMovementFlags = Alfred.api.walk().getMovementFlagsForTile(tile);
        int thisX = tile.getWorldLocation().getX();
        int thisY = tile.getWorldLocation().getY();

        int otherX = otherNode.getWorldLocation().getX();
        int otherY = otherNode.getWorldLocation().getY();

        if (otherX == thisX) {
            if (otherY == thisY + 1) {
                if (worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH)) {
                    return false;
                }
            }

            if (otherY == thisY - 1) {
                if (worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH)) {
                    return false;
                }
            }
        }

        if (otherY == thisY) {
            if (otherX == thisX + 1) {
                if (worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST)) {
                    return false;
                }

            }

            if (otherX == thisX - 1) {
                if (worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST)) {
                    return false;
                }
            }
        }

        return true;
    }
}
