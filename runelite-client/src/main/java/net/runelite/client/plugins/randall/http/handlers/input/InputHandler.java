package net.runelite.client.plugins.randall.http.handlers.input;

import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import net.runelite.client.plugins.randall.RandallPlugin;
import net.runelite.client.plugins.randall.interfaces.ConnectServerHandlerInterface;

import java.io.IOException;

public class InputHandler implements ConnectServerHandlerInterface {

    private final RandallPlugin plugin;

    public InputHandler(RandallPlugin plugin) {
        super();
        this.plugin = plugin;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String requestURI = String.valueOf(exchange.getRequestURI());

        if (requestMethod.equals("POST") && requestURI.equals("/input/mouse/position/")) {
            setMousePosition(exchange);
        } else if (requestMethod.equals("POST") && requestURI.equals("/input/mouse/click/")) {
            mouseClick(exchange);
        } else if (requestMethod.equals("POST") && requestURI.equals("/input/keyboard/sendkeys/")) {
            keyboardSendKeys(exchange);
        } else if (requestMethod.equals("POST") && requestURI.equals("/input/keyboard/hold/")) {
            keyboardHoldKey(exchange);
        } else if (requestMethod.equals("POST") && requestURI.equals("/input/keyboard/release/")) {
            keyboardReleaseKey(exchange);
        } else if (requestMethod.equals("POST") && requestURI.equals("/input/enable/")) {
            enableInput(exchange);
        } else if (requestMethod.equals("POST") && requestURI.equals("/input/disable/")) {
            disableInput(exchange);
        } else {
            exchange.sendResponseHeaders(405, 0);
        }
        exchange.close();
    }

    private void setMousePosition(HttpExchange exchange) throws IOException {
        JsonObject postData = getPostData(exchange);

        int x = postData.get("x").getAsInt();
        int y = postData.get("y").getAsInt();
        plugin.mouse.windMouse(x, y);

        writeResponse(exchange, 200, postData);
    }

    private void mouseClick(HttpExchange exchange) throws IOException {
        JsonObject postData = getPostData(exchange);

        int button = postData.get("button").getAsInt();

        int x = plugin.mouse.getMousePos().x;
        int y = plugin.mouse.getMousePos().y;
        plugin.mouse.clickMouse(x, y, button);

        writeResponse(exchange, 200, postData);
    }


    private void keyboardSendKeys(HttpExchange exchange) throws IOException {
        JsonObject postData = getPostData(exchange);

        String text = postData.get("text").getAsString();
        plugin.keyboard.sendKeys(text, 160, 160);

        writeResponse(exchange, 200, postData);
    }

    private void keyboardHoldKey(HttpExchange exchange) throws IOException {
        JsonObject postData = getPostData(exchange);

        int code = postData.get("code").getAsInt();
        plugin.keyboard.holdKey(code);

        writeResponse(exchange, 200, postData);

    }

    private void keyboardReleaseKey(HttpExchange exchange) throws IOException {
        JsonObject postData = getPostData(exchange);

        int code = postData.get("code").getAsInt();
        plugin.keyboard.releaseKey(code);

        writeResponse(exchange, 200, postData);
    }

    private void enableInput(HttpExchange exchange) throws IOException {
        plugin.inputSelector.enableClick();
        writeResponse(exchange, 200, new JsonObject());
    }

    private void disableInput(HttpExchange exchange) throws IOException {
        plugin.inputSelector.disableClick();
        writeResponse(exchange, 200, new JsonObject());
    }
}
