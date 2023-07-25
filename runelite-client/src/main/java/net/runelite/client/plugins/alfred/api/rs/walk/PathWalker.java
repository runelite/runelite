package net.runelite.client.plugins.alfred.api.rs.walk;

import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.math.Calculations;
import net.runelite.client.plugins.alfred.api.rs.menu.RSMenu;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;
import net.runelite.client.plugins.alfred.api.rs.walk.astar.AStarNode;

import java.util.ArrayList;
import java.util.List;

public class PathWalker {
    private final List<AStarNode> tiles;
    private final RSPlayer player;

    public PathWalker(List<AStarNode> tiles) {
        this.tiles = tiles;
        this.player = Alfred.api.players().getLocalPlayer();
    }

    public void walkPath() {
        List<AStarNode> visitedNodes = new ArrayList<>();

        for (AStarNode currentNode : tiles) {
            visitedNodes.add(currentNode);
            Point minimapPoint = Alfred.api.miniMap().getWorldPointToScreenPoint(currentNode.getWorldLocation());

            if (minimapPoint == null) {
                continue;
            }

            int distance = (int) Calculations.distanceBetweenPoints(player.getWorldLocation(), currentNode.getWorldLocation());
            boolean isLastNode = currentNode.getWorldLocation().equals(tiles.get(tiles.size() - 1).getWorldLocation());

            int operableDistance = -1;
            AStarNode nextOperableNode = tiles.stream().filter(node -> node.getIsOperable()).filter(node -> !visitedNodes.contains(node)).findFirst().orElse(null);

            if (nextOperableNode != null) {
                operableDistance = (int) Calculations.distanceBetweenPoints(player.getWorldLocation(), nextOperableNode.getWorldLocation());
            }

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

                if (!operateOnTile(realTile.getTile())) {
                    continue;
                }
            }

            if (nextOperableNode != null && operableDistance <= 4) {
                RSTile realTile = findTile(nextOperableNode);
                if (realTile == null) {
                    continue;
                }

                if (!operateOnTile(realTile.getTile())) {
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

    private boolean operateOnTile(Tile tile) {
        Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 10);
        Alfred.api.camera().lookAt(tile.getWorldLocation());

        Alfred.sleep(100, 200);

        WallObject wallObject = tile.getWallObject();
        if (wallObject == null) {
            System.out.println("Wall object is null");
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

        boolean success = rsMenu.clickAction("open");
        if (!success) {
            System.out.println("Failed to operate on tile");
        }
        return success;
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
}
