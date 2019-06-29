package net.runelite.client.plugins.spawntimer;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.client.plugins.spawntimer.SpawnTimerPlugin;
import net.runelite.client.plugins.spawntimer.SpawnTimerConfig;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.WildcardMatcher;

import javax.inject.Inject;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SpawnTimerOverlay extends Overlay
{
	private final Client client;
	private final SpawnTimerConfig config;
	private final SpawnTimerPlugin plugin;
	private List<String> highlights = new ArrayList<>();
	@Inject
	SpawnTimerOverlay(Client client, SpawnTimerConfig config, SpawnTimerPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics) 
	{
		highlights = plugin.getHighlights();
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
					renderNpcOverlay(graphics, npc.getNpc(), tickString, config.getHighlightColor());
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