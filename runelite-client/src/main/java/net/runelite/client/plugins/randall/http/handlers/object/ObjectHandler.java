package net.runelite.client.plugins.randall.http.handlers.object;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import net.runelite.api.*;
import net.runelite.client.plugins.randall.interfaces.ConnectServerHandlerInterface;
import net.runelite.client.plugins.randall.models.DecorativeObjectModel;
import net.runelite.client.plugins.randall.models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObjectHandler implements ConnectServerHandlerInterface {

    private final int MAX_DISTANCE = 1200;
    private final Client client;

    public ObjectHandler(Client client) {
        super();
        this.client = client;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String requestURI = String.valueOf(exchange.getRequestURI());

        if (requestMethod.equals("GET") && requestURI.equals("/object/list/")) {
            getObjects(exchange);
        } else {
            exchange.sendResponseHeaders(405, 0);
        }
        exchange.close();
    }

    private void getObjects(HttpExchange exchange) {
        try {
            JsonObject data = new JsonObject();
            JsonArray groundItemArray = new JsonArray();
            JsonArray groundObjectArray = new JsonArray();
            JsonArray gameObjectArray = new JsonArray();
            JsonArray wallObjectArray = new JsonArray();
            JsonArray decorativeObjectArray = new JsonArray();

            Scene scene = client.getScene();
            Tile[][][] tiles = scene.getTiles();

            int z = client.getPlane();

            for (int x = 0; x < Constants.SCENE_SIZE; ++x) {
                for (int y = 0; y < Constants.SCENE_SIZE; ++y) {

                    Tile tile = tiles[z][x][y];

                    if (tile == null) {
                        continue;
                    }

                    Player player = client.getLocalPlayer();
                    if (player == null) {
                        continue;
                    }

                    Iterable<TileItem> groundItems = gatherGroundItems(tile);
                    groundItems.forEach(item -> groundItemArray.add(new GroundItemModel(client, tile, item).toJson()));

                    if (tile.getGroundObject() != null) {
                        groundObjectArray.add(new GroundObjectModel(client, tile, tile.getGroundObject()).toJson());
                    }

                    Iterable<GameObject> gameObjects = gatherGameObjects(tile);
                    gameObjects.forEach(item -> gameObjectArray.add(new GameObjectModel(client, tile, item).toJson()));

                    if (tile.getWallObject() != null) {
                        wallObjectArray.add(new WallObjectModel(client, tile, tile.getWallObject()).toJson());
                    }

                    if (tile.getDecorativeObject() != null) {
                        decorativeObjectArray.add(new DecorativeObjectModel(client, tile, tile.getDecorativeObject()).toJson());
                    }
                }
            }

            data.add("ground_items", groundItemArray);
            data.add("ground_objects", groundObjectArray);
            data.add("game_objects", gameObjectArray);
            data.add("wall_objects", wallObjectArray);
            data.add("decorative_objects", decorativeObjectArray);
            writeResponse(exchange, 200, data);

        } catch (Exception exc) {
            exc.printStackTrace();
            System.out.println(exc);
        }
    }

    private Iterable<TileItem> gatherGroundItems(Tile tile) {
        List<TileItem> tiles = new ArrayList<>();
        ItemLayer itemLayer = tile.getItemLayer();

        if (itemLayer == null) {
            return tiles;
        }

        Player player = client.getLocalPlayer();
        if (player.getLocalLocation().distanceTo(itemLayer.getLocalLocation()) <= MAX_DISTANCE) {
            Node current = itemLayer.getBottom();
            while (current instanceof TileItem) {
                TileItem item = (TileItem) current;
                tiles.add(item);
                current = current.getNext();
            }
        }

        return tiles;
    }

    private Iterable<GameObject> gatherGameObjects(Tile tile) {
        List<GameObject> objects = new ArrayList<>();
        Player player = client.getLocalPlayer();

        GameObject[] gameObjects = tile.getGameObjects();
        if (gameObjects == null) {
            return objects;
        }

        for (GameObject gameObject : gameObjects) {
            if (gameObject != null && gameObject.getSceneMinLocation().equals(tile.getSceneLocation())) {
                if (player.getLocalLocation().distanceTo(gameObject.getLocalLocation()) <= MAX_DISTANCE) {
                    objects.add(gameObject);
                }
            }
        }

        return objects;
    }

}
