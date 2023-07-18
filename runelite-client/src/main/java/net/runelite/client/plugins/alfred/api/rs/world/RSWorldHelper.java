package net.runelite.client.plugins.alfred.api.rs.world;

import net.runelite.api.Constants;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.client.plugins.alfred.Alfred;

import java.util.ArrayList;
import java.util.List;

public class RSWorldHelper {

    private static final int MAX_DISTANCE = 2400;

//    public void getWorldDefinition() {
//
//        Alfred.getClientThread().invokeOnClientThread(() -> {
//            JsonArray worldData = new JsonArray();
//            List<GameObject> gameObjects = new ArrayList<>();
//
//            Player player = Alfred.getClient().getLocalPlayer();
//            Tile[][][] tiles = Alfred.getClient().getScene().getTiles();
//            int z = Alfred.getClient().getPlane();
//
//            for (int x = 0; x < Constants.SCENE_SIZE; ++x) {
//                for (int y = 0; y < Constants.SCENE_SIZE; ++y) {
//                    Tile tile = tiles[z][x][y];
//
//                    if (tile == null) {
//                        continue;
//                    }
//
//                    Set<WorldMovementFlag> movementFlags = getMovementFlagsForTile(tile);
//                    boolean isWalkable = true;
//
//                    for (WorldMovementFlag worldMovementFlag : movementFlags) {
//                        if (worldMovementFlag.toString().equals(WorldMovementFlag.BLOCK_MOVEMENT_FULL.toString())){
//                            isWalkable = false;
//                        }
//                        if (worldMovementFlag.toString().equals(WorldMovementFlag.BLOCK_MOVEMENT_OBJECT.toString())){
//                            isWalkable = false;
//                        }
//                    }
//
//                    JsonObject row = new JsonObject();
//                    row.addProperty("walkable", isWalkable);
//                    row.addProperty("x", tile.getWorldLocation().getX());
//                    row.addProperty("y", tile.getWorldLocation().getY());
//                    row.addProperty("z", tile.getWorldLocation().getPlane());
//                    worldData.add(row);
//
//
////                    List<RSObject> rsObjectsList = Alfred.api.objects().getObjectsFromTile(tile, false);
////                    for (RSObject rsObject : rsObjectsList) {
////   k                     int data = flags[x][y];
////
////                        Set<WorldMovementFlag> movementFlags = WorldMovementFlag.getSetFlags(data);
////
////                        WorldPoint worldPoint = rsObject.getWorldLocation();
////                        List<String> movementFlagNames = new ArrayList<>();
////                        System.out.printf("Object ID: %s, Object Type: %s, X: %d, Y: %d, Z: %d, Name: %s, Actions: %s Runelite Name: %s%n", rsObject.getId(), rsObject.getType(), worldPoint.getX(), worldPoint.getY(), worldPoint.getPlane(), rsObject.getName(), String.join(", ", rsObject.getActions()), rsObject.getRuneliteVariableName());
////                        for (WorldMovementFlag worldMovementFlag : movementFlags) {
////                            System.out.println(String.format("\tFlag: %s, String: %s, Name: %s", worldMovementFlag.getFlag(), worldMovementFlag.toString(), worldMovementFlag.name()));
////                        }
////                        JsonObject row = new JsonObject();
////                        row.addProperty("render_level", tile.getRenderLevel());
////                        row.addProperty("collision_data", data);
////                        row.addProperty("object_id", rsObject.getId());
////                        row.addProperty("object_type", rsObject.getType());
////                        row.addProperty("name", rsObject.getName());
////                        row.addProperty("internal_name", rsObject.getRuneliteVariableName());
////                        row.addProperty("x", rsObject.getWorldLocation().getX());
////                        row.addProperty("y", rsObject.getWorldLocation().getY());
////                        row.addProperty("z", rsObject.getWorldLocation().getPlane());
////
////                        JsonArray actions = new JsonArray();
////                        for (String action : rsObject.getActions()) {
////                            actions.add(action);
////                        }
////                        row.add("actions", actions);
////
////                        JsonArray movement = new JsonArray();
////                        for (WorldMovementFlag worldMovementFlag : movementFlags) {
////                            movement.add(worldMovementFlag.name());
////                        }
////                        row.add("movement_flags", movement);
////
////                        worldData.add(row);
////                    }
//                }
//            }
//            try {
//                FileWriter myWriter = new FileWriter("/home/griffin/PycharmProjects/runlitebot/worlddata.json");
//                myWriter.write(worldData.toString());
//                myWriter.close();
//                System.out.println("Successfully wrote to the file.");
//            } catch (IOException e) {
//                System.out.println("An error occurred.");
//                e.printStackTrace();
//            }
//            System.out.println(worldData.toString());
//            return null;
//        });
//    }
//
//    private Set<WorldMovementFlag> getMovementFlagsForTile(Tile tile) {
//        Client client = Alfred.getClient();
//        Polygon poly = Perspective.getCanvasTilePoly(client, tile.getLocalLocation());
//
//        if (poly == null || !poly.contains(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY())) {
//            return new HashSet<>();
//        }
//
//        if (client.getCollisionMaps() != null) {
//            int[][] flags = client.getCollisionMaps()[client.getPlane()].getFlags();
//            int data = flags[tile.getWorldLocation().getX()][tile.getWorldLocation().getY()];
//
//            return WorldMovementFlag.getSetFlags(data);
//        }
//        return new HashSet<>();
//    }


