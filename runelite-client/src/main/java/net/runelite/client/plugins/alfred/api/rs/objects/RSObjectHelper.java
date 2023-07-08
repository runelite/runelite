package net.runelite.client.plugins.alfred.api.rs.objects;

import net.runelite.api.Constants;
import net.runelite.api.GameObject;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.client.plugins.alfred.Alfred;

import java.util.ArrayList;
import java.util.List;

public class RSObjectHelper {

    private static final int MAX_DISTANCE = 2400;

    public static List<GameObject> getGameObjects() {

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
                            }
                        }
                    }
                }
            }

            return gameObjects;
        });
    }
}
