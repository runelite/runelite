package net.runelite.client.plugins.alfred.api.rs.walk;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.ObjectID;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;
import net.runelite.client.plugins.alfred.api.rs.walk.astar.AStarNode;
import net.runelite.client.plugins.alfred.api.rs.walk.astar.AStarPathFinder;
import net.runelite.client.plugins.alfred.api.rs.walk.astar.NodeLoader;

import java.lang.reflect.Field;
import java.util.*;

public class RSWalkHelper {
    @Getter
    private static List<Integer> operableObjectIds;

    public RSWalkHelper() {
        operableObjectIds = new ArrayList<>();
        gatherOperableObjectIds();
    }

    public boolean walkTo(WorldPoint worldPoint) {
        RSPlayer player = Alfred.api.players().getLocalPlayer();
        WorldPoint start = player.getWorldLocation();

        NodeLoader nodeLoader = new NodeLoader("/home/griffin/PycharmProjects/OSRSWorld/world/db.sqlite3");
        AStarPathFinder pathFinder = new AStarPathFinder(nodeLoader.getGrid());

        List<AStarNode> pathNodes = pathFinder.findPath(start, worldPoint);
        if (pathNodes.isEmpty()) {
            System.out.println("NO PATH");
        }
        PathWalker pathWalker = new PathWalker(pathNodes);

        pathWalker.walkPath();
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
                    }
//                    } else if (field.getName().startsWith("TRAPDOOR")) {
//                        operableObjectIds.add(fieldValue);
//                    } else if (field.getName().startsWith("STAIRCASE")) {
//                        operableObjectIds.add(fieldValue);
//                    } else if (field.getName().startsWith("CAVE_ENTRANCE")) {
//                        operableObjectIds.add(fieldValue);
//                    } else if (field.getName().startsWith("STAIRS")) {
//                        operableObjectIds.add(fieldValue);
//                    } else if (field.getName().startsWith("ANCIENT_GATE")) {
//                        operableObjectIds.add(fieldValue);
//                    } else if (field.getName().startsWith("TEMPLE_DOOR")) {
//                        operableObjectIds.add(fieldValue);
//                    } else if (field.getName().startsWith("LADDER")) {
//                        operableObjectIds.add(fieldValue);
//                    }

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
                walkableTiles.add(new RSTile(tile));
            }
        }

        return walkableTiles;
    }
//
//    public List<RSTile> getTilesForMap() {
//        List<RSTile> tiles = new ArrayList<>();
//
//        for (Tile tile : Alfred.api.world().getTiles()) {
//            Set<WorldMovementFlag> movementFlags = getMovementFlagsForTile(tile);
//            RSTile newTile = new RSWalkableTile(tile);
//            newTile.setBlocked(true);
//
//            Boolean[] blocked = new Boolean[]{
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FULL),
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FLOOR),
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_FLOOR_DECORATION),
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_OBJECT)
//            };
//
//            if (Arrays.asList(blocked).contains(true)) {
//                newTile.setBlocked(true);
//                newTile.setMovementPenalty(50);
//                tiles.add(newTile);
//                continue;
//            }
//
//            Boolean[] blockedDirections = new Boolean[]{
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH),
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST),
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH),
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST),
//
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH) && movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST),
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_SOUTH) && movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST),
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH) && movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_WEST),
//                    movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_NORTH) && movementFlags.contains(WorldMovementFlag.BLOCK_MOVEMENT_EAST),
//            };
//
//            if (Arrays.asList(blockedDirections).contains(false)) {
//                newTile.setBlocked(false);
//            }
//            tiles.add(newTile);
//        }
//
//        return tiles;
//    }

}
