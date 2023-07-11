package net.runelite.client.plugins.alfred.api.rs.objects;

import net.runelite.api.*;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.item.RSItem;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RSObjectHelper {

    private static final int MAX_DISTANCE = 2400;

    public RSObjectHelper() {

    }

    private List<RSObject> internalGetObjectsFromTile(Tile tile, boolean objectsAreLocal) {
        List<RSObject> rsObjectList = new ArrayList<>();

        for (GameObject gameObject : tile.getGameObjects()) {
            if (gameObject == null) {
                continue;
            }
            if (objectsAreLocal && gameObject.getSceneMinLocation().equals(tile.getSceneLocation())) {
                rsObjectList.add(new RSObject(gameObject));

            } else if (!objectsAreLocal) {
                rsObjectList.add(new RSObject(gameObject));

            }
        }

        GroundObject groundObject = tile.getGroundObject();
        if (groundObject != null) {
            rsObjectList.add(new RSObject(groundObject));
        }

        WallObject wallObject = tile.getWallObject();
        if (wallObject != null) {
            rsObjectList.add(new RSObject(wallObject));
        }

        DecorativeObject decorativeObject = tile.getDecorativeObject();
        if (decorativeObject != null) {
            rsObjectList.add(new RSObject(decorativeObject));
        }


        return rsObjectList;
    }

    public List<RSItem> getItemsFromTile(Tile tile) {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            Player player = Alfred.getClient().getLocalPlayer();
            List<RSItem> rsItemList = new ArrayList<>();
            ItemLayer itemLayer = tile.getItemLayer();

            if (itemLayer == null) {
                return rsItemList;
            }

            if (player.getLocalLocation().distanceTo(itemLayer.getLocalLocation()) <= MAX_DISTANCE) {
                Node current = itemLayer.getBottom();
                while (current instanceof TileItem) {
                    TileItem item = (TileItem) current;
                    rsItemList.add(new RSItem(item));
                    current = current.getNext();
                }
            }

            return rsItemList;
        });
    }

    public List<RSObject> getObjectsFromTile(Tile tile) {
        return internalGetObjectsFromTile(tile, false);
    }

    public List<RSObject> getObjectsFromTile(Tile tile, boolean objectsAreLocal) {
        return internalGetObjectsFromTile(tile, objectsAreLocal);
    }

    public List<GameObject> getGameObjects() {

        return Alfred.getClientThread().invokeOnClientThread(() -> {
            List<GameObject> gameObjects = new ArrayList<>();

            Player player = Alfred.getClient().getLocalPlayer();
            Tile[][][] tiles = Alfred.getClient().getScene().getTiles();
            int z = Alfred.getClient().getPlane();

            for (int x = 0; x < Constants.SCENE_SIZE; ++x) {
                for (int y = 0; y < Constants.SCENE_SIZE; ++y) {
                    Tile tile = tiles[z][x][y];

                    if (tile == null) {
                        continue;
                    }

                    for (GameObject gameObject : tile.getGameObjects()) {
                        if (gameObject != null && gameObject.getSceneMinLocation().equals(tile.getSceneLocation())) {
                            if (player.getLocalLocation().distanceTo(gameObject.getLocalLocation()) <= MAX_DISTANCE) {
                                gameObjects.add(gameObject);
                                ObjectComposition objectComposition = Alfred.getClient().getObjectDefinition(gameObject.getId());
                            }
                        }
                    }
                }
            }

            return gameObjects;
        });
    }

    public String getObjectIdVariableName(int objectId) {
        Field[] fields = ObjectID.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            if (field.getType() == int.class) {
                try {
                    int fieldValue = field.getInt(null);
                    if (fieldValue == objectId) {
                        return field.getName();
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
