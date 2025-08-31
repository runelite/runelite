package net.runelite.client.plugins.rlbot;

import com.google.inject.Singleton;
import java.awt.Point;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.plugins.rlbot.gamestate.RLBotGameStateGenerator;
import net.runelite.client.plugins.rlbot.input.RLBotInputHandler;

@Singleton
public class RLBotAgent {

    private final Client client;
    private final ClientThread clientThread;
    private final RLBotLogger logger;
    private final RLBotConfig config;
    private final RLBotInputHandler inputHandler;
    private final RLBotGameStateGenerator gameStateGenerator;

    private long lastRunMillis;

    @Inject
    public RLBotAgent(
        Client client,
        ClientThread clientThread,
        RLBotLogger logger,
        RLBotConfig config,
        RLBotInputHandler inputHandler,
        DrawManager drawManager
    ) {
        this.client = client;
        this.clientThread = clientThread;
        this.logger = logger;
        this.config = config;
        this.inputHandler = inputHandler;
        this.gameStateGenerator = new RLBotGameStateGenerator(client, logger, new RLBotScreenshotUtil(drawManager, logger, config));
        this.lastRunMillis = 0L;
    }

    public void onTick() {
        if (!config.enableJavaAgent()) {
            return;
        }

        if (client.getGameState() != GameState.LOGGED_IN) {
            return;
        }

        long now = System.currentTimeMillis();
        int interval = Math.max(50, config.agentIntervalMs());
        if (now - lastRunMillis < interval) {
            return;
        }
        lastRunMillis = now;

        // Simple heuristic: click the nearest visible NPC, otherwise rotate camera slightly
        Player local = client.getLocalPlayer();
        if (local == null) {
            return;
        }

        List<NPC> npcs = client.getNpcs();
        NPC target = null;
        int bestDist = Integer.MAX_VALUE;
        WorldPoint lp = local.getWorldLocation();
        for (NPC npc : npcs) {
            if (npc == null || npc.getName() == null) {
                continue;
            }
            WorldPoint nw = npc.getWorldLocation();
            if (nw == null) {
                continue;
            }
            int d = nw.distanceTo(lp);
            if (d >= 0 && d < bestDist) {
                bestDist = d;
                target = npc;
            }
        }

        if (target != null) {
            LocalPoint localPoint = target.getLocalLocation();
            if (localPoint != null) {
                net.runelite.api.Point canvasPointApi = Perspective.localToCanvas(client, localPoint, client.getPlane());
                if (canvasPointApi != null) {
                    Point canvasPoint = new Point(canvasPointApi.getX(), canvasPointApi.getY());
                    logger.debug("[JavaAgent] Clicking NPC: " + target.getName());
                    inputHandler.smoothMouseMove(canvasPoint);
                    inputHandler.click();
                    return;
                }
            }
        }

        // Fallback: light camera nudge using left key
        inputHandler.pressKey(java.awt.event.KeyEvent.VK_LEFT);
    }
}


