package net.runelite.client.plugins.randall.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import net.runelite.api.*;
import net.runelite.client.plugins.randall.RandallPlugin;
import net.runelite.client.plugins.randall.models.ItemModel;
import net.runelite.client.plugins.randall.models.NPCModel;
import net.runelite.client.plugins.randall.models.PlayerModel;

import java.io.IOException;
import java.net.InetSocketAddress;
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

        HttpToolkit.writeResponse(exchange, 200, data);
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

        HttpToolkit.writeResponse(exchange, 200, data);
    }

    public void getPlayers(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();

        for (Player player : client.getPlayers()) {
            data.add(new PlayerModel(client, player).toJson());
        }

        HttpToolkit.writeResponse(exchange, 200, data);
    }

    public void getNpcs(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();

        for (NPC npc : client.getNpcs()) {
            data.add(new NPCModel(npc).toJson());
        }

        HttpToolkit.writeResponse(exchange, 200, data);
    }

    public void getInventory(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();


        ItemContainer container = client.getItemContainer(InventoryID.INVENTORY);

        for (Item item : container.getItems()) {
            data.add(new ItemModel(client, item).toJson());
        }

        HttpToolkit.writeResponse(exchange, 200, data);
    }

    public void setCursorPosition(HttpExchange exchange) throws IOException {
        Map<String, String> params = HttpToolkit.getQueryParams(exchange);

        int x = Integer.parseInt(params.get("x"));
        int y = Integer.parseInt(params.get("y"));

        JsonObject data = new JsonObject();
        data.addProperty("x", x);
        data.addProperty("y", x);

        plugin.mouse.windMouse(x, y);

        HttpToolkit.writeResponse(exchange, 200, data);
    }

    public void cursorClick(HttpExchange exchange) throws IOException {
        Map<String, String> params = HttpToolkit.getQueryParams(exchange);

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

        HttpToolkit.writeResponse(exchange, 200, data);
    }


    public void keyboardSendKeys(HttpExchange exchange) throws IOException {
        JsonObject postData = HttpToolkit.getPostData(exchange);
        String text = postData.get("text").getAsString();

        JsonObject data = new JsonObject();
        data.addProperty("text", text);

        plugin.keyboard.sendKeys(text, 160, 160);

        HttpToolkit.writeResponse(exchange, 200, data);
    }

    public void keyboardHoldKey(HttpExchange exchange) throws IOException {
        Map<String, String> params = HttpToolkit.getQueryParams(exchange);
        int keyCode = Integer.parseInt(params.get("code"));

        JsonObject data = new JsonObject();
        data.addProperty("code", keyCode);

        plugin.keyboard.holdKey(keyCode);

        HttpToolkit.writeResponse(exchange, 200, data);

    }

    public void keyboardReleaseKey(HttpExchange exchange) throws IOException {
        Map<String, String> params = HttpToolkit.getQueryParams(exchange);
        int keyCode = Integer.parseInt(params.get("code"));

        JsonObject data = new JsonObject();
        data.addProperty("code", keyCode);

        plugin.keyboard.releaseKey(keyCode);

        HttpToolkit.writeResponse(exchange, 200, data);
    }
}