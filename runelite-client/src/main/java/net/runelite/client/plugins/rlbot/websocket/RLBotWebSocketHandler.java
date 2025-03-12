package net.runelite.client.plugins.rlbot.websocket;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.rlbot.RLBotLogger;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

/**
 * Handles WebSocket communication for the RLBot plugin.
 */
@RequiredArgsConstructor
public class RLBotWebSocketHandler {
    
    /**
     * The logger instance.
     */
    private final RLBotLogger logger;
    
    /**
     * The WebSocket server instance.
     */
    private WebSocketServer server;
    
    /**
     * The WebSocket connection.
     */
    private WebSocket connection;
    
    /**
     * The consumer to handle received messages.
     */
    private final Consumer<JsonObject> messageHandler;
    
    /**
     * Starts the WebSocket server on the specified port.
     *
     * @param port The port to start the server on
     */
    public void startServer(int port) {
        if (server != null) {
            logger.warn("WebSocket server already running");
            return;
        }
        
        server = new WebSocketServer(new InetSocketAddress(port)) {
            @Override
            public void onOpen(WebSocket conn, ClientHandshake handshake) {
                connection = conn;
                logger.info("New WebSocket connection: " + conn.getRemoteSocketAddress());
            }
            
            @Override
            public void onClose(WebSocket conn, int code, String reason, boolean remote) {
                if (conn.equals(connection)) {
                    connection = null;
                }
                logger.info("WebSocket connection closed: " + reason);
            }
            
            @Override
            public void onMessage(WebSocket conn, String message) {
                try {
                    JsonElement jsonElement = new JsonParser().parse(message);
                    JsonObject jsonMessage = jsonElement.getAsJsonObject();
                    messageHandler.accept(jsonMessage);
                } catch (Exception e) {
                    logger.error("Error parsing WebSocket message: " + e.getMessage());
                }
            }
            
            @Override
            public void onError(WebSocket conn, Exception ex) {
                logger.error("WebSocket error: " + ex.getMessage());
            }
            
            @Override
            public void onStart() {
                logger.info("WebSocket server started on port " + port);
            }
        };
        
        server.start();
        logger.info("Started WebSocket server on port " + port);
    }
    
    /**
     * Stops the WebSocket server.
     */
    public void stopServer() {
        if (server != null) {
            try {
                server.stop();
                logger.info("WebSocket server stopped");
            } catch (Exception e) {
                logger.error("Error stopping WebSocket server: " + e.getMessage());
            } finally {
                server = null;
                connection = null;
            }
        }
    }
    
    /**
     * Sends a message to the connected client.
     *
     * @param message The message to send
     * @return True if the message was sent successfully, false otherwise
     */
    public boolean sendMessage(String message) {
        if (connection != null && connection.isOpen()) {
            connection.send(message);
            return true;
        }
        return false;
    }
    
    /**
     * Checks if a client is connected.
     *
     * @return True if a client is connected, false otherwise
     */
    public boolean isConnected() {
        return connection != null && connection.isOpen();
    }
} 