package net.runelite.client.plugins.randall;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.WorldService;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.randall.device.Keyboard;
import net.runelite.client.plugins.randall.device.Mouse;
import net.runelite.client.plugins.randall.event.EventHandler;
import net.runelite.client.plugins.randall.http.ContextServer;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.applet.Applet;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@PluginDescriptor(
        name = "Randall",
        description = "Randall does what you want him to.",
        tags = {},
        loadWhenOutdated = true
)
@Slf4j
public class RandallPlugin extends Plugin {

//    @Inject
//    public Supplier<Applet> clientLoader;
    @Inject
    public WorldService worldService;
    @Inject
    public Client client;
    @Inject
    public ClientThread clientThread;
    public Keyboard keyboard;
    public Mouse mouse;
    @Inject
    private Applet applet;
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private ClientToolbar clientToolbar;
    @Inject
    private RandallOverlay overlay;
    private Canvas gameCanvas;
    public InputSelector inputSelector;
    private ContextServer httpServer;

    //    public Map<String, Integer> highlightedPlayers;
    public List<Integer> highlightedPlayers;
    public List<Point> customPoints;

    @Override
    protected void startUp() throws Exception {
//        highlightedPlayers = new ArrayList<>();
//        customPoints = new ArrayList<>();
//
//        EventHandler.setBlocking(false);
//        client.getCanvas();
//
//        overlayManager.add(overlay);
//
//        inputSelector = new InputSelector(clientToolbar);
//        inputSelector.startUp();
//
//        httpServer = new ContextServer(client, this);
//        httpServer.startUp();
//
//        while (this.getCanvas() == null) {
//            Utils.sleep(100);
//        }
//
//        EventHandler.setGameCanvas(this.getCanvas());
//        mouse = new Mouse(this.getCanvas());
//        keyboard = new Keyboard(this.getCanvas());
    }

    @Override
    protected void shutDown() throws Exception {
//        overlayManager.remove(overlay);
//        inputSelector.shutDown();
//        httpServer.shutDown();
    }

    public Canvas getCanvas() {
        if (gameCanvas != null) {
            return gameCanvas;
        }

        if (applet == null || applet.getComponentCount() == 0 || !(applet.getComponent(0) instanceof Canvas)) {
            return null;
        }

        gameCanvas = (Canvas) applet.getComponent(0);
        return gameCanvas;
    }
}
