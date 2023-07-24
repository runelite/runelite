package net.runelite.client.plugins.alfred.api.rs.walk.astar;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;

public class AStarNode {

    @Getter
    @Setter
    private Tile tile;
    @Setter
    private WorldPoint worldLocation;
    @Getter
    @Setter
    private int gCost;
    @Getter
    @Setter
    private int hCost;
    @Getter
    @Setter
    private AStarNode parent;
    @Getter
    @Setter
    private int penalty;
    @Getter
    @Setter
    private Boolean isOperable;
    @Getter
    @Setter
    private Boolean blocked;
    @Getter
    @Setter
    private Boolean blockedMovementNorth;
    @Getter
    @Setter
    private Boolean blockedMovementSouth;
    @Getter
    @Setter
    private Boolean blockedMovementEast;
    @Getter
    @Setter
    private Boolean blockedMovementWest;
    @Getter
    @Setter
    private Boolean blockedMovementNorthEast;
    @Getter
    @Setter
    private Boolean blockedMovementNorthWest;
    @Getter
    @Setter
    private Boolean blockedMovementSouthEast;
    @Getter
    @Setter
    private Boolean blockedMovementSouthWest;
    @Getter
    @Setter
    private Boolean blockedMovementObject;
    @Getter
    @Setter
    private Boolean blockedMovementFloorDecoration;
    @Getter
    @Setter
    private Boolean blockedMovementFloor;
    @Getter
    @Setter
    private Boolean blockedMovementFull;

    public AStarNode() {
    }


    public int getFCost() {
        return gCost + hCost;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public boolean isWalkable(AStarNode neighbor) {
        int myX = getWorldLocation().getX();
        int myY = getWorldLocation().getY();
        int neighborX = neighbor.getWorldLocation().getX();
        int neighborY = neighbor.getWorldLocation().getY();

        // North
        if (neighborX == myX && neighborY == myY + 1) {
            if (!neighbor.getBlockedMovementSouth()) {
                return true;
            }
        }

        // South
        if (neighborX == myX && neighborY == myY - 1) {
            if (!neighbor.getBlockedMovementNorth()) {
                return true;
            }
        }

        // East
        if (neighborX == myX + 1 && neighborY == myY) {
            if (!neighbor.getBlockedMovementWest()) {
                return true;
            }
        }

        // West
        if (neighborX == myX - 1 && neighborY == myY) {
            if (!neighbor.getBlockedMovementEast()) {
                return true;
            }
        }

//        // North-East
//        if (neighborX == myX + 1 && neighborY == myY + 1) {
//            if (!neighbor.getBlockedMovementSouth() && !neighbor.getBlockedMovementWest() && !neighbor.getBlockedMovementSouthWest()) {
//                return true;
//            }
//        }
//
//        // North-West
//        if (neighborX == myX - 1 && neighborY == myY + 1) {
//            if (!neighbor.getBlockedMovementSouth() && !neighbor.getBlockedMovementEast() && !neighbor.getBlockedMovementSouthEast()) {
//                return true;
//            }
//        }
//
//        // South-East
//        if (neighborX == myX + 1 && neighborY == myY - 1) {
//            if (!neighbor.getBlockedMovementNorth() && !neighbor.getBlockedMovementWest() && !neighbor.getBlockedMovementNorthWest()) {
//                return true;
//            }
//        }
//
//        // South-West
//        if (neighborX == myX - 1 && neighborY == myY - 1) {
//            if (!neighbor.getBlockedMovementNorth() && !neighbor.getBlockedMovementEast() && !neighbor.getBlockedMovementNorthEast()) {
//                return true;
//            }
//        }

        return false;
    }

    public WorldPoint getWorldLocation() {
        if (worldLocation == null) {
            return tile.getWorldLocation();
        }
        return worldLocation;
    }
}
