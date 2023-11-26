package net.runelite.client.plugins.playerattacktimer;

import com.google.common.base.Strings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
class PlayerOverlay extends Overlay
{
  private final Client client;
  private final PlayerAttackTimerPlugin plugin;
  private final PlayerAttackTimerConfig config;

  private Player player;

  @Inject
  PlayerOverlay(final Client client, final PlayerAttackTimerPlugin plugin, final PlayerAttackTimerConfig config)
  {
    this.client = client;
    this.plugin = plugin;
    this.config = config;

    setPosition(OverlayPosition.DYNAMIC);
    setPriority(OverlayPriority.HIGH);
    setLayer(OverlayLayer.UNDER_WIDGETS);
  }

  @Override
  public Dimension render(final Graphics2D graphics2D)
  {
    player = client.getLocalPlayer();

    if (player == null)
    {
      return null;
    }

    if (config.debugAnimationIds())
    {
      renderDebugAnimationIds(graphics2D);
    }
    else
    {
      renderPlayerAttackTimer(graphics2D);
    }

    return null;
  }

  private void renderPlayerAttackTimer(final Graphics2D graphics2D)
  {
    final int ticksUntilNextAnimation = plugin.getTicksUntilNextAnimation();

    if (ticksUntilNextAnimation == 0)
    {
      return;
    }

    final String str = String.valueOf(ticksUntilNextAnimation);

    final Point point = player.getCanvasTextLocation(graphics2D, str, 0);

    if (point == null)
    {
      return;
    }

    renderTextLocation(
        graphics2D,
        str,
        config.fontSize(),
        config.fontStyle().getFont(),
        ticksUntilNextAnimation == 1 ? Color.GREEN : config.fontColor(),
        point,
        config.fontShadow(),
        config.fontZOffset() * -1
    );
  }

  private void renderDebugAnimationIds(final Graphics2D graphics2D)
  {
    final String str = "Anim Id: " + player.getAnimation();

    final Point point = player.getCanvasTextLocation(graphics2D, str, 0);

    if (point == null)
    {
      return;
    }

    renderTextLocation(
        graphics2D,
        str,
        config.fontSize(),
        config.fontStyle().getFont(),
        config.fontColor(),
        point,
        config.fontShadow(),
        config.fontZOffset() * -1
    );
  }

  public static void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint, boolean shadows, int yOffset)
  {
    graphics.setFont(new Font("Arial", fontStyle, fontSize));
    if (canvasPoint != null)
    {
      final Point canvasCenterPoint = new Point(
          canvasPoint.getX(),
          canvasPoint.getY() + yOffset);
      final Point canvasCenterPoint_shadow = new Point(
          canvasPoint.getX() + 1,
          canvasPoint.getY() + 1 + yOffset);
      if (shadows)
      {
        renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
      }
      renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
    }
  }

  public static void renderTextLocation(Graphics2D graphics, Point txtLoc, String text, Color color)
  {
    if (Strings.isNullOrEmpty(text))
    {
      return;
    }

    int x = txtLoc.getX();
    int y = txtLoc.getY();

    graphics.setColor(Color.BLACK);
    graphics.drawString(text, x + 1, y + 1);

    graphics.setColor(color);
    graphics.drawString(text, x, y);
  }
}