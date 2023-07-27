package net.runelite.client.plugins.alfred.scripts.walker;

import net.runelite.api.GameState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

public class WalkerThread extends Thread {

    private final WalkerConfig config;

    public WalkerThread(WalkerConfig config) {
        this.config = config;
    }

    @Override
    public void run() {
        if (Alfred.getClient().getGameState() != GameState.LOGGED_IN) {
            Alfred.api.account().login();
        }

        if (!config.locations().getName().equals("None")) {
            Alfred.setStatus("Walking to: " + config.locations().getName());
            Alfred.api.walk().walkTo(config.locations().getWorldPoint());

        } else {
            int x = Integer.parseInt(config.xCoordinate());
            int y = Integer.parseInt(config.yCoordinate());
            int z = Integer.parseInt(config.zCoordinate());

            WorldPoint worldPoint = new WorldPoint(x, y, z);
            Alfred.api.walk().walkTo(worldPoint);
        }
    }
}
