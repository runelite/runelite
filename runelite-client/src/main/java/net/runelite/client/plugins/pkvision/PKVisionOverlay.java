package net.runelite.client.plugins.pkvision;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;

import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class PKVisionOverlay extends Overlay
{
    private final PKVisionService pkVisionService;
    private final PKVisionConfig config;

    @Inject
    private PKVisionOverlay(PKVisionConfig config, PKVisionService pkVisionService, PKVisionPlugin pkVisionPlugin)
    {
        this.config = config;
        this.pkVisionService = pkVisionService;
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        pkVisionService.forEachPlayer((player, color) -> renderPlayerOverlay(graphics, player, color));
        return null;
    }

    private void renderPlayerOverlay(Graphics2D graphics, Player actor, Color color)
    {
        if (!config.drawPlayerNames() && !config.drawPlayerLevels())
            return;

        String text = "";
        if (config.drawPlayerLevels())
            text += "(" + actor.getCombatLevel() + ") ";

        if (config.drawPlayerNames())
            text += actor.getName().replace('\u00A0', ' ');

        Point textLocation = actor.getCanvasTextLocation(graphics, text, actor.getLogicalHeight() + 40);

        if (textLocation != null)
            OverlayUtil.renderTextLocation(graphics, textLocation, text, color);
    }
}