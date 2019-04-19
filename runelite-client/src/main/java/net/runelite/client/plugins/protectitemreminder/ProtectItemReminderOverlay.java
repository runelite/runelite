package net.runelite.client.plugins.protectitemreminder;

import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.*;

public class ProtectItemReminderOverlay extends Overlay
{
    private final Client client;
    private final ProtectItemReminderPlugin plugin;
    private final ProtectItemReminderConfig config;

    private final String protItemString = "ENABLE PROTECT ITEM";

    @Inject
    private ProtectItemReminderOverlay(Client client, ProtectItemReminderPlugin plugin, ProtectItemReminderConfig config)
    {
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGHEST);
        this.client = client;
        this.plugin = plugin;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!plugin.shouldRemind)
            return null;

        Player localPlayer = client.getLocalPlayer();

        if (localPlayer == null)
            return null;

        net.runelite.api.Point drawPos = localPlayer.getCanvasTextLocation(graphics, protItemString, localPlayer.getLogicalHeight() + config.getHeight());

        if (drawPos != null)
            OverlayUtil.renderTextLocation(graphics, drawPos, protItemString, Color.RED);

        return null;
    }
}
