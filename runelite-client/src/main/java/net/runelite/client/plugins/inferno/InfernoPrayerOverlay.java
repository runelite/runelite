package net.runelite.client.plugins.inferno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class InfernoPrayerOverlay extends Overlay
{
	private static final int TICK_PIXEL_SIZE = 60;
	private static final int BLOB_WIDTH = 10;
	private static final int BLOB_HEIGHT = 5;

	private final InfernoPlugin plugin;
	private final Client client;

	@Inject
	private InfernoPrayerOverlay(final Client client, final InfernoPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGHEST);

		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getWidget(WidgetInfo.PRAYER_PROTECT_FROM_MAGIC).isHidden()
			|| client.getWidget(WidgetInfo.PRAYER_PROTECT_FROM_MISSILES).isHidden())
		{
			return null;
		}

		InfernoJad.Attack prayerForAttack = null;

		if (client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC))
		{
			prayerForAttack = InfernoJad.Attack.MAGIC;
		}
		else if (client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES))
		{
			prayerForAttack = InfernoJad.Attack.RANGE;
		}

		InfernoJad.Attack closestAttack = null;
		int leastTicks = 999;

		for (InfernoJad jad : plugin.getJads())
		{
			if (jad.getNextAttack() == null || jad.getTicksTillNextAttack() < 1)
			{
				continue;
			}

			if (jad.getTicksTillNextAttack() < leastTicks)
			{
				leastTicks = jad.getTicksTillNextAttack();
				closestAttack = jad.getNextAttack();
			}

			if (!plugin.isDescendingBoxes() || !plugin.isShowPrayerHelp()
				|| (plugin.getPrayerOverlayMode() != InfernoPrayerOverlayMode.PRAYER_TAB
				&& plugin.getPrayerOverlayMode() != InfernoPrayerOverlayMode.BOTH))
			{
				continue;
			}

			final Widget prayerWidget = jad.getNextAttack() == InfernoJad.Attack.MAGIC
				? client.getWidget(WidgetInfo.PRAYER_PROTECT_FROM_MAGIC) : client.getWidget(WidgetInfo.PRAYER_PROTECT_FROM_MISSILES);
			int baseX = (int) prayerWidget.getBounds().getX();
			baseX += prayerWidget.getBounds().getWidth() / 2;
			baseX -= BLOB_WIDTH / 2;

			int baseY = (int) prayerWidget.getBounds().getY() - jad.getTicksTillNextAttack() * TICK_PIXEL_SIZE - BLOB_HEIGHT;
			baseY += TICK_PIXEL_SIZE - ((plugin.getLastTick() + 600 - System.currentTimeMillis()) / 600.0 * TICK_PIXEL_SIZE);

			final Polygon blob = new Polygon(new int[]{0, BLOB_WIDTH, BLOB_WIDTH, 0}, new int[]{0, 0, BLOB_HEIGHT, BLOB_HEIGHT}, 4);
			blob.translate(baseX, baseY);

			OverlayUtil.renderPolygon(graphics, blob, Color.ORANGE);
		}

		if (plugin.isShowPrayerHelp() && closestAttack != null
			&& (closestAttack != prayerForAttack || plugin.isIndicateWhenPrayingCorrectly())
			&& (plugin.getPrayerOverlayMode() == InfernoPrayerOverlayMode.PRAYER_TAB
			|| plugin.getPrayerOverlayMode() == InfernoPrayerOverlayMode.BOTH))
		{
			final Widget prayerWidget = closestAttack == InfernoJad.Attack.MAGIC
				? client.getWidget(WidgetInfo.PRAYER_PROTECT_FROM_MAGIC) : client.getWidget(WidgetInfo.PRAYER_PROTECT_FROM_MISSILES);
			final Polygon prayer = new Polygon(
				new int[]{0, (int) prayerWidget.getBounds().getWidth(), (int) prayerWidget.getBounds().getWidth(), 0},
				new int[]{0, 0, (int) prayerWidget.getBounds().getHeight(), (int) prayerWidget.getBounds().getHeight()},
				4);
			prayer.translate((int) prayerWidget.getBounds().getX(), (int) prayerWidget.getBounds().getY());

			Color prayerColor;
			if (closestAttack == prayerForAttack)
			{
				prayerColor = Color.GREEN;
			}
			else
			{
				prayerColor = Color.RED;
			}

			OverlayUtil.renderPolygon(graphics, prayer, prayerColor);
		}

		if (plugin.isIndicateActiveHealers())
		{
			for (NPC healer : plugin.getActiveHealers())
			{
				if (healer.getConvexHull() == null)
				{
					continue;
				}

				OverlayUtil.renderPolygon(graphics, healer.getConvexHull(), Color.CYAN);
			}
		}

		return null;
	}
}
