package net.runelite.client.plugins.randall.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import net.runelite.api.*;
import net.runelite.client.plugins.randall.RandallPlugin;
import net.runelite.client.plugins.randall.models.ItemModel;
import net.runelite.client.plugins.randall.models.NPCModel;
import net.runelite.client.plugins.randall.models.PlayerModel;
import net.runelite.http.api.RuneLiteAPI;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
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

    public Map<String, String> queryToMap(String query) {
        if (query == null) {
            return null;
        }
        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            } else {
                result.put(entry[0], "");
            }
        }
        return result;
    }

    public void startUp() throws Exception {
        server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8888), 0);
        server.createContext("/game/", this::getGame);
        server.createContext("/player/", this::getPlayer);
        server.createContext("/players/", this::getPlayers);
        server.createContext("/npcs/", this::getNpcs);
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

        exchange.sendResponseHeaders(200, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    public void getPlayer(HttpExchange exchange) throws IOException {
        Player player = client.getLocalPlayer();

        JsonObject data = new JsonObject();
        data.addProperty("email", client.getUsername());

        JsonObject cameraData = new JsonObject();
        cameraData.addProperty("x", client.getCameraX());
        cameraData.addProperty("y", client.getCameraX());
        cameraData.addProperty("z", client.getCameraX());
        cameraData.addProperty("pitch", client.getCameraPitch());
        cameraData.addProperty("yaw", client.getCameraYaw());

        data.add("player", new PlayerModel(client, player).toJson());
        data.add("camera", cameraData);

        exchange.sendResponseHeaders(200, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    public void getPlayers(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();

        for (Player player : client.getPlayers()) {
            data.add(new PlayerModel(client, player).toJson());
        }

        exchange.sendResponseHeaders(200, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    public void getNpcs(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();

        for (NPC npc : client.getNpcs()) {
            data.add(new NPCModel(npc).toJson());
        }

        exchange.sendResponseHeaders(200, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    public void getInventory(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();


        ItemContainer container = client.getItemContainer(InventoryID.INVENTORY);

        for (Item item : container.getItems()) {
            data.add(new ItemModel(client, item).toJson());
        }

        exchange.sendResponseHeaders(200, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    public void setCursorPosition(HttpExchange exchange) throws IOException {
        Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());
        int x = Integer.parseInt(params.get("x"));
        int y = Integer.parseInt(params.get("y"));

        JsonObject data = new JsonObject();
        data.addProperty("x", x);
        data.addProperty("y", x);

        plugin.mouse.windMouse(x, y);

        exchange.sendResponseHeaders(200, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    public void cursorClick(HttpExchange exchange) throws IOException {
        Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());
        int left = Integer.parseInt(params.get("left"));

        JsonObject data = new JsonObject();
        data.addProperty("left", left);

        int x = plugin.mouse.getMousePos().x;
        int y = plugin.mouse.getMousePos().y;

        if (left == 1) {
            plugin.mouse.clickMouse(x, y, 1);
        } else {
            plugin.mouse.clickMouse(x, y, 1);
        }

        exchange.sendResponseHeaders(200, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    public void keyboardSendKeys(HttpExchange exchange) throws IOException {
        Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());


//        JsonObject postData = new JsonObject(exchange.getRequestBody());

        System.out.println(exchange.getResponseBody());
        String text = params.get("text");

        JsonObject data = new JsonObject();
        data.addProperty("text", text);

        plugin.keyboard.sendKeys(text, 160, 160);

        exchange.sendResponseHeaders(200, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    public void keyboardHoldKey(HttpExchange exchange) throws IOException {
        Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());
        int keyCode = Integer.parseInt(params.get("code"));

        JsonObject data = new JsonObject();
        data.addProperty("code", keyCode);

        plugin.keyboard.holdKey(keyCode);

        exchange.sendResponseHeaders(200, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    public void keyboardReleaseKey(HttpExchange exchange) throws IOException {
        Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());
        int keyCode = Integer.parseInt(params.get("code"));

        JsonObject data = new JsonObject();
        data.addProperty("code", keyCode);

        plugin.keyboard.releaseKey(keyCode);

        exchange.sendResponseHeaders(200, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }
}