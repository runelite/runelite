package net.runelite.client.plugins.randall;

import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.plugins.randall.event.EventHandler;
import net.runelite.client.plugins.randall.models.PlayerModel;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RandallOverlay extends Overlay {

    @Inject
    private RandallPlugin plugin;
    @Inject
    private Client client;

    @Inject
    private RandallOverlay(RandallPlugin plugin) {
        this.plugin = plugin;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        setPriority(OverlayPriority.HIGHEST);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        getRenderablePlayers().forEach(playerModel -> playerModel.render(graphics));

        for (Point point : plugin.customPoints) {
            graphics.setColor(Color.ORANGE);
            graphics.fillOval(point.x - 3, point.y - 3, 6, 6);
        }

        if (EventHandler.isBlocking()) {
            Point cursorPosition = plugin.mouse.getMousePos();
            graphics.setColor(Color.RED);
            graphics.fillOval(cursorPosition.x - 5, cursorPosition.y - 5, 10, 10);
        }

        return null;
    }

    private List<PlayerModel> getRenderablePlayers() {
        List<PlayerModel> playerModels = new ArrayList<>();
        for (Player player : client.getPlayers()) {
            if (plugin.highlightedPlayers.contains(player.getId())) {
                playerModels.add(new PlayerModel(client, player));
            }
        }
        return playerModels;
    }

}
