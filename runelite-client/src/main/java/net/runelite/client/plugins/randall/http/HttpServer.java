package net.runelite.client.plugins.randall.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import net.runelite.api.*;
import net.runelite.client.plugins.randall.RandallPlugin;
import net.runelite.client.plugins.randall.models.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;


public class HttpServer {

    private final Client client;
    private RandallPlugin plugin;

    public com.sun.net.httpserver.HttpServer server;
    public int MAX_DISTANCE = 1200;


    public HttpServer(Client client, RandallPlugin plugin) {
        this.client = client;
        this.plugin = plugin;
    }

    public void startUp() throws Exception {
        server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8888), 0);
        server.createContext("/game/", this::getGame);
        server.createContext("/player/", this::getPlayer);
        server.createContext("/players/", this::getPlayers);
        server.createContext("/npcs/", this::getNpcs);
        server.createContext("/objects/", this::getObjects);
        server.createContext("/inventory/", this::getInventory);
        server.createContext("/mouse/move/", this::setCursorPosition);
        server.createContext("/mouse/click/", this::cursorClick);
        server.createContext("/keyboard/sendkeys/", this::keyboardSendKeys);
        server.createContext("/keyboard/hold/", this::keyboardHoldKey);
        server.createContext("/keyboard/release/", this::keyboardReleaseKey);
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.start();
    }

    public void shutDown() throws Exception {
        server.stop(1);
    }

    public void getGame(HttpExchange exchange) throws IOException {
        JsonObject data = new JsonObject();
        data.addProperty("state", client.getGameState().toString());
        data.addProperty("login_index", client.getLoginIndex());
        data.addProperty("idle_timeout", client.getIdleTimeout());

        HttpToolkit.writeResponse(exchange, 200, data);
    }

    public void getPlayer(HttpExchange exchange) throws IOException {
        Player player = client.getLocalPlayer();

        JsonObject data = new JsonObject();
        data.addProperty("email", client.getUsername());
        data.add("player", new PlayerModel(client, player).toJson());
        data.add("camera", new CameraModel(client).toJson());

        HttpToolkit.writeResponse(exchange, 200, data);
    }

    public void getPlayers(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();
        client.getPlayers().forEach(player -> data.add(new PlayerModel(client, player).toJson()));
        HttpToolkit.writeResponse(exchange, 200, data);
    }

    public void getNpcs(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();
        client.getNpcs().forEach(npc -> data.add(new NPCModel(npc).toJson()));
        HttpToolkit.writeResponse(exchange, 200, data);
    }

    public void getInventory(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();
        ItemContainer container = client.getItemContainer(InventoryID.INVENTORY);
        Arrays.stream(container.getItems()).forEach(item -> data.add(new ItemModel(client, item).toJson()));
        HttpToolkit.writeResponse(exchange, 200, data);
    }

    public void getObjects(HttpExchange exchange) {
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
            HttpToolkit.writeResponse(exchange, 200, data);

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

    public void setCursorPosition(HttpExchange exchange) throws IOException {
        JsonObject postData = HttpToolkit.getPostData(exchange);

        int x = postData.get("x").getAsInt();
        int y = postData.get("y").getAsInt();
        plugin.mouse.windMouse(x, y);

        HttpToolkit.writeResponse(exchange, 200, postData);
    }

    public void cursorClick(HttpExchange exchange) throws IOException {
        JsonObject postData = HttpToolkit.getPostData(exchange);

        int button = postData.get("button").getAsInt();

        int x = plugin.mouse.getMousePos().x;
        int y = plugin.mouse.getMousePos().y;

        plugin.mouse.clickMouse(x, y, button);

        HttpToolkit.writeResponse(exchange, 200, postData);
    }


    public void keyboardSendKeys(HttpExchange exchange) throws IOException {
        JsonObject postData = HttpToolkit.getPostData(exchange);

        String text = postData.get("text").getAsString();
        plugin.keyboard.sendKeys(text, 160, 160);

        HttpToolkit.writeResponse(exchange, 200, postData);
    }

    public void keyboardHoldKey(HttpExchange exchange) throws IOException {
        JsonObject postData = HttpToolkit.getPostData(exchange);

        int code = postData.get("code").getAsInt();
        plugin.keyboard.holdKey(code);

        HttpToolkit.writeResponse(exchange, 200, postData);

    }

    public void keyboardReleaseKey(HttpExchange exchange) throws IOException {
        JsonObject postData = HttpToolkit.getPostData(exchange);

        int code = postData.get("code").getAsInt();
        plugin.keyboard.releaseKey(code);

        HttpToolkit.writeResponse(exchange, 200, postData);
    }
}
