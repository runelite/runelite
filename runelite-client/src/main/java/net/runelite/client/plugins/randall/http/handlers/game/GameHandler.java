package net.runelite.client.plugins.randall.http.handlers.game;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import net.runelite.api.Client;
import net.runelite.client.game.WorldService;
import net.runelite.client.plugins.randall.interfaces.ConnectServerHandlerInterface;
import net.runelite.client.plugins.randall.models.CameraModel;
import net.runelite.client.plugins.randall.models.GameModel;
import net.runelite.client.plugins.randall.models.WorldModel;
import net.runelite.http.api.worlds.WorldResult;

import java.io.IOException;

public class GameHandler implements ConnectServerHandlerInterface {

    private final Client client;
    private final WorldService worldService;

    public GameHandler(Client client, WorldService worldService) {
        super();
        this.client = client;
        this.worldService = worldService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String requestURI = String.valueOf(exchange.getRequestURI());

        if (requestMethod.equals("GET") && requestURI.equals("/game/")) {
            getGame(exchange);
        } else if (requestMethod.equals("GET") && requestURI.equals("/world/")) {
            getWorld(exchange);
        } else if (requestMethod.equals("GET") && requestURI.equals("/world/list/")) {
            getWorlds(exchange);
        } else {
            exchange.sendResponseHeaders(405, 0);
        }
        exchange.close();
    }

    private void getGame(HttpExchange exchange) throws IOException {
        JsonObject data = new JsonObject();
        data.add("game", new GameModel(client).toJson());
        data.add("camera", new CameraModel(client).toJson());
        writeResponse(exchange, 200, data);
    }

    private void getWorld(HttpExchange exchange) throws IOException {
        JsonObject data = new JsonObject();
        data.addProperty("id", client.getWorld());
        writeResponse(exchange, 200, data);
    }

    private void getWorlds(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();
        WorldResult worldResult = worldService.getWorlds();
        worldResult.getWorlds().forEach(world -> data.add(new WorldModel(world).toJson()));
        writeResponse(exchange, 200, data);
    }
}
