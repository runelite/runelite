package net.runelite.client.plugins.alfred.api.rs.walk;

import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.math.Calculations;
import net.runelite.client.plugins.alfred.api.rs.menu.RSMenu;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;
import net.runelite.client.plugins.alfred.api.rs.walk.astar.AStarNode;

import java.util.List;

public class PathWalker {
    private final List<AStarNode> tiles;
    private final RSPlayer player;

    public PathWalker(List<AStarNode> tiles) {
        this.tiles = tiles;
        this.player = Alfred.api.players().getLocalPlayer();
    }


    public void walkPath() {
        for (AStarNode currentNode : tiles) {
            Point minimapPoint = Alfred.api.miniMap().getWorldPointToScreenPoint(currentNode.getWorldLocation());

            if (minimapPoint == null) {
                continue;
            }

            int distance = (int) Calculations.distanceBetweenPoints(player.getWorldLocation(), currentNode.getWorldLocation());
            boolean isLastNode = currentNode.getWorldLocation().equals(tiles.get(tiles.size() - 1).getWorldLocation());

            if (isLastNode && distance < 3) {
                continue;

            } else if (isLastNode) {
                clickPoint(minimapPoint);
                continue;
            }

            if (currentNode.getIsOperable()) {
                RSTile realTile = findTile(currentNode);
                if (realTile == null) {
                    continue;
                }

//                if (!operateOnTile(realTile.getTile())) {
                if (!operateOnTileV2(realTile.getTile())) {
                    continue;
                }
            }

            if (distance >= 7) {
                clickPointWhileRunning(minimapPoint, currentNode);
            }
        }
    }

    private void clickPoint(Point minimapPoint) {
        Alfred.getMouse().leftClick(minimapPoint);
        Alfred.sleep(1000);
        Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 10);
    }

    private void clickPointWhileRunning(Point minimapPoint, AStarNode node) {
        Alfred.getMouse().leftClick(minimapPoint);
        Alfred.sleep(1000);
        Alfred.sleepUntil(() -> {
            int distanceToTarget = (int) Calculations.distanceBetweenPoints(player.getWorldLocation(), node.getWorldLocation());
            boolean isStill = !player.isMoving() && !player.isInteracting() && player.isIdle();
            boolean nearTile = distanceToTarget <= 2;
            return isStill || nearTile;
        }, 200, 1000 * 30);
    }

    private boolean operateOnTileV2(Tile tile) {
        Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 10);

        WallObject wallObject = tile.getWallObject();
        if (wallObject == null) {
            return false;
        }

        Alfred.getMouse().rightClick(wallObject.getConvexHull().getBounds());
        Alfred.sleep(200);

        RSMenu rsMenu = Alfred.api.menu().getMenu();
        if (rsMenu == null) {
            System.out.println("Menu is null");
            return false;
        }

        if (!rsMenu.hasAction("open")) {
            System.out.println("Menu does not contain open action");
            return true;
        }

        if (!rsMenu.clickAction("open")) {
            System.out.println("Failed to operate on tile");
            return false;
        }

        Alfred.sleep(1000);
        Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 10);
        Alfred.sleep(250, 500);
        return true;
    }

    private boolean operateOnTile(Tile tile) {
        Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 10);
        Alfred.sleep(200, 400);

        WallObject wallObject = tile.getWallObject();
        if (wallObject == null) {
            Tile operableNeighbor = getFirstOperableNeighbor(tile);
            if (operableNeighbor != null) {
                wallObject = operableNeighbor.getWallObject();
            }
        }

        if (wallObject == null) {
            System.out.println("Wall is null");
            return false;
        }

        Alfred.getMouse().rightClick(wallObject.getConvexHull().getBounds());
        Alfred.sleep(200);

        RSMenu rsMenu = Alfred.api.menu().getMenu();
        if (rsMenu == null) {
            System.out.println("Menu is null");
            return false;
        }

        if (!rsMenu.hasAction("open")) {
            System.out.println("Menu does not contain open action");
            return true;
        }

        if (!rsMenu.clickAction("open")) {
            System.out.println("Failed to operate on tile");
            return false;
        }

        Alfred.sleep(1000);
        Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 10);
        Alfred.sleep(250, 500);
        return true;
    }

    private RSTile findTile(AStarNode node) {
        List<RSTile> tiles = Alfred.api.walk().getWalkableTiles();
        for (RSTile tile : tiles) {
            if (tile.getWorldLocation().equals(node.getWorldLocation())) {
                return tile;
            }
        }
        return null;
    }

    private Tile getFirstOperableNeighbor(Tile tile) {
        List<RSTile> walkableTiles = Alfred.api.walk().getWalkableTiles();

        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if (x == 0 && y == 0) {
                    continue;
                }

                int checkX = tile.getWorldLocation().getX() + x;
                int checkY = tile.getWorldLocation().getY() + y;

                for (RSTile rsTile : walkableTiles) {
                    if (rsTile.getWorldLocation().getX() != checkX || rsTile.getWorldLocation().getY() != checkY) {
                        continue;
                    }

                    WallObject wallObject = rsTile.getTile().getWallObject();
                    if (wallObject == null) {
                        continue;
                    }

                    if (RSWalkHelper.getOperableObjectIds().contains(wallObject.getId())) {
                        return rsTile.getTile();
                    }
                }
            }
        }
        return null;
    }
}
