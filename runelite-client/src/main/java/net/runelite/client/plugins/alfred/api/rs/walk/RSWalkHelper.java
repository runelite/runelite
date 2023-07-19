package net.runelite.client.plugins.alfred.api.rs.walk;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.ObjectID;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.math.Calculations;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;

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
        PathFinder pathFinder = new PathFinder(Alfred.api.walk().getWalkableTiles());
        List<RSTile> pathTiles = pathFinder.getPath(start, worldPoint);

        if (pathTiles == null) {
            Alfred.setStatus("Path is null");
            return false;
        }

        Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 500, 1000 * 10);

        for (RSTile tile : pathTiles) {
            int distance = (int) Calculations.distanceBetweenPoints(player.getWorldLocation(), tile.getWorldLocation());
            Point minimapPoint = Alfred.api.miniMap().getWorldPointToScreenPoint(tile.getWorldLocation());
            boolean isLastTile = tile.equals(pathTiles.get(pathTiles.size() - 1));

            if (minimapPoint == null) {
                System.out.println("Minimap point is null");
                if (distance <= 3 && isLastTile) {
                    System.out.println("Close enough");
                    return true;
                }
                continue;
            }


            if (isLastTile) {
                System.out.println("Is last tile");
                Alfred.getMouse().leftClick(minimapPoint);
                Alfred.sleep(1000);
                Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 10);

            } else if (distance >= 7 || tile.isOperable()) {
                System.out.println("Less than 7 tiles away or operable");
                Alfred.getMouse().leftClick(minimapPoint);
                Alfred.sleep(1000);
                Alfred.sleepUntil(() -> {
                    int distanceToTarget = (int) Calculations.distanceBetweenPoints(player.getWorldLocation(), tile.getWorldLocation());
                    boolean isStill = !player.isMoving() && !player.isInteracting() && player.isIdle();
                    boolean nearTile = distanceToTarget <= 2;
                    return isStill || nearTile;
                }, 200, 1000 * 30);
            }
        }

        return true;
    }

    public List<RSTile> getPath() {
        return PathFinder.path;
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

            Boolean[] blocked = new Boolean[]{movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FULL),
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FLOOR),
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FLOOR_DECORATION),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_OBJECT),};

            if (Arrays.asList(blocked).contains(true)) {
                continue;
            }

            Boolean[] blockedDirections = new Boolean[]{
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH),
                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST)
            };

            if (Arrays.asList(blockedDirections).contains(false)) {
                walkableTiles.add(new RSWalkableTile(tile));
            }

        }

        return walkableTiles;
    }

}
