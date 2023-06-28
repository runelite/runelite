package net.runelite.client.plugins.randall.http.handlers.npc;

import com.google.gson.JsonArray;
import com.sun.net.httpserver.HttpExchange;
import net.runelite.api.Client;
import net.runelite.client.plugins.randall.interfaces.ConectServerHandlerInterface;
import net.runelite.client.plugins.randall.models.NPCModel;

import java.io.IOException;

public class NPCHandler implements ConectServerHandlerInterface {

    private final Client client;

    public NPCHandler(Client client) {
        super();
        this.client = client;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String requestURI = String.valueOf(exchange.getRequestURI());

        if (requestMethod.equals("GET") && requestURI.equals("/npc/list/")) {
            getNpcs(exchange);
        } else {
            exchange.sendResponseHeaders(405, 0);
        }
        exchange.close();
    }

    public void getNpcs(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();
        client.getNpcs().forEach(npc -> data.add(new NPCModel(npc).toJson()));
        writeResponse(exchange, 200, data);
    }
}
