package net.runelite.client.plugins.fightcave;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.util.ImageUtil;

@Singleton
public class FightCaveOverlay extends Overlay
{
	private final FightCavePlugin plugin;
	private final FightCaveConfig config;
	private final Client client;
	private final SpriteManager spriteManager;

	@Inject
	FightCaveOverlay(final Client client, final FightCavePlugin plugin, final FightCaveConfig config, final SpriteManager spriteManager)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.spriteManager = spriteManager;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (FightCaveContainer npc : plugin.getFightCaveContainer())
		{
			if (npc.getNpc() == null)
			{
				continue;
			}

			final int ticksLeft = npc.getTicksUntilAttack();
			final FightCaveContainer.AttackStyle attackStyle = npc.getAttackStyle();

			if (ticksLeft <= 0)
			{
				continue;
			}

			final String ticksLeftStr = String.valueOf(ticksLeft);
			final int font = config.fontStyle().getFont();
			final boolean shadows = config.shadows();
			Color color = (ticksLeft <= 1 ? Color.WHITE : attackStyle.getColor());
			final Point canvasPoint = npc.getNpc().getCanvasTextLocation(graphics, Integer.toString(ticksLeft), 0);

			if (npc.getNpcName().equals("TzTok-Jad"))
			{
				color = (ticksLeft <= 1 || ticksLeft == 8 ? attackStyle.getColor() : Color.WHITE);

				BufferedImage pray = getPrayerImage(npc.getAttackStyle());

				if (pray == null)
				{
					continue;
				}

				renderImageLocation(graphics, npc.getNpc().getCanvasImageLocation(ImageUtil.resizeImage(pray, 36, 36), 0), pray, 12, 30);
			}
			OverlayUtil.renderTextLocation(graphics,canvasPoint,ticksLeftStr,color);
		}

		if (config.tickTimersWidget())
		{

			if (!plugin.getMageTicks().isEmpty())
			{
				widgetHandler(graphics,
						Prayer.PROTECT_FROM_MAGIC,
						plugin.getMageTicks().get(0) == 1 ? Color.WHITE : Color.CYAN,
						Integer.toString(plugin.getMageTicks().get(0)),
						config.shadows()
				);
			}
			if (!plugin.getRangedTicks().isEmpty())
			{
				widgetHandler(graphics,
						Prayer.PROTECT_FROM_MISSILES,
						plugin.getRangedTicks().get(0) == 1 ? Color.WHITE : Color.GREEN,
						Integer.toString(plugin.getRangedTicks().get(0)),
						config.shadows()
				);
			}
			if (!plugin.getMeleeTicks().isEmpty())
			{
				widgetHandler(graphics,
						Prayer.PROTECT_FROM_MELEE,
						plugin.getMeleeTicks().get(0) == 1 ? Color.WHITE : Color.RED,
						Integer.toString(plugin.getMeleeTicks().get(0)),
						config.shadows()
				);
			}
		}
		return null;
	}

	private void widgetHandler(Graphics2D graphics, Prayer prayer, Color color, String ticks, boolean shadows)
	{
		if (prayer != null)
		{
			Rectangle bounds = renderPrayerOverlay(graphics, client, prayer, color);

			if (bounds != null)
			{
				renderTextLocation(graphics, ticks, 16, config.fontStyle().getFont(), color, centerPoint(bounds), shadows);
			}
		}
	}
	public static Rectangle renderPrayerOverlay(Graphics2D graphics, Client client, Prayer prayer, Color color)
	{
		Widget widget = client.getWidget(WidgetID.PRAYER_GROUP_ID);

		if (widget == null)
		{
			return null;
		}

		Rectangle bounds = widget.getBounds();
		renderPolygon(graphics, rectangleToPolygon(bounds), color);
		return bounds;
	}
	public static Polygon rectangleToPolygon(Rectangle rect) {
		int[] xpoints = {rect.x, rect.x + rect.width, rect.x + rect.width, rect.x};
		int[] ypoints = {rect.y, rect.y, rect.y + rect.height, rect.y + rect.height};
		return new Polygon(xpoints, ypoints, 4);
	}
	public static void renderPolygon(Graphics2D graphics, Shape poly, Color color)
	{
		graphics.setColor(color);
		final Stroke originalStroke = graphics.getStroke();
		graphics.setStroke(new BasicStroke(2));
		graphics.draw(poly);
		graphics.setColor(new Color(0, 0, 0, 50));
		graphics.fill(poly);
		graphics.setStroke(originalStroke);
	}

	private BufferedImage getPrayerImage(FightCaveContainer.AttackStyle attackStyle)
	{
		switch (attackStyle)
		{
			case MAGE:
				return spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);
			case MELEE:
				return spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MELEE, 0);
			case RANGE:
				return spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
		}
		return null;
	}

	private void renderImageLocation(Graphics2D graphics, Point imgLoc, BufferedImage image, int xOffset, int yOffset)
	{
		int x = imgLoc.getX() + xOffset;
		int y = imgLoc.getY() - yOffset;

		graphics.drawImage(image, x, y, null);
	}

	private void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint, boolean shadows)
	{
		graphics.setFont(new Font("Arial", fontStyle, fontSize));
		if (canvasPoint != null)
		{
			final Point canvasCenterPoint = new Point(
					canvasPoint.getX() - 3,
					canvasPoint.getY() + 6);
			final Point canvasCenterPoint_shadow = new Point(
					canvasPoint.getX() - 2,
					canvasPoint.getY() + 7);
			if (shadows)
			{
				OverlayUtil.renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
			}
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
		}
	}

	private Point centerPoint(Rectangle rect)
	{
		int x = (int) (rect.getX() + rect.getWidth() / 2);
		int y = (int) (rect.getY() + rect.getHeight() / 2);
		return new Point(x, y);
	}

}

