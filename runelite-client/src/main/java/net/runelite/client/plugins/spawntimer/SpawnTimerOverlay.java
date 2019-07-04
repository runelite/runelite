package net.runelite.client.plugins.spawntimer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.WildcardMatcher;

@Singleton
public class SpawnTimerOverlay extends Overlay
{
	private final SpawnTimerPlugin plugin;

	@Inject
	SpawnTimerOverlay(final SpawnTimerPlugin plugin)
	{
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		List<String> highlights = plugin.getHighlights();
		for (thing npc : plugin.getTicks())
		{
			if (npc == null)
			{
				continue;
			}
			if (npc.getNpc() == null)
			{
				continue;
			}
			if (npc.getNpc().getName() == null)
			{
				continue;
			}
			for (String highlight : highlights)
			{

				if (WildcardMatcher.matches(highlight, npc.getNpc().getName()))
				{
					int tick = plugin.getCurrentTick() - npc.getTick();
					String tickString = "" + tick;
					renderNpcOverlay(graphics, npc.getNpc(), tickString, plugin.getGetHighlightColor());
				}
			}
		}
		return null;
	}

	private void renderNpcOverlay(Graphics2D graphics, NPC actor, String name, Color color)
	{
		Point textLocation = actor.getCanvasTextLocation(graphics, name, actor.getLogicalHeight() - 40);

		if (textLocation != null)
		{
			OverlayUtil.renderTextLocation(graphics, textLocation, name, color);
		}
	}
}