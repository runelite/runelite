package net.runelite.client.plugins.worldposition;

import com.google.common.eventbus.Subscribe;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
        name = "World Position",
        description = "An overlay to display your current world position",
        tags = {"world", "position", "overlay", "loudpacks"}
)

public class WorldPositionPlugin extends Plugin {

    private Thread serverThread = null;
    private WorldPoint cachedPosition = null;


    private TCPServer tcpServer;

    @Inject
    private Client client;

    @Override
    protected void startUp() throws Exception {
        tcpServer = new TCPServer(this);
        serverThread = new Thread(tcpServer);
        serverThread.start();
    }

    @Override
    protected void shutDown() throws Exception {
        tcpServer.stop();
        serverThread.join();
    }

    @Subscribe
    private void onGameTick(GameTick tick) {
        if(client.getGameState().equals(GameState.LOGGED_IN)) {
            if (cachedPosition == null || !cachedPosition.equals(client.getLocalPlayer().getWorldLocation())) {
                cachedPosition = client.getLocalPlayer().getWorldLocation();
                tcpServer.addPosition(cachedPosition);
            }
        }
    }
}
