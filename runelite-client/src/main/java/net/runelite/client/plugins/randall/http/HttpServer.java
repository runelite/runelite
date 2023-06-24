package net.runelite.client.plugins.randall.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import net.runelite.api.*;
import net.runelite.client.plugins.randall.RandallPlugin;
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
        server.createContext("/player/", this::handlePlayer);
        server.createContext("/inventory/", this::handleInventory);
        server.createContext("/mouse/move/", this::setCursorPosition);
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.start();
    }

    public void shutDown() throws Exception {
        server.stop(1);
    }

    public void handlePlayer(HttpExchange exchange) throws IOException {
        Player player = client.getLocalPlayer();

        JsonObject data = new JsonObject();
        data.addProperty("email", client.getUsername());

        JsonObject playerData = new JsonObject();
        playerData.addProperty("name", player.getName());
        playerData.addProperty("plane", player.getWorldLocation().getPlane());
        playerData.addProperty("x", player.getWorldLocation().getX());
        playerData.addProperty("y", player.getWorldLocation().getY());

        JsonObject cameraData = new JsonObject();
        cameraData.addProperty("x", client.getCameraX());
        cameraData.addProperty("y", client.getCameraX());
        cameraData.addProperty("z", client.getCameraX());
        cameraData.addProperty("pitch", client.getCameraPitch());
        cameraData.addProperty("yaw", client.getCameraYaw());

        data.add("player", playerData);
        data.add("camera", cameraData);

        exchange.sendResponseHeaders(200, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    public void handleInventory(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();


        ItemContainer container = client.getItemContainer(InventoryID.INVENTORY);

        for (Item item : container.getItems()) {
            JsonObject itemData = new JsonObject();
            itemData.addProperty("id", item.getId());
            itemData.addProperty("quantity", item.getQuantity());

            ItemComposition itemComposition = client.getItemDefinition(item.getId());

            itemData.addProperty("name", itemComposition.getName());
            itemData.addProperty("members_name", itemComposition.getMembersName());
            itemData.addProperty("price", itemComposition.getPrice());
            itemData.addProperty("is_tradable", itemComposition.isTradeable());
            itemData.addProperty("is_stackable", itemComposition.isStackable());
            itemData.addProperty("is_members", itemComposition.isMembers());

            JsonArray inventoryActions = new JsonArray();
            for (String action : itemComposition.getInventoryActions()) {
                if (action != null) {
                    inventoryActions.add(action);
                }
            }

            itemData.add("inventory_actions", inventoryActions);
            data.add(itemData);
        }

        exchange.sendResponseHeaders(200, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    private String handleGetRequest(HttpExchange httpExchange) {
        return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
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

}