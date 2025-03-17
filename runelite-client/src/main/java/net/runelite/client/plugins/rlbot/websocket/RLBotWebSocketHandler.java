package net.runelite.client.plugins.rlbot.websocket;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.rlbot.RLBotLogger;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

/**
 * Handles WebSocket communication for the RLBot plugin.
 */
public class RLBotWebSocketHandler {

    private final RLBotLogger logger;
    private final ClientThread clientThread;
    private final ObjectMapper objectMapper;
    private final Supplier<JsonNode> gameStateSupplier;
    private final Consumer<String> commandProcessor;
    private final Runnable gameStateGenerator;
    private final Consumer<Boolean> connectionStatusCallback;

    private WebSocketServer webSocketServer;
    private static final long REQUEST_RATE_LIMIT = 100; // Milliseconds between allowed requests

    // Define constants for message types
    private static final String MESSAGE_STATE = "state";
    private static final String MESSAGE_GET_STATE = "getState";

    /**
     * Creates a new RLBotWebSocketHandler.
     *
     * @param logger The logger instance
     * @param clientThread The client thread
     * @param objectMapper The object mapper for JSON
     * @param gameStateSupplier Supplier function that returns the current game state
     * @param commandProcessor Function to process command messages
     * @param gameStateGenerator Function to generate a new game state
     * @param connectionStatusCallback Callback for connection status changes
     */
    public RLBotWebSocketHandler(
            RLBotLogger logger,
            ClientThread clientThread,
            ObjectMapper objectMapper,
            Supplier<JsonNode> gameStateSupplier,
            Consumer<String> commandProcessor,
            Runnable gameStateGenerator,
            Consumer<Boolean> connectionStatusCallback) {
        this.logger = logger;
        this.clientThread = clientThread;
        this.objectMapper = objectMapper;
        this.gameStateSupplier = gameStateSupplier;
        this.commandProcessor = commandProcessor;
        this.gameStateGenerator = gameStateGenerator;
        this.connectionStatusCallback = connectionStatusCallback;
    }

