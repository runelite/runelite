package net.runelite.client.plugins.randall.http.handlers.paint;

import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import net.runelite.client.plugins.randall.RandallPlugin;
import net.runelite.client.plugins.randall.interfaces.ConnectServerHandlerInterface;

import java.awt.*;
import java.io.IOException;

public class PaintHandler implements ConnectServerHandlerInterface {

    private final RandallPlugin plugin;

    public PaintHandler(RandallPlugin plugin) {
        super();
        this.plugin = plugin;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String requestURI = String.valueOf(exchange.getRequestURI());

        if (requestMethod.equals("POST") && requestURI.equals("/paint/point/add/")) {
            addPoint(exchange);
        } else if (requestMethod.equals("POST") && requestURI.equals("/paint/point/clear/")) {
            clearPoints(exchange);
        } else {
            exchange.sendResponseHeaders(405, 0);
        }
        exchange.close();
    }

    private void addPoint(HttpExchange exchange) throws IOException {
        JsonObject postData = getPostData(exchange);
        int x = postData.get("x").getAsInt();
        int y = postData.get("y").getAsInt();
        plugin.customPoints.add(new Point(x, y));
        writeResponse(exchange, 200, postData);
    }

    private void clearPoints(HttpExchange exchange) throws IOException {
        JsonObject data = new JsonObject();
        plugin.customPoints.clear();
        writeResponse(exchange, 200, data);
    }
}
