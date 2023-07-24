package net.runelite.client.plugins.alfred.api.rs.walk;

import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;
import java.util.Arrays;
import java.util.Set;


public class RSLoadedWalkableTile extends RSTile {

    private final int worldX;
    private final int worldY;
    private final int plane;
    private final boolean isOperable;
    private final Set<WorldMovementFlag> worldMovementFlags;

    public RSLoadedWalkableTile(int worldX, int worldY, int plane, boolean isOperable, Set<WorldMovementFlag> worldMovementFlags) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.plane = plane;
        this.isOperable = isOperable;
        this.worldMovementFlags = worldMovementFlags;
    }

    @Override
    public WorldPoint getWorldLocation() {
        return new WorldPoint(worldX, worldY, plane);
    }

    @Override
    public boolean isOperable() {
        return isOperable;
    }

    @Override
    public Polygon getCanvasPolygon() {
        return null;
    }

    @Override
    public boolean getBlocked() {

        Boolean[] blocked = new Boolean[]{
                worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FULL),
                worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FLOOR),
                worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FLOOR_DECORATION),
                worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_OBJECT)
        };

        return Arrays.asList(blocked).contains(true);
    }

    @Override
    public boolean isWalkable(RSTile otherNode) {
        int thisX = getWorldLocation().getX();
        int thisY = getWorldLocation().getY();

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

        if (otherX == thisX - 1 && otherY == thisY + 1){
            if (worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH) || worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST)) {
                return false;
            }
        }

        if (otherX == thisX + 1 && otherY == thisY + 1){
            if (worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH) || worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST)) {
                return false;
            }
        }

        if (otherX == thisX - 1 && otherY == thisY - 1){
            if (worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH) || worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST)) {
                return false;
            }
        }

        if (otherX == thisX + 1 && otherY == thisY - 1){
            if (worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH) || worldMovementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST)) {
                return false;
            }
        }

        return true;
    }
}
