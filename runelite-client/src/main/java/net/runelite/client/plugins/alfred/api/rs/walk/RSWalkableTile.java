package net.runelite.client.plugins.alfred.api.rs.walk;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Perspective;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class RSWalkableTile {

    private final Tile tile;

    @Setter
    @Getter
    private int gCost;
    @Setter
    @Getter
    private int hCost;

    @Getter
    @Setter
    private RSWalkableTile parent;

    public RSWalkableTile(Tile tile) {
        this.tile = tile;
    }

    public boolean isOperable() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            if (tile.getWallObject() != null) {
                return RSWalkHelper.getOperableObjectIds().contains(tile.getWallObject().getId());
            }
            return false;
        });
    }

    public WorldPoint getWorldLocation() {
        return tile.getWorldLocation();
    }

    public Polygon getCanvasPolygon() {
        return Perspective.getCanvasTilePoly(Alfred.getClient(), tile.getLocalLocation());
    }

    public List<RSWalkableTile> getNeighbors(List<RSWalkableTile> allWalkableTiles) {
        List<RSWalkableTile> neighbors = new ArrayList<>();

//        for (int x = -1; x < 2; x++) {
//            for (int y = -1; y < 2; y++) {
//                if (x == 0 && y == 0) {
//                    continue;
//                }
//
//                int checkX = tile.getWorldLocation().getX() + x;
//                int checkY = tile.getWorldLocation().getY() + y;
//
//                for (RSWalkableTile walkableTile : allWalkableTiles) {
//                    if (walkableTile.getWorldLocation().getX() == checkX && walkableTile.getWorldLocation().getY() == checkY) {
//                        neighbors.add(walkableTile);
//                    }
//                }
//            }
//        }

        List<Point> points = new ArrayList<>();
        points.add(new Point(-1, 0));
        points.add(new Point(1, 0));
        points.add(new Point(0, -1));
        points.add(new Point(0, 1));

        for (Point point : points) {
            int checkX = tile.getWorldLocation().getX() + point.x;
            int checkY = tile.getWorldLocation().getY() + point.y;

            for (RSWalkableTile walkableTile : allWalkableTiles) {
                if (walkableTile.getWorldLocation().getX() == checkX && walkableTile.getWorldLocation().getY() == checkY) {
                    neighbors.add(walkableTile);
                }
            }
        }


        return neighbors;
    }

    public int getFCost() {
        return gCost + hCost;
    }

    public boolean isWalkable(RSWalkableTile otherNode) {
//        # North y + 1
//        # South y - 1
//        # West x - 1
//        # East x + 1

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
