/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.theatre;

import java.awt.*;
import java.util.*;
import javax.inject.Inject;
import net.runelite.api.*;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

public class TheatreOverlay extends Overlay 
{

	private final Client client;
	private final TheatrePlugin plugin;
	private final TheatreConfig config;

	@Inject
	private TheatreOverlay(Client client, TheatrePlugin plugin, TheatreConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;

		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		switch (plugin.getRoom())
		{
			case MAIDEN:
				plugin.getMaidenHandler().render(graphics);
				break;
			case BLOAT:
				plugin.getBloatHandler().render(graphics);
				break;
			case NYLOCAS:
				plugin.getNyloHandler().render(graphics);
				break;
			case SOTETSEG:
				plugin.getSotetsegHandler().render(graphics);
				break;
			case XARPUS:
				plugin.getXarpusHandler().render(graphics);
				break;
			case VERSIK:
				plugin.getVerzikHandler().render(graphics);
				break;
			default:
				break;
		}
		return null;
	}
}