package net.runelite.client.plugins.randall.http.handlers.message;

import com.google.gson.JsonArray;
import com.sun.net.httpserver.HttpExchange;
import net.runelite.api.Client;
import net.runelite.client.plugins.randall.interfaces.ConnectServerHandlerInterface;
import net.runelite.client.plugins.randall.models.MessageModel;

import java.io.IOException;

public class MessageHandler implements ConnectServerHandlerInterface {

    private final Client client;

    public MessageHandler(Client client) {
        super();
        this.client = client;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String requestURI = String.valueOf(exchange.getRequestURI());

        if (requestMethod.equals("GET") && requestURI.equals("/message/list/")) {
            getMessages(exchange);
        } else {
            exchange.sendResponseHeaders(405, 0);
        }
        exchange.close();
    }

    private void getMessages(HttpExchange exchange) throws IOException {
        JsonArray data = new JsonArray();
        client.getMessages().forEach(messageNode -> data.add(new MessageModel(messageNode).toJson()));
        writeResponse(exchange, 200, data);
    }
}
