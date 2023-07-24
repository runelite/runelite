package net.runelite.client.plugins.alfred.api.rs.walk;

import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.math.Calculations;
import net.runelite.client.plugins.alfred.api.rs.menu.RSMenu;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;
import net.runelite.client.plugins.alfred.api.rs.walk.astar.AStarNode;
import net.runelite.client.plugins.alfred.api.rs.walk.astar.AStarPathFinder;
import net.runelite.client.plugins.alfred.api.rs.walk.astar.NodeLoader;

import java.lang.reflect.Field;
import java.util.*;

public class RSWalkHelper {
    private static final int MAX_DISTANCE = 2400;

    @Getter
    private static List<Integer> operableObjectIds;

    public RSWalkHelper() {
        operableObjectIds = new ArrayList<>();
        gatherOperableObjectIds();
    }

    public boolean walkTo(WorldPoint worldPoint) {
        RSPlayer player = Alfred.api.players().getLocalPlayer();
        WorldPoint start = player.getWorldLocation();

        NodeLoader nodeLoader = new NodeLoader("/home/griffin/PycharmProjects/worldmap/world/db.sqlite3");
        AStarPathFinder pathFinder = new AStarPathFinder(nodeLoader.getGrid());
        List<AStarNode> pathNodes = pathFinder.findPath(start, worldPoint);

        if (pathNodes == null) {
            Alfred.setStatus("Path is null");
            return false;
        }

        Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 500, 1000 * 10);

        for (AStarNode node : pathNodes) {
            int distance = (int) Calculations.distanceBetweenPoints(player.getWorldLocation(), node.getWorldLocation());
            Point minimapPoint = Alfred.api.miniMap().getWorldPointToScreenPoint(node.getWorldLocation());

            boolean isLastNode = node.equals(pathNodes.get(pathNodes.size() - 1));
            int currentIndex = pathNodes.indexOf(node);
            boolean currentNodeIsOperable = node.getIsOperable();

            boolean nextNodeIsOperable = false;
            if (currentIndex + 1 < pathNodes.size()) {
                AStarNode nextNode = pathNodes.get(currentIndex + 1);
                nextNodeIsOperable = nextNode.getIsOperable();
            }

            if (minimapPoint == null) {
                System.out.println("Minimap point is null");
                if (distance <= 3 && isLastNode) {
                    System.out.println("Close enough");
                    return true;
                }
                continue;
            }


            if (isLastNode) {
                System.out.println("Is last tile");
                Alfred.getMouse().leftClick(minimapPoint);
                Alfred.sleep(1000);
                Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 10);

            } else if (currentNodeIsOperable) {
                System.out.println("Curret tile is operable");
                Alfred.getMouse().leftClick(minimapPoint);
                Alfred.sleep(1000);
                Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 10);

                List<RSTile> tiles = Alfred.api.walk().getWalkableTiles();
                Tile foundTile = null;
                for (RSTile tile : tiles) {
                    if (tile.getWorldLocation().equals(node.getWorldLocation())) {
                        foundTile = ((RSWalkableTile) tile).getTile();
                        break;
                    }
                }

                if (foundTile == null) {
                    System.out.println("Found tile is null");
                    continue;
                }

                WallObject wallObject = foundTile.getWallObject();
                if (wallObject == null) {
                    System.out.println("Wall object is null");
                    continue;
                }

                Alfred.getMouse().rightClick(wallObject.getConvexHull().getBounds());
                Alfred.sleep(200);
                RSMenu rsMenu = Alfred.api.menu().getMenu();
                if (rsMenu == null) {
                    System.out.println("Menu is null");
                    continue;
                }

