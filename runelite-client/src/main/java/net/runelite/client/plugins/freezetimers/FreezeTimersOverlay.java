package net.runelite.client.plugins.freezetimers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.*;
import javax.inject.Inject;
import javax.inject.Singleton;

import net.runelite.api.*;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class FreezeTimersOverlay extends Overlay
{
	private final FreezeTimersService FreezeTimersService;
	private final FreezeTimersConfig config;
	private final FreezeTimersPlugin plugin;
	private final SpriteManager spriteManager;
	private final Client client;

	@Inject
	private FreezeTimersOverlay(FreezeTimersConfig config, FreezeTimersService FreezeTimersService, FreezeTimersPlugin plugin, Client client, SpriteManager spriteManager) {
		this.config = config;
		this.FreezeTimersService = FreezeTimersService;
		this.plugin = plugin;
		this.client = client;
		this.spriteManager = spriteManager;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.EnableFreezeTimers()) {
			return null;
		}
		FreezeTimersService.forEachPlayer((player, color) -> renderPlayerOverlay(graphics, player, color));
		return null;
	}

	private void renderPlayerOverlay(Graphics2D graphics, Player actor, Color color)
	{
		int timer = 0;
		String name = actor.getName();
		int freezetype = plugin.freezetype(name);
		int offset = actor.getLogicalHeight() + 30;
		long dtime = plugin.opponentfreezetime(name);
		Point textLocation = null;
		HeadIcon headIcon = actor.getOverheadIcon();
		int freezetime = 0;
		if (freezetype == 1 || freezetype == 4) {
			freezetime = 5000;
		} else if (freezetype == 2 || freezetype == 5) {
			freezetime = 10000;
		} else if (freezetype == 3 || freezetype == 6) {
			freezetime = 15000;
		} else if (freezetype == 7) {
			freezetime = 20000;
		} else if (freezetype == 8) {
			freezetime = 2500;
		} else if (freezetype == 9) {
			freezetime = 5000;
		} else if (freezetype == 10) {
			freezetime = 7500;
		}

		long currenttime = System.currentTimeMillis();
		long timediff = currenttime - dtime;
		timer = (freezetime - (int) timediff) / 1000;

		if (timediff < freezetime) {
			textLocation = actor.getCanvasTextLocation(graphics, Integer.toString(timer), offset);
			textLocation = new Point(textLocation.getX(), textLocation.getY() - 80);
		} else {
			if (timediff < freezetime + 3000) {
				textLocation = actor.getCanvasTextLocation(graphics, Integer.toString(timer), offset);
				textLocation = new Point(textLocation.getX(), textLocation.getY() - 40);
				graphics.setFont(FontManager.getRunescapeBoldFont());
				if (headIcon != null) {
					textLocation = new Point(textLocation.getX(), textLocation.getY() - 40);
				}
				OverlayUtil.renderTextLocation(graphics, textLocation, Integer.toString(timer), color);
				return;
			} else {
				plugin.deleteopponent(name);
			}
		}

		if (textLocation != null)
		{
			BufferedImage clanchatImage = plugin.GetFreezeIcon(freezetype - 1);

			if (clanchatImage != null) {
				int width = clanchatImage.getWidth();
				int textHeight = graphics.getFontMetrics().getHeight() - graphics.getFontMetrics().getMaxDescent();
				Point imageLocation = new Point(textLocation.getX() - 10, textLocation.getY() - 40);
				graphics.setFont(FontManager.getRunescapeFont());
				OverlayUtil.renderTextLocation(graphics, textLocation, Integer.toString(timer), color);
				OverlayUtil.renderImageLocation(graphics, imageLocation, clanchatImage);
			}
		}
	}
}
