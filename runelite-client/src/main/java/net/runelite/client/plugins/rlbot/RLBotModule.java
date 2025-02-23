package net.runelite.client.plugins.rlbot;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.java_websocket.server.WebSocketServer;
import java.net.InetSocketAddress;

public class RLBotModule extends AbstractModule {
    @Override
    protected void configure() {
        // No additional configuration needed
    }

    @Provides
    @Singleton
    WebSocketServer provideWebSocketServer(RLBotConfig config) {
        return new WebSocketServer(new InetSocketAddress(config.getPort())) {
            @Override
            public void onOpen(org.java_websocket.WebSocket conn, org.java_websocket.handshake.ClientHandshake handshake) {
                // Empty implementation - handled by RLBotPlugin
            }

            @Override
            public void onClose(org.java_websocket.WebSocket conn, int code, String reason, boolean remote) {
                // Empty implementation - handled by RLBotPlugin
            }

            @Override
            public void onMessage(org.java_websocket.WebSocket conn, String message) {
                // Empty implementation - handled by RLBotPlugin
            }

            @Override
            public void onError(org.java_websocket.WebSocket conn, Exception ex) {
                // Empty implementation - handled by RLBotPlugin
            }

            @Override
            public void onStart() {
                // Empty implementation - handled by RLBotPlugin
            }
        };
    }
} 