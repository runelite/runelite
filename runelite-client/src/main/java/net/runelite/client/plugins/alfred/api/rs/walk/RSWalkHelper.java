package net.runelite.client.plugins.alfred.api.rs.walk;

import lombok.Getter;
import net.runelite.api.*;
import net.runelite.client.plugins.alfred.Alfred;

import java.lang.reflect.Field;
import java.util.*;

public class RSWalkHelper {
    private static final int MAX_DISTANCE = 2400;

    @Getter
    private static List<Integer> operableObjectIds;

    public RSWalkHelper() {
        operableObjectIds = new ArrayList<>();
        getOperateObjectIds();
    }

    public List<RSWalkableTile> getPath() {
        return PathFinder.path;
    }

    private void getOperateObjectIds() {
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

    public List<RSWalkableTile> getWalkableTiles() {
        List<RSWalkableTile> walkableTiles = new ArrayList<>();

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
