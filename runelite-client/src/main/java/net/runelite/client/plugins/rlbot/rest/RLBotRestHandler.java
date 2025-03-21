package net.runelite.client.plugins.rlbot.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.rlbot.RLBotLogger;
import net.runelite.client.plugins.rlbot.RLBotConstants;
import spark.Spark;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.Collections;
import java.util.concurrent.Future;

/**
 * Handles REST API endpoints for the RLBot plugin.
 */
public class RLBotRestHandler {
    private final RLBotLogger logger;
    private final ClientThread clientThread;
    private final ObjectMapper objectMapper;
    private final Supplier<JsonNode> gameStateSupplier;
    private final Consumer<String> commandProcessor;
    private final Runnable gameStateGenerator;
    private final Consumer<Boolean> connectionStatusCallback;
    private boolean isRunning = false;

    // Request handling and rate limiting
    private final ExecutorService requestExecutor;
    private final LinkedBlockingQueue<Runnable> requestQueue;
    private final AtomicLong lastRequestTime;
    private static final long REQUEST_RATE_LIMIT = 100; // Minimum time between requests in ms
    private static final int MAX_QUEUE_SIZE = 100;

    public RLBotRestHandler(
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

        // Initialize request handling components
        this.requestQueue = new LinkedBlockingQueue<>(MAX_QUEUE_SIZE);
        this.requestExecutor = Executors.newSingleThreadExecutor(r -> {
            Thread thread = new Thread(r);
            thread.setName("rlbot-request-handler");
            thread.setDaemon(true);
            return thread;
        });
        this.lastRequestTime = new AtomicLong(0);
    }

    /**
     * Starts the REST server on the specified port.
     *
     * @param port The port to start the server on
     * @return True if the server started successfully, false otherwise
     */
    public boolean startServer(int port) {
        if (isRunning) {
            logger.info("REST server already running");
            return true;
        }

        try {
            // Configure Spark
            Spark.port(port);
            
            // Enable CORS
            Spark.before((request, response) -> {
                response.header("Access-Control-Allow-Origin", "*");
                response.header("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
                response.header("Access-Control-Allow-Headers", "Content-Type");
            });

            // Handle OPTIONS requests for CORS
            Spark.options("/*", (request, response) -> {
                String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
                if (accessControlRequestHeaders != null) {
                    response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
                }
                String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
                if (accessControlRequestMethod != null) {
                    response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
                }
                return "OK";
            });

            // GET endpoint for game state
            Spark.get("/state", (request, response) -> {
                response.type("application/json");
                return handleRequest(() -> {
                    try {
                        clientThread.invoke(gameStateGenerator);
                        JsonNode state = gameStateSupplier.get();
                        return state != null ? objectMapper.writeValueAsString(state) : "{}";
                    } catch (JsonProcessingException e) {
                        logger.error("Error serializing game state: " + e.getMessage());
                        return "{\"error\": \"Failed to serialize game state\"}";
                    }
                });
            });

            // POST endpoint for commands
            Spark.post("/command", (request, response) -> handleRequest(() -> {
                try {
                    commandProcessor.accept(request.body());
                    return objectMapper.writeValueAsString(Collections.singletonMap("status", "success"));
                } catch (JsonProcessingException e) {
                    logger.error("Error processing command: " + e.getMessage());
                    return "{\"error\": \"Failed to process command\"}";
                }
            }));

            // Start the server
            Spark.awaitInitialization();
            isRunning = true;
            connectionStatusCallback.accept(true);
            logger.info("REST server started on port " + port);
            return true;

        } catch (Exception e) {
            logger.error("Error starting REST server: " + e.getMessage());
            stopServer();
            return false;
        }
    }

    /**
     * Handles a request with rate limiting and queuing.
     */
    private String handleRequest(Supplier<String> requestHandler) {
        try {
            long currentTime = System.currentTimeMillis();
            long timeSinceLastRequest = currentTime - lastRequestTime.get();
            if (timeSinceLastRequest < REQUEST_RATE_LIMIT) {
                Thread.sleep(REQUEST_RATE_LIMIT - timeSinceLastRequest);
            }

            Future<String> future = requestExecutor.submit(() -> {
                try {
                    return requestHandler.get();
                } catch (Exception e) {
                    logger.error("Error processing request: " + e.getMessage());
                    return "{\"error\": \"Internal server error\"}";
                }
            });

            String result = future.get(5, TimeUnit.SECONDS);
            lastRequestTime.set(System.currentTimeMillis());
            return result;
        } catch (Exception e) {
            logger.error("Error handling request: " + e.getMessage());
            return "{\"error\": \"Internal server error\"}";
        }
    }

    /**
     * Stops the REST server.
     */
    public void stopServer() {
        if (!isRunning) return;

        try {
            requestExecutor.shutdown();
            if (!requestExecutor.awaitTermination(1, TimeUnit.SECONDS)) {
                requestExecutor.shutdownNow();
            }
            
            Spark.stop();
            Spark.awaitStop();
            logger.info("REST server stopped");
            connectionStatusCallback.accept(false);
        } catch (Exception e) {
            logger.error("Error stopping REST server: " + e.getMessage());
        } finally {
            isRunning = false;
        }
    }

    /**
     * Checks if the REST server is running.
     *
     * @return True if the server is running, false otherwise
     */
    public boolean isRunning() {
        return isRunning;
    }
} 