    /**
     * Starts the WebSocket server on the specified port.
     *
     * @param port The port to start the server on
     * @return True if the server started successfully, false otherwise
     */
    public boolean startServer(int port) {
        if (webSocketServer != null) {
            logger.info("WebSocket server already running");
            return true;
        }

        try {
            logger.info("Starting WebSocket server on port " + port);
            
            RLBotWebSocketServer server = new RLBotWebSocketServer(new InetSocketAddress("localhost", port));
            webSocketServer = server;
            
            // Server configuration
            server.setReuseAddr(true);
            server.setConnectionLostTimeout(300); // 5 minutes timeout
            
            // Start the server in a separate thread
            Thread serverThread = new Thread(() -> {
                try {
                    server.start();
                } catch (Exception e) {
                    logger.error("Error in WebSocket server thread: " + e.getMessage());
                    e.printStackTrace();
                }
            }, "websocket-server");
            serverThread.setDaemon(true);
            serverThread.start();
            
            // Wait for server to start
            int maxWaitTime = 10000; // 10 seconds
            long startTime = System.currentTimeMillis();
            while (!server.isStarted() && System.currentTimeMillis() - startTime < maxWaitTime) {
                Thread.sleep(100);
            }
            
            if (!server.isStarted()) {
                logger.error("WebSocket server failed to start within timeout period");
                stopServer();
                return false;
            }
            
            // Notify about connection status
            connectionStatusCallback.accept(true);
            
            // Create a thread to periodically log connection status
            Thread monitorThread = new Thread(() -> {
                try {
                    while (webSocketServer != null) {
                        Thread.sleep(60000); // Log every minute
                        boolean hasConnections = !webSocketServer.getConnections().isEmpty();
                        
                        // Update connection status
                        connectionStatusCallback.accept(hasConnections);
                        
                        if (!hasConnections) {
                            logger.info("WebSocket server running but no active connections");
                        } else {
                            logger.info("WebSocket server has " + webSocketServer.getConnections().size() + " active connections");
                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "ws-monitor");
            monitorThread.setDaemon(true);
            monitorThread.start();
            
            return true;
        } catch (Exception e) {
            logger.error("Error starting WebSocket server: " + e.getMessage());
            e.printStackTrace();
            if (webSocketServer != null) {
                try {
                    webSocketServer.stop();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                webSocketServer = null;
            }
            return false;
        }
    }

    /**
     * Stops the WebSocket server.
     */
    public void stopServer() {
        if (webSocketServer == null) return;

        try {
            webSocketServer.stop();
            logger.info("WebSocket server stopped");
            
            // Update connection status
            connectionStatusCallback.accept(false);
            
        } catch (InterruptedException e) {
            logger.error("Error stopping server: " + e.getMessage());
        }
    }

    /**
     * Broadcasts a message to all connected clients.
     *
     * @param message The message to broadcast
     */
    public void broadcastMessage(String message) {
        if (webSocketServer != null) {
            webSocketServer.broadcast(message);
        }
    }

    /**
     * Checks if the WebSocket server is running.
     *
     * @return True if the server is running, false otherwise
     */
    public boolean isRunning() {
        return webSocketServer != null;
    }

    /**
     * Checks if any clients are connected.
     *
     * @return True if clients are connected, false otherwise
     */
    public boolean hasConnections() {
        return webSocketServer != null && !webSocketServer.getConnections().isEmpty();
    }

    /**
     * WebSocket server implementation for RLBot.
     */
    private class RLBotWebSocketServer extends WebSocketServer {
        private volatile boolean hasStarted = false;
        private final Map<WebSocket, Long> lastRequestTimes = new ConcurrentHashMap<>();
        
        public RLBotWebSocketServer(InetSocketAddress address) {
            super(address);
        }
        
        @Override
        public void onOpen(WebSocket conn, ClientHandshake handshake) {
            String address = conn.getRemoteSocketAddress().toString();
            logger.info("New WebSocket connection established from " + address);
            
            // Record connection time
            lastRequestTimes.put(conn, System.currentTimeMillis());
            
            // Send initial state to new connection using client thread and wait for result
            clientThread.invoke(() -> {
                try {
                    logger.info("Generating initial state for new connection: " + address);
                    JsonNode gameState = gameStateSupplier.get();
                    if (gameState != null) {
                        final String stateJson = objectMapper.writeValueAsString(gameState);
                        conn.send(stateJson);
                        logger.info("Sent initial state to new connection: " + address);
                    } else {
                        logger.error("Failed to generate initial state for: " + address);
                        ObjectNode errorResponse = objectMapper.createObjectNode();
                        errorResponse.put("error", "Failed to generate initial state: The player might not be logged in");
                        conn.send(errorResponse.toString());
                    }
                } catch (Exception e) {
                    logger.error("Error generating initial state: " + e.getMessage());
                    try {
                        ObjectNode errorResponse = objectMapper.createObjectNode();
                        errorResponse.put("error", "Failed to generate initial state: " + e.getMessage());
                        conn.send(errorResponse.toString());
                    } catch (Exception sendError) {
                        logger.error("Error sending error response: " + sendError.getMessage());
                    }
                }
            });
        }

        @Override
        public void onMessage(WebSocket conn, String message) {
            // Apply rate limiting
            long currentTime = System.currentTimeMillis();
            long lastRequestTime = lastRequestTimes.getOrDefault(conn, 0L);
            
            if (currentTime - lastRequestTime < REQUEST_RATE_LIMIT) {
                // Too many requests, send rate limit message
                try {
                    ObjectNode errorResponse = objectMapper.createObjectNode();
                    errorResponse.put("error", "Rate limit exceeded. Please wait before sending more requests.");
                    errorResponse.put("success", false);
                    errorResponse.put("timestamp", System.currentTimeMillis());
                    conn.send(errorResponse.toString());
                    logger.warn("Rate limit exceeded for connection: " + conn.getRemoteSocketAddress());
                    return;
                } catch (Exception e) {
                    logger.error("Error sending rate limit message: " + e.getMessage());
                }
                return;
            }
            
            // Update last request time
            lastRequestTimes.put(conn, currentTime);
            
            // Process message on client thread for game-related operations
            clientThread.invoke(() -> {
                try {
                    logger.info("Processing message: " + message);
                    
                    // Handle state request messages directly
                    if (MESSAGE_STATE.equals(message) || MESSAGE_GET_STATE.equals(message)) {
                        logger.info("Processing state request");
                        
                        // Generate a new game state
                        gameStateGenerator.run();
                        
                        // Get the latest game state
                        final JsonNode gameState = gameStateSupplier.get();
                        
                        // Send response
                        if (gameState != null) {
                            // Check if it's an error state
                            boolean hasError = gameState.has("error");
                            if (hasError) {
                                logger.warn("Game state contains error: " + gameState.get("error").asText());
                            } else {
                                logger.info("Game state generated successfully");
                            }
                            
                            final String response = objectMapper.writeValueAsString(gameState);
                            conn.send(response);
                            logger.info("Sent state in response to request");
                        } else {
                            logger.error("Game state supplier returned null");
                            ObjectNode errorResponse = objectMapper.createObjectNode();
                            errorResponse.put("error", "Failed to generate game state - null returned");
                            errorResponse.put("success", false);
                            errorResponse.put("timestamp", System.currentTimeMillis());
                            conn.send(errorResponse.toString());
                        }
                    } else {
                        // Process command through our commandProcessor
                        logger.info("Processing command: " + message);
                        commandProcessor.accept(message);
                        
                        // After processing the command, send the latest state
                        final JsonNode gameState = gameStateSupplier.get();
                        
                        if (gameState != null) {
                            final String stateJson = objectMapper.writeValueAsString(gameState);
                            conn.send(stateJson);
                            logger.info("Sent state after processing command");
                        } else {
                            logger.error("Game state is null after processing command");
                            ObjectNode errorResponse = objectMapper.createObjectNode();
                            errorResponse.put("error", "Failed to generate game state after command - null returned");
                            errorResponse.put("success", false);
                            errorResponse.put("timestamp", System.currentTimeMillis());
                            conn.send(errorResponse.toString());
                        }
                    }
                } catch (Exception e) {
                    logger.error("Error processing message: " + e.getMessage());
                    e.printStackTrace();
                    
                    try {
                        // Send error response to client
                        ObjectNode errorResponse = objectMapper.createObjectNode();
                        errorResponse.put("error", "Error processing message: " + e.getMessage());
                        errorResponse.put("success", false);
                        errorResponse.put("timestamp", System.currentTimeMillis());
                        conn.send(errorResponse.toString());
                    } catch (Exception sendError) {
                        logger.error("Error sending error response: " + sendError.getMessage());
                    }
                }
            });
        }

        @Override
        public void onClose(WebSocket conn, int code, String reason, boolean remote) {
            logger.info("WebSocket connection closed: " + conn.getRemoteSocketAddress() + 
                    " with code: " + code + ", reason: " + reason + ", remote: " + remote);
            // Clean up connection tracking
            lastRequestTimes.remove(conn);
        }

        @Override
        public void onError(WebSocket conn, Exception ex) {
            logger.error("WebSocket error: " + ex.getMessage());
            if (conn != null) {
                logger.error("Error on connection: " + conn.getRemoteSocketAddress());
            }
        }

        @Override
        public void onStart() {
            logger.info("WebSocket server started successfully");
            hasStarted = true;
        }
        
        public boolean isStarted() {
            return hasStarted;
        }
    }
} 