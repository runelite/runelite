package net.runelite.client.plugins.playerhighlight;

import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.List;
import java.util.Set;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class PlayerHighlightOverlay extends Overlay
{
    private final Client client;
    private final PlayerHighlightPlugin plugin;
    private final PlayerHighlightConfig config;

    @Inject
    PlayerHighlightOverlay(Client client, PlayerHighlightPlugin plugin, PlayerHighlightConfig config)
    {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.client = client;
        this.plugin = plugin;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        for(Player player : plugin.players) {
            var i = player.getConvexHull();
            OverlayUtil.renderPolygon(graphics, i, config.playerHighLightColor());
        }

        return null;
    }
}