                if (rsMenu.hasAction("open")) {
                    rsMenu.clickAction("open");
                } else {
                    System.out.println("Menu does not have action open");
                }

            } else if (nextNodeIsOperable) {
                System.out.println("Next tile is operable");
                Alfred.getMouse().leftClick(minimapPoint);
                Alfred.sleep(1000);
                Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 10);

            } else if (distance >= 7) {
                System.out.println("Less than 7 tiles away or operable");
                Alfred.getMouse().leftClick(minimapPoint);
                Alfred.sleep(1000);
                Alfred.sleepUntil(() -> {
                    int distanceToTarget = (int) Calculations.distanceBetweenPoints(player.getWorldLocation(), node.getWorldLocation());
                    boolean isStill = !player.isMoving() && !player.isInteracting() && player.isIdle();
                    boolean nearTile = distanceToTarget <= 2;
                    return isStill || nearTile;
                }, 200, 1000 * 30);
            }
        }

        return true;
    }

    public List<AStarNode> getPath() {
        return AStarPathFinder.path;
    }

    private void gatherOperableObjectIds() {
        Field[] fields = ObjectID.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            if (field.getType() == int.class) {
                try {
                    int fieldValue = field.getInt(null);

                    if (field.getName().startsWith("DOOR")) {
                        operableObjectIds.add(fieldValue);
                    } else if (field.getName().startsWith("LARGE_DOOR")) {
                        operableObjectIds.add(fieldValue);
                    } else if (field.getName().startsWith("GATE")) {
                        operableObjectIds.add(fieldValue);
                    } else if (field.getName().startsWith("TRAPDOOR")) {
                        operableObjectIds.add(fieldValue);
                    } else if (field.getName().startsWith("STAIRCASE")) {
                        operableObjectIds.add(fieldValue);
                    } else if (field.getName().startsWith("CAVE_ENTRANCE")) {
                        operableObjectIds.add(fieldValue);
                    } else if (field.getName().startsWith("STAIRS")) {
                        operableObjectIds.add(fieldValue);
                    } else if (field.getName().startsWith("ANCIENT_GATE")) {
                        operableObjectIds.add(fieldValue);
                    } else if (field.getName().startsWith("TEMPLE_DOOR")) {
                        operableObjectIds.add(fieldValue);
                    } else if (field.getName().startsWith("LADDER")) {
                        operableObjectIds.add(fieldValue);
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Set<WorldMovementFlag> getMovementFlagsForTile(Tile tile) {
        Client client = Alfred.getClient();
        if (client.getCollisionMaps() != null) {
            int[][] flags = client.getCollisionMaps()[client.getPlane()].getFlags();
            int data = flags[tile.getSceneLocation().getX()][tile.getSceneLocation().getY()];

            return WorldMovementFlag.getSetFlags(data);
        }

        return new HashSet<>();
    }

    public List<RSTile> getWalkableTiles() {
        List<RSTile> walkableTiles = new ArrayList<>();

        for (Tile tile : Alfred.api.world().getTiles()) {
            Set<WorldMovementFlag> movementFlags = getMovementFlagsForTile(tile);

            Boolean[] blocked = new Boolean[]{
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FULL),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FLOOR),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FLOOR_DECORATION),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_OBJECT)
            };

            if (Arrays.asList(blocked).contains(true)) {
                continue;
            }

            Boolean[] blockedDirections = new Boolean[]{
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST),

                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH) && movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH) && movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH) && movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH) && movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST),
            };

            if (Arrays.asList(blockedDirections).contains(false)) {
                walkableTiles.add(new RSWalkableTile(tile));
            }
        }

        return walkableTiles;
    }

    public List<RSTile> getTilesForMap() {
        List<RSTile> tiles = new ArrayList<>();

        for (Tile tile : Alfred.api.world().getTiles()) {
            Set<WorldMovementFlag> movementFlags = getMovementFlagsForTile(tile);
            RSTile newTile = new RSWalkableTile(tile);
            newTile.setBlocked(true);

            Boolean[] blocked = new Boolean[]{
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FULL),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FLOOR),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FLOOR_DECORATION),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_OBJECT)
            };

            if (Arrays.asList(blocked).contains(true)) {
                newTile.setBlocked(true);
                newTile.setMovementPenalty(50);
                tiles.add(newTile);
                continue;
            }

            Boolean[] blockedDirections = new Boolean[]{
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST),

                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH) && movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH) && movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH) && movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH) && movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST),
            };

            if (Arrays.asList(blockedDirections).contains(false)) {
                newTile.setBlocked(false);
            }
            tiles.add(newTile);
        }

        return tiles;
    }

}