    private List<Tile> internalGetTiles() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            List<Tile> tileList = new ArrayList<>();

            Player player = Alfred.getClient().getLocalPlayer();
            Tile[][][] tiles = Alfred.getClient().getScene().getTiles();
            int z = Alfred.getClient().getPlane();

            for (int x = 0; x < Constants.SCENE_SIZE; ++x) {
                for (int y = 0; y < Constants.SCENE_SIZE; ++y) {
                    Tile tile = tiles[z][x][y];
                    if (tile == null) {
                        continue;
                    }

                    if (player.getLocalLocation().distanceTo(tile.getLocalLocation()) <= MAX_DISTANCE) {
                        tileList.add(tile);
                    }
                }
            }

            return tileList;
        });
    }

    public List<Tile> getTiles() {
        return internalGetTiles();
    }


//    public void getWorldDefinition() {
//        JsonArray worldData = new JsonArray();
//
//        Client client = Alfred.getClient();
//        Scene scene = client.getScene();
//        Tile[][][] tiles = scene.getTiles();
//
//        int z = client.getPlane();
//
//        for (int x = 0; x < Constants.SCENE_SIZE; ++x) {
//            for (int y = 0; y < Constants.SCENE_SIZE; ++y) {
//                Tile tile = tiles[z][x][y];
//
//                if (tile == null) {
//                    continue;
//                }
//
//                Player player = client.getLocalPlayer();
//                if (player == null) {
//                    continue;
//                }
//
//
//                JsonObject row = new JsonObject();
//                row.addProperty("x", tile.getWorldLocation().getX());
//                row.addProperty("y", tile.getWorldLocation().getY());
//                row.addProperty("region_x", tile.getWorldLocation().getRegionX());
//                row.addProperty("region_y", tile.getWorldLocation().getRegionY());
//                row.addProperty("z", tile.getWorldLocation().getPlane());
//
//                JsonArray movement = new JsonArray();
//                for (WorldMovementFlag worldMovementFlag : getMovementFlagsForTile(tile)) {
//                    movement.add(worldMovementFlag.name());
//                }
//                row.add("movement_flags", movement);
//                worldData.add(row);
//            }
//        }
//
//        try {
//            FileWriter myWriter = new FileWriter("/home/griffin/PycharmProjects/runlitebot/worlddata.json");
//            myWriter.write(worldData.toString());
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//        System.out.println(worldData);
//    }


//    import net.runelite.client.plugins.alfred.Alfred;
//
//import net.runelite.api.Client;
//import net.runelite.api.Perspective;
//import net.runelite.api.Tile;
//import net.runelite.client.ui.FontManager;
//import net.runelite.client.ui.overlay.Overlay;
//import net.runelite.client.ui.overlay.OverlayLayer;
//import net.runelite.client.ui.overlay.OverlayPosition;
//import net.runelite.client.ui.overlay.OverlayPriority;
//
//import java.awt.Polygon;
//import java.util.List;
//
//
//List<Tile> walkableTiles = Alfred.api.world().getWalkableTiles();
//log.info(walkableTiles);
//
//for (Tile tile : walkableTiles) {
//
//    Polygon poly = Perspective.getCanvasTilePoly(client, tile.getLocalLocation());
//
//    if (poly == null) {
//        continue;
//    }
//
//    log.info("test");
//}

}